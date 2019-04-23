package com.dt.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonWarehouse;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.model.ParentUploadInfo;
import com.dt.user.model.RealTimeData;
import com.dt.user.model.SalesAmazon.*;
import com.dt.user.model.UserUpload;
import com.dt.user.netty.ChatServiceImpl;
import com.dt.user.netty.ChatType;
import com.dt.user.service.BasePublicService.*;
import com.dt.user.service.ConsumerService;
import com.dt.user.service.FinancialImportService.FinancialSalesBalanceService;
import com.dt.user.service.RedisService;
import com.dt.user.service.SalesAmazonService.*;
import com.dt.user.service.UserService;
import com.dt.user.service.UserUploadService;
import com.dt.user.store.FsbStore;
import com.dt.user.store.RealTimeDataStore;
import com.dt.user.store.UploadStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.*;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Future;

/**
 * 文件处理数据接口
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {


    @Autowired
    private SalesAmazonFbaBusinessreportService busService;

    @Autowired
    private FinancialSalesBalanceService fsbService;

    @Autowired
    private SalesAmazonAdCprService cprService;

    @Autowired
    private SalesAmazonAdStrService strService;

    @Autowired
    private SalesAmazonAdOarService oarService;

    @Autowired
    private SalesAmazonAHlService hlService;


    @Autowired
    private BasicPublicAmazonTypeService AmazontypeService;
    @Autowired
    private BasicSalesAmazonWarehouseService warehouseService;

    @Autowired
    private BasicPublicSiteService siteService;

    @Autowired
    private BasicPublicShopService shopService;

    @Autowired
    private BasicPublicSkuService skuService;

    @Autowired
    private BasicSalesAmazonCsvTxtXslHeaderService headService;

    @Autowired
    private SalesAmazonFbaTradeReportService tradeReportService;

    @Autowired
    private SalesAmazonFbaRefundService refundService;

    @Autowired
    private SalesAmazonFbaReceivestockService receiveStockService;

    @Autowired
    private SalesAmazonFbaInventoryEndService endService;
    @Autowired
    private SalesAmazonFbaMonthWarehouseFeeService mWarService;
    @Autowired
    private SalesAmazonFbaLongWarehousefeeServcie lWService;
    @Autowired
    private SalesAmazonFbaAbandonService abandonService;
    @Autowired
    private SalesAmazonFbaHandlingFeeService hLFeeService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserUploadService userUploadService;
    /**
     * 多线程返回接收
     */
    private Future<ResponseBase> future;
    /**
     * 没有sku有几行存入
     */
    private ThreadLocal<Long> numberCount = ThreadLocal.withInitial(() -> 0L);
    /**
     * 真实存入
     */
    private ThreadLocal<Long> count = ThreadLocal.withInitial(() -> 0L);
    /**
     * 没有sku存入
     */
    private ThreadLocal<Integer> sumErrorSku = ThreadLocal.withInitial(() -> 0);
    /**
     * 获取没有SKU的List集合
     */
    private ThreadLocal<List<List<String>>> noSkuList = new ThreadLocal<>();

    /**
     * 实时数据Set集合
     */
    private ThreadLocal<Set<RealTimeData>> timeDataSet = new ThreadLocal<>();
    @Autowired
    private RedisService redisService;

    @Autowired
    private ChatServiceImpl chatService;
    //#######################Txt

    public void clear() {
        //清空set
        ThreadLocalUtils.clearSetThread(timeDataSet);
        //清空List
        ThreadLocalUtils.clearListThread(noSkuList);
        //重置count
        count.set(0L);
        //重置numberCount
        numberCount.set(0L);
    }

    /**
     * 异步处理Txt数据
     *
     * @param uuIdName
     * @param saveFilePath
     * @param fileName
     * @param shopId
     * @param uid
     * @param recordingId
     * @param tbId
     * @param aId
     * @return
     */
    @Override
    @Transactional
    @Async("executor")
    public Future<ResponseBase> importTxt(String uuIdName, String saveFilePath, String fileName, Integer shopId, Long uid, Long recordingId, Integer tbId, Integer aId) throws Exception {
        future = new AsyncResult<>(threadTxt(uuIdName, saveFilePath, fileName, shopId, uid, recordingId, tbId, aId));
        return future;
    }


    private ResponseBase threadTxt(String uuIdName, String saveFilePath, String fileName, Integer shopId, Long uid, Long recordingId, Integer menuId, Integer aId) throws Exception {
        String filePath = saveFilePath + uuIdName;
        try (InputStreamReader read = FileUtils.streamReader(filePath);
             BufferedReader br = new BufferedReader(read)
        ) {
            //拿到数据库的表头 进行校验
            List<String> head = getHeadInfo(null, menuId, aId, shopId);
            //拿到文件的第一行头信息
            String lineHead = br.readLine();
            List<String> txtHead = Arrays.asList(lineHead.split("\t"));
            //对比头部
            boolean isFlg = ArrUtils.eqOrderList(head, txtHead);
            if (!isFlg) {
                //更新信息
                return setErrorInfo(recordingId, Constants.HEADER_EXCEPTION, JsonUtils.json(head));
            }
            //创建对象设置文件总数
            RealTimeData timeData = RealTimeDataStore.getTimeData(filePath);
            //多线程处理
            ResponseBase responseTxt = saveTxt(br, shopId, uid, recordingId, lineHead, menuId, aId, timeData, txtHead);
            return saveUserUploadInfo(responseTxt, recordingId, fileName, null, 3, saveFilePath, uuIdName);
        } finally {
            clear();
        }
    }

    /**
     * @param br
     * @param shopId
     * @param uid
     * @param recordingId
     * @param lineHead
     * @param menuId
     * @param aId
     * @param timeData
     * @param txtHead     是切割好的表头
     * @return
     */
    private ResponseBase saveTxt(BufferedReader br, Integer shopId, Long uid, Long
            recordingId, String lineHead, Integer menuId, Integer aId, RealTimeData timeData, List<String> txtHead) {
        // 开始时间
        Long begin = new Date().getTime();
        List<SalesAmazonFbaReceivestock> sfReceivesList = null;
        List<SalesAmazonFbaRefund> safRefundList = null;
        List<SalesAmazonFbaTradeReport> safTradList = null;
        List<SalesAmazonFbaInventoryEnd> safEndList = null;
        List<SalesAmazonFbaMonthWarehouseFee> mWarList = null;
        List<SalesAmazonFbaLongWarehouseFee> lwList = null;
        List<SalesAmazonFbaAbandon> abandonList = null;
        List<?> tList = new ArrayList<>();
        //获得数据库是否存入的信息
        List<BasicSalesAmazonCsvTxtXslHeader> isImportHead = headService.sqlHead(null, menuId, aId, shopId);
        //通过uid 查找账号
        String userName = userService.serviceGetName(uid);
        //设置第一行头信息List 设置的是字符串
        List<String> txtHeadList = UploadStore.setLineHeadList(lineHead);
        String line;
        int index = 0;
        int k = 0;
        Map<String, Integer> intMap = new HashMap<>();
        //获得 ctx 对象
        ChannelHandlerContext ctx = chatService.getCtx(uid);
        try {
            while ((line = br.readLine()) != null) {
                //numberCount++
                ThreadLocalUtils.inCreateNumberLong(numberCount);
                //count ++ 成功数量
                ThreadLocalUtils.inCreateNumberLong(count);
                // 一次读入一行数据
                String[] newLine = line.split("\t", -1);
                switch (menuId) {
                    //订单报告
                    case 109:
                        safTradList = ArrUtils.listT(tList);
                        SalesAmazonFbaTradeReport sftPort = setTraPort(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            sftPort = setTradeReport(i, sftPort, newLine, shopId, txtHead, isImportHead);
                            if (isObjNull(sftPort, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (sftPort != null) {
                            safTradList.add(sftPort);
                        }
                        break;
                    //退货报告
                    case 110:
                        safRefundList = ArrUtils.listT(tList);
                        SalesAmazonFbaRefund sfRefund = setRefund(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            sfRefund = setAmazonFbaRefund(i, sfRefund, newLine, shopId, aId, txtHead, isImportHead);
                            if (isObjNull(sfRefund, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (sfRefund != null) {
                            safRefundList.add(sfRefund);
                        }
                        break;
                    //接收库存
                    case 113:
                        sfReceivesList = ArrUtils.listT(tList);
                        SalesAmazonFbaReceivestock sfReceives = setReceives(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            sfReceives = setReceiveStock(i, sfReceives, newLine, txtHead, shopId, isImportHead);
                            if (isObjNull(sfReceives, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (sfReceives != null) {
                            sfReceivesList.add(sfReceives);
                        }
                        break;
                    //期末库存
                    case 114:
                        safEndList = ArrUtils.listT(tList);
                        SalesAmazonFbaInventoryEnd sfEnd = setEnd(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            sfEnd = setSalesEnd(i, sfEnd, newLine, txtHead, isImportHead);
                            if (isObjNull(sfEnd, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (sfEnd != null) {
                            safEndList.add(sfEnd);
                        }
                        break;
                    //月度仓储费用
                    case 269:
                        mWarList = ArrUtils.listT(tList);
                        SalesAmazonFbaMonthWarehouseFee mWar = setMWar(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            mWar = setMonthWarehouseFee(i, mWar, newLine, txtHead, isImportHead);
                            if (isObjNull(mWar, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (mWar != null) {
                            mWarList.add(mWar);
                        }
                        break;
                    //长期仓储费用
                    case 270:
                        lwList = ArrUtils.listT(tList);
                        SalesAmazonFbaLongWarehouseFee lWar = setLWar(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            lWar = setLongWarehouseFee(i, lWar, newLine, txtHead, isImportHead);
                            if (isObjNull(lWar, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (lWar != null) {
                            lwList.add(lWar);
                        }
                        break;
                    case 325:
                        //FBA遗弃
                        abandonList = ArrUtils.listT(tList);
                        SalesAmazonFbaAbandon abandon = setAbandon(shopId, userName, recordingId, aId);
                        for (int i = 0; i < newLine.length; i++) {
                            k = i;
                            abandon = setFbaAbandon(i, abandon, newLine, txtHead, isImportHead);
                            if (isObjNull(abandon, txtHeadList, line) == -1) {
                                break;
                            }
                        }
                        if (abandonList != null) {
                            abandonList.add(abandon);
                        }
                        break;
                }
                index++;
                //设置进度 传输
                sendRealTimeData(ctx, intMap, timeData, index + 1);
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                return setErrorInfo(recordingId, "====>参数空指针异常" + e.getMessage(), null);
            }
            chatService.sendMessage(ctx, JsonUtils.getJsonTypeError("error", ChatType.PROGRESS_BAR));
            return setErrorInfo(recordingId, "出错字段" + txtHead.get(k) + "下" + (numberCount.get() + 1) + "行信息错误,错误原因," + e.getMessage(), null);
        }
        int countTrad = 0;
        try {
            if (safTradList != null && safTradList.size() > 0) {
                countTrad = tradeReportService.serviceAddSalesAmazonAdTrdList(safTradList);
            } else if (safRefundList != null && safRefundList.size() > 0) {
                countTrad = refundService.serviceAddSalesAmazonAdRefundList(safRefundList);
            } else if (sfReceivesList != null && sfReceivesList.size() > 0) {
                countTrad = receiveStockService.addSalesAmazonAdReceivestockList(sfReceivesList);
            } else if (safEndList != null && safEndList.size() > 0) {
                countTrad = endService.addSalesAmazonAdInventoryEndList(safEndList);
            } else if (mWarList != null && mWarList.size() > 0) {
                countTrad = mWarService.serviceSaveAmazonMonthWar(mWarList);
            } else if (lwList != null && lwList.size() > 0) {
                countTrad = lWService.serviceSetAmazonLongWar(lwList);
            } else if (abandonList != null && abandonList.size() > 0) {
                countTrad = abandonService.serviceSetSalesAmazonAbandonList(abandonList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            chatService.sendMessage(ctx, JsonUtils.getJsonTypeError("error", ChatType.PROGRESS_BAR));
            return setErrorInfo(recordingId, "数据库存入异常", null);
        }
        if (countTrad != 0) {
            return printCount(begin, count.get(), index, ctx);
        }
        return JsonData.setResultError("存入数据失败,所有数据都不匹配");
    }

    /**
     * 设置FBA遗弃对象
     *
     * @param i
     * @param ab
     * @param j
     * @param txtHeadList
     * @param isImportHead
     * @return
     */
    private SalesAmazonFbaAbandon setFbaAbandon(int i, SalesAmazonFbaAbandon ab, String[] j,
                                                List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            ab.setDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            ab.setOrderId(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            ab.setOrderType(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            ab.setOrderStatus(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            ab.setLastUpdatedDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            ab.setAbandonSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            ab.setFnSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose()) {
            ab.setDisposition(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(8).getImportTemplet()) && isImportHead.get(8).getOpenClose()) {
            ab.setRequestedQuantity(StrUtils.repLong(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(9).getImportTemplet()) && isImportHead.get(9).getOpenClose()) {
            ab.setCancelledQuantity(StrUtils.repInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(10).getImportTemplet()) && isImportHead.get(10).getOpenClose()) {
            ab.setDisposedQuantity(StrUtils.repInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(11).getImportTemplet()) && isImportHead.get(11).getOpenClose()) {
            ab.setShippedQuantity(StrUtils.repInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(12).getImportTemplet()) && isImportHead.get(12).getOpenClose()) {
            ab.setInProcessQuantity(StrUtils.repInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(13).getImportTemplet()) && isImportHead.get(13).getOpenClose()) {
            ab.setRemovalFee(StrUtils.repDecimal(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(14).getImportTemplet()) && isImportHead.get(14).getOpenClose()) {
            //币别
            String currency = StrUtils.repString(j[i]);
            //这里判断不为null的
            if (StringUtils.isNotBlank(currency)) {
                //通过币别去查找站点ID
                Integer seId = siteService.getCurrencySiteId(currency);
                if (seId == null) {
                    return null;
                }
            } else {
                //如果是null 的直接存了
                ab.setCurrency(StrUtils.repString(j[i]));
            }
        }
        if (i + 1 == j.length) {
            Long skuId = skuService.selSkuId(ab.getShopId(), ab.getSiteId(), ab.getAbandonSku());
            if (skuId == null) return null;
            ab.setSkuId(skuId);
        }
        return ab;
    }

    /**
     * 设置 长期仓库费对象
     *
     * @param i
     * @param lWar
     * @param j
     * @param txtHeadList
     * @param isImportHead
     * @return
     */
    private SalesAmazonFbaLongWarehouseFee setLongWarehouseFee(int i, SalesAmazonFbaLongWarehouseFee lWar, String[]
            j,
                                                               List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            lWar.setDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            lWar.setLwSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            lWar.setFnSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            lWar.setAsin(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            lWar.setProductName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            lWar.setCondition(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            lWar.setQtyChargedSixMoLongTermStorageFee(StrUtils.repInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose()) {
            lWar.setPerUnitVolume(StrUtils.repDecimal(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(8).getImportTemplet()) && isImportHead.get(8).getOpenClose()) {
            lWar.setCurrency(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(9).getImportTemplet()) && isImportHead.get(9).getOpenClose()) {
            lWar.setTwelveMoLongTermsStorageFee(StrUtils.repDecimal(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(10).getImportTemplet()) && isImportHead.get(10).getOpenClose()) {
            lWar.setQtyChargedSixMoLongTermStorageFee(StrUtils.repInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(11).getImportTemplet()) && isImportHead.get(11).getOpenClose()) {
            lWar.setSixMoLongTermsStorageFee(StrUtils.repDecimal(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(12).getImportTemplet()) && isImportHead.get(12).getOpenClose()) {
            lWar.setVolumeUnit(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(13).getImportTemplet()) && isImportHead.get(13).getOpenClose()) {
            lWar.setCountry(StrUtils.repString(j[i]));
            //这里通过文件里的公司名 去查找站点ID
            String siteName = StrUtils.repString(j[i]);
            if (StringUtils.isBlank(siteName)) return null;
            //这里的是通过country 所以第二个参数是null
            Integer seId = siteService.serviceGetSiteId(siteName, null);
            if (seId == null) return null;
            lWar.setCountry(siteName);
            lWar.setSiteId(seId);
        } else if (txtHeadList.get(i).equals(isImportHead.get(14).getImportTemplet()) && isImportHead.get(14).getOpenClose()) {
            lWar.setEnrolledInSmallAndLight(StrUtils.repString(j[i]));
        }

        if (i + 1 == j.length) {
            String result = setThisId(lWar.getShopId(), lWar.getSiteId(), lWar.getAsin(), lWar);
            if (result == null) {
                return null;
            }
        }
        return lWar;
    }

    /**
     * 设置月度报告实体
     *
     * @param i
     * @param mWar
     * @param j
     * @param txtHeadList
     * @param isImportHead
     * @return
     */
    private SalesAmazonFbaMonthWarehouseFee setMonthWarehouseFee(int i, SalesAmazonFbaMonthWarehouseFee
            mWar, String[] j,
                                                                 List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            mWar.setAsin(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            mWar.setFnSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            mWar.setProductName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            String fc = StrUtils.repString(j[i]);
            BasicSalesAmazonWarehouse warehouse = warehouseService.getWarehouse(fc);
            if (warehouse == null) return null;
            mWar.setFc(fc);
            mWar.setAwId(warehouse.getAmazonWarehouseId());
            mWar.setSiteId(warehouse.getSiteId());
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            mWar.setCountryCode(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            mWar.setLongestSide(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            mWar.setMedianSide(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose()) {
            mWar.setShortestSide(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(8).getImportTemplet()) && isImportHead.get(8).getOpenClose()) {
            mWar.setMeasurementUnits(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(9).getImportTemplet()) && isImportHead.get(9).getOpenClose()) {
            mWar.setWeight(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(10).getImportTemplet()) && isImportHead.get(10).getOpenClose()) {
            mWar.setWeightUnits(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(11).getImportTemplet()) && isImportHead.get(11).getOpenClose()) {
            mWar.setItemVolume(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(12).getImportTemplet()) && isImportHead.get(12).getOpenClose()) {
            mWar.setVolumeUnits(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(13).getImportTemplet()) && isImportHead.get(13).getOpenClose()) {
            mWar.setProductSizeTier(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(14).getImportTemplet()) && isImportHead.get(14).getOpenClose()) {
            mWar.setAverageQuantityOnHand(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(15).getImportTemplet()) && isImportHead.get(15).getOpenClose()) {
            mWar.setAverageQuantityPendingRemoval(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(16).getImportTemplet()) && isImportHead.get(16).getOpenClose()) {
            mWar.setEstimatedTotalItemVolume(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(17).getImportTemplet()) && isImportHead.get(17).getOpenClose()) {
            mWar.setMonthOfCharge(DateUtils.getTime(j[i], Constants.MONTHLY_REPORT));
        } else if (txtHeadList.get(i).equals(isImportHead.get(18).getImportTemplet()) && isImportHead.get(18).getOpenClose()) {
            mWar.setStorageRate(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(19).getImportTemplet()) && isImportHead.get(19).getOpenClose()) {
            mWar.setCurrency(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(20).getImportTemplet()) && isImportHead.get(20).getOpenClose()) {
            mWar.setEstimatedMonthlyStorageFee(StrUtils.repDouble(j[i]));
        }
        if (i + 1 == j.length) {
            String result = setThisId(mWar.getShopId(), mWar.getSiteId(), mWar.getAsin(), mWar);
            if (result == null) {
                return null;
            }
        }
        return mWar;
    }

    /**
     * 设置继承ParentUploadInfo的SKUID
     *
     * @param i    循环下标
     * @param j    一行最大的长度
     * @param sId  店铺ID
     * @param seId 站点ID
     * @param Asin Asin
     * @return
     */
    private String setThisId(int sId, int seId, String Asin, ParentUploadInfo p) {
        Long skuId = skuService.getAsinSkuId(sId, seId, Asin);
        if (skuId != null) {
            p.setSkuId(skuId);
            return "ok";
        }
        return null;
    }

    /**
     * 期末库存信息存入
     *
     * @param ie
     * @param j
     * @return
     * @throws IOException
     */
    private SalesAmazonFbaInventoryEnd setSalesEnd(int i, SalesAmazonFbaInventoryEnd ie, String[] j,
                                                   List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {

        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            ie.setDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            ie.setFnSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            ie.setInvSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            ie.setProductName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            ie.setQuantity(StrUtils.replaceInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            String fc = StrUtils.repString(j[i]);
            BasicSalesAmazonWarehouse warehouse = warehouseService.getWarehouse(fc);
            if (warehouse == null) return null;
            ie.setFc(fc);
            ie.setSiteId(warehouse.getSiteId());
            ie.setAwId(warehouse.getAmazonWarehouseId());
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            ie.setDisposition(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose()) {
            ie.setCountry(StrUtils.repString(j[i]));
        }
        return ie;
    }

    /**
     * 接收订单信息存入
     *
     * @param fr
     * @param j
     * @return
     * @throws IOException
     */
    private SalesAmazonFbaReceivestock setReceiveStock(int i, SalesAmazonFbaReceivestock fr, String[] j,
                                                       List<String> txtHeadList, Integer shopId, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            fr.setDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            fr.setFnSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            String recSku = StrUtils.repString(j[i]);
            if (StringUtils.isEmpty(recSku)) {
                return null;
            }
            fr.setRecSku(recSku);
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            fr.setProductName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            fr.setQuantity(StrUtils.replaceInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            fr.setFbaShipmentId(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            String fc = StrUtils.repString(j[i]);
            BasicSalesAmazonWarehouse warehouse = warehouseService.getWarehouse(fc);
            if (warehouse == null) return null;
            fr.setFc(fc);
            fr.setAwId(warehouse.getAmazonWarehouseId());
            fr.setSiteId(warehouse.getSiteId());
            //设置skuId
            boolean isFlg = skuEqSku(fr.getRecSku(), shopId, fr.getSiteId(), fr);
            if (!isFlg) {
                return null;
            }
        }
        return fr;
    }

    /**
     * 退货报告信息存入
     *
     * @param sft
     * @param j
     * @return
     * @throws IOException
     */
    private SalesAmazonFbaRefund setAmazonFbaRefund(int i, SalesAmazonFbaRefund sft, String[] j, Integer
            sId, Integer aId,
                                                    List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            sft.setDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            String orderId = StrUtils.repString(j[i]);
            if (StringUtils.isEmpty(orderId)) {
                return null;
            }
            sft.setOrderId(orderId);
            //查询 获得site Id
            SalesAmazonFbaTradeReport serviceReport = tradeReportService.getReport(sId, orderId);
            if (serviceReport == null) {
                return null;
            }
            //如果有一个是空的 就返回null
            if (serviceReport.getDate() == null || serviceReport.getSiteId() == null) {
                return null;
            }
            sft.setSiteId(serviceReport.getSiteId());
            sft.setPurchaseDate(serviceReport.getDate());
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            sft.setRefSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            sft.setsAsin(StrUtils.repString(j[i]));
            boolean isFlgId = skuEqAsin(sft.getSku(), sft.getsAsin(), sId, sft.getSiteId(), sft);
            if (!isFlgId) {
                return null;
            }
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            sft.setFnSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            sft.setpName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            sft.setQuantity(StrUtils.replaceInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose()) {
            sft.setFc(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(8).getImportTemplet()) && isImportHead.get(8).getOpenClose()) {
            sft.setDetailedDisposition(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(9).getImportTemplet()) && isImportHead.get(9).getOpenClose()) {
            sft.setReason(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(10).getImportTemplet()) && isImportHead.get(10).getOpenClose()) {
            sft.setRefundStatus(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(11).getImportTemplet()) && isImportHead.get(11).getOpenClose()) {
            sft.setLicensePlateNumber(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(12).getImportTemplet()) && isImportHead.get(12).getOpenClose()) {
            sft.setCustomerRemarks(StrUtils.repString(j[i]));
        }
        return sft;
    }

    /**
     * 订单报告信息存入
     *
     * @param sft
     * @param j
     * @return
     * @throws IOException
     */
    private SalesAmazonFbaTradeReport setTradeReport(int i, SalesAmazonFbaTradeReport sft, String[] j,
                                                     Integer sId, List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        //下标对应  并且 是开启导入状态

        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            sft.setAmazonOrderId(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose())
            sft.setMerchantOrderId(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose())
            sft.setDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose())
            sft.setLastUpdatedDate(DateUtils.getTime(j[i], Constants.GP_DATE));
        else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose())
            sft.setOrderStatus(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            sft.setFulfillmentChannel(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            String siteUrl = StrUtils.repString(j[i]);
            sft.setSalesChannel(siteUrl);
            //查询 获得site Id
            Integer siteId = siteService.serviceGetUrlSiteId(siteUrl);
            if (siteId == null) {
                return null;
            }
            sft.setSiteId(siteId);
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose())
            sft.setOrderChannel(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(8).getImportTemplet()) && isImportHead.get(8).getOpenClose())
            sft.setUrl(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(9).getImportTemplet()) && isImportHead.get(9).getOpenClose())
            sft.setShipServiceLevel(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(10).getImportTemplet()) && isImportHead.get(10).getOpenClose())
            sft.setProductName(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(11).getImportTemplet()) && isImportHead.get(11).getOpenClose()) {
            sft.setTradeSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(12).getImportTemplet()) && isImportHead.get(12).getOpenClose()) {
            sft.setAsin(StrUtils.repString(j[i]));
            boolean isFlgId = skuEqAsin(sft.getSku(), sft.getAsin(), sId, sft.getSiteId(), sft);
            if (!isFlgId) {
                return null;
            }
        } else if (txtHeadList.get(i).equals(isImportHead.get(13).getImportTemplet()) && isImportHead.get(13).getOpenClose())
            sft.setItemStatus(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(14).getImportTemplet()) && isImportHead.get(14).getOpenClose())
            sft.setQuantity(StrUtils.replaceInteger(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(15).getImportTemplet()) && isImportHead.get(15).getOpenClose())
            sft.setCurrency(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(16).getImportTemplet()) && isImportHead.get(16).getOpenClose())
            sft.setItemPrice(StrUtils.repDouble(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(17).getImportTemplet()) && isImportHead.get(17).getOpenClose())
            sft.setItemTax(StrUtils.repDouble(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(18).getImportTemplet()) && isImportHead.get(19).getOpenClose()) {
            sft.setShippingPrice(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(19).getImportTemplet()) && isImportHead.get(19).getOpenClose()) {
            sft.setShippingTax(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(20).getImportTemplet()) && isImportHead.get(20).getOpenClose()) {
            sft.setGiftWrapPrice(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(21).getImportTemplet()) && isImportHead.get(21).getOpenClose()) {
            sft.setGiftWrapTax(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(22).getImportTemplet()) && isImportHead.get(22).getOpenClose()) {
            sft.setItemPromotionDiscount(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(23).getImportTemplet()) && isImportHead.get(23).getOpenClose()) {
            sft.setShipPromotionDiscount(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(24).getImportTemplet()) && isImportHead.get(24).getOpenClose()) {
            sft.setShipCity(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(25).getImportTemplet()) && isImportHead.get(25).getOpenClose()) {
            sft.setShipState(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(26).getImportTemplet()) && isImportHead.get(26).getOpenClose()) {
            sft.setShipPostalCode(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(27).getImportTemplet()) && isImportHead.get(27).getOpenClose()) {
            sft.setShipCountry(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(28).getImportTemplet()) && isImportHead.get(28).getOpenClose()) {
            sft.setPromotionIds(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(29).getImportTemplet()) && isImportHead.get(29).getOpenClose()) {
            sft.setIsBusinessOrder(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(30).getImportTemplet()) && isImportHead.get(30).getOpenClose()) {
            sft.setPurchaseOrderNumber(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(31).getImportTemplet()) && isImportHead.get(31).getOpenClose()) {
            sft.setPriceDesignation(StrUtils.repString(j[i]));
        }
        return sft;
    }

    //#######################Txt
    //#######################Xls
    @Override
    @Transactional
    @Async("executor")
    public Future<ResponseBase> importXls(String uuIdName, String saveFilePath, String fileName, Integer
            siteId, Integer shopId, Long uid, Long recordingId, Integer tbId) throws Exception {
        future = new AsyncResult<>(threadXls(uuIdName, saveFilePath, fileName, siteId, shopId, uid,
                recordingId, tbId));
        return future;
    }


    private ResponseBase threadXls(String uuIdName, String saveFilePath, String fileName, Integer
            siteId, Integer
                                           shopId, Long uid, Long
                                           recordingId, Integer menuId) throws Exception {
        String filePath = saveFilePath + uuIdName;
        //判断文件类型 fileType()
        File file = new File(filePath);
        try (FileInputStream in = new FileInputStream(filePath);
             Workbook wb = XlsUtils.fileType(in, file)) {
            if (wb == null) {
                //返回错误信息
                return setErrorInfo(recordingId, "不是excel文件", null);
            }
            Sheet sheet = wb.getSheetAt(0);
            int totalNumber = sheet.getRow(0).getPhysicalNumberOfCells(); //获取总列数
            //拿到数据库的表头
            List<String> sqlHead = getHeadInfo(siteId, menuId, null, shopId);
            //获取xls里第一行表头
            List<String> xlsListHead = XlsUtils.getXlsHead(sheet, totalNumber);
            //对比表头
            boolean isFlg = compareHeadXls(xlsListHead, sqlHead);
            //如果表头对比失败
            if (!isFlg) {
                return setErrorInfo(recordingId, Constants.HEADER_EXCEPTION, JsonUtils.json(sqlHead));
            }
            ResponseBase responseXls = saveXls(shopId, siteId, uid, recordingId, totalNumber, sqlHead, menuId, sheet, xlsListHead);
            return saveUserUploadInfo(responseXls, recordingId, fileName, null, 1, filePath, uuIdName);
        } finally {
            clear();
        }
    }

    /**
     * 读取Cprxls 信息
     *
     * @param shopId
     * @param siteId
     * @param uid
     * @param recordingId
     * @param totalNumber
     * @param sheet
     * @return
     */
    private ResponseBase saveXls(Integer shopId, Integer siteId, Long uid, Long
            recordingId, int totalNumber, List<String> sqlHead, Integer menuId, Sheet sheet, List<String> xlsListHead) {
        // 开始时间
        Long begin = new Date().getTime();
        Row row;
        Cell cell;
        List<SalesAmazonAdCpr> cprList = null;
        List<SalesAmazonAdStr> strList = null;
        List<SalesAmazonAdOar> oarList = null;
        List<SalesAmazonAdHl> hlList = null;
        List<SalesAmazonFbaHandlingFee> hFeesList = null;
        List<?> tList = new ArrayList<>();
        int index = 0;
        int lastRowNum = sheet.getLastRowNum(); // 获取总行数
        //创建对象设置文件总数
        RealTimeData timeData = new RealTimeData((double) sheet.getLastRowNum());
        //获得数据库是否存入的信息
        List<BasicSalesAmazonCsvTxtXslHeader> isImportHead = headService.sqlHead(siteId, menuId, null, shopId);
        //通过uid 查找账号
        String userName = userService.serviceGetName(uid);
        //保存J的索引 为了拿到 出错的头 字段
        int k = 0;
        Map<String, Integer> intMap = new HashMap<>();
        //获得 ctx 对象
        ChannelHandlerContext ctx = chatService.getCtx(uid);
        try {
            for (int i = 1; i <= lastRowNum; i++) {
                //numberCount++
                ThreadLocalUtils.inCreateNumberLong(numberCount);
                //count ++ 成功数量
                ThreadLocalUtils.inCreateNumberLong(count);
                row = sheet.getRow(i);
                // 105 cpr
                if (menuId == 105) {
                    cprList = ArrUtils.listT(tList);
                    SalesAmazonAdCpr saCpr = setCpr(shopId, siteId, userName, recordingId);
                    for (int j = 0; j < totalNumber; j++) {
                        k = j;
                        cell = row.getCell(j);
                        saCpr = setCprPojo(j, saCpr, cell, isImportHead, xlsListHead, totalNumber);
                        if (saCpr == null) {
                            //设置没有SKU的信息导入
                            skuSetting(row, totalNumber, sqlHead);
                            break;
                        }
                    }
                    if (saCpr != null) {
                        cprList.add(saCpr);
                    }
                    //107 str
                } else if (menuId == 107) {
                    strList = ArrUtils.listT(tList);
                    SalesAmazonAdStr adStr = setStr(shopId, siteId, userName, recordingId);
                    for (int j = 0; j < totalNumber; j++) {
                        k = j;
                        cell = row.getCell(j);
                        adStr = setStrPojo(j, adStr, cell, isImportHead, xlsListHead);
                    }
                    strList.add(adStr);
                    //106 oar
                } else if (menuId == 106) {
                    oarList = ArrUtils.listT(tList);
                    SalesAmazonAdOar adOar = setOar(shopId, siteId, userName, recordingId);
                    for (int j = 0; j < totalNumber; j++) {
                        k = j;
                        cell = row.getCell(j);
                        adOar = setOarPojo(j, adOar, cell, isImportHead, xlsListHead, totalNumber);
                        if (adOar == null) {
                            skuSetting(row, totalNumber, sqlHead);
                            break;
                        }
                    }
                    if (adOar != null) {
                        oarList.add(adOar);
                    }
                    //HL
                } else if (menuId == 125) {
                    hlList = ArrUtils.listT(tList);
                    SalesAmazonAdHl adHl = setHl(shopId, siteId, userName, recordingId);
                    for (int j = 0; j < totalNumber; j++) {
                        k = j;
                        cell = row.getCell(j);
                        adHl = setHlPojo(j, adHl, cell, isImportHead, xlsListHead);
                    }
                    hlList.add(adHl);
                    //订单处理费
                } else if (menuId == 271) {
                    hFeesList = ArrUtils.listT(tList);
                    SalesAmazonFbaHandlingFee hLFee = setHLFee(userName, recordingId);
                    for (int j = 0; j < totalNumber; j++) {
                        k = j;
                        cell = row.getCell(j);
                        hLFee = setHLFeeInfo(j, hLFee, cell, isImportHead, xlsListHead, totalNumber);
                        if (hLFee == null) {
                            skuSetting(row, totalNumber, sqlHead);
                            break;
                        }
                    }
                    if (hLFee != null) {
                        hFeesList.add(hLFee);
                    }
                }
                index++;
                sendRealTimeData(ctx, intMap, timeData, index + 1);
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                return setErrorInfo(recordingId, "====>参数空指针异常" + e.getMessage(), null);
            }
            chatService.sendMessage(ctx, JsonUtils.getJsonTypeError("error", ChatType.PROGRESS_BAR));
            return setErrorInfo(recordingId, "出错字段" + xlsListHead.get(k) + "下" + (numberCount.get() + 1) + "行信息错误,错误原因," + e.getMessage(), null);
        }
        int saveCount = 0;
        chatService.sendMessage(ctx, JsonUtils.getJsonTypeSuccess("存入数据中", ChatType.PROGRESS_BAR));
        try {
            if (cprList != null && cprList.size() > 0) {
                saveCount = cprService.saveSalesAmazonAdCprList(cprList);
            } else if (strList != null && strList.size() > 0) {
                saveCount = strService.saveSalesAmazonAdStrList(strList);
            } else if (oarList != null && oarList.size() > 0) {
                saveCount = oarService.saveSalesAmazonAdOarList(oarList);
            } else if (hlList != null && hlList.size() > 0) {
                saveCount = hlService.saveSalesAmazonAdHlList(hlList);
            } else if (hFeesList != null && hFeesList.size() > 0) {
                saveCount = hLFeeService.serviceSaveAmazonHandLFee(hFeesList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            chatService.sendMessage(ctx, JsonUtils.getJsonTypeError("error", ChatType.PROGRESS_BAR));
            return setErrorInfo(recordingId, "数据库存入异常", null);
        }
        if (saveCount > 0) {
            return printCount(begin, count.get(), index, ctx);
        }
        return JsonData.setResultError("存入数据失败,所有数据都不匹配");
    }

    /**
     * xls/sku设置
     *
     * @return
     */
    public void skuSetting(Row row, int totalNumber, List<String> head) {
        ThreadLocalUtils.inCreateList(noSkuList);
        //如果等于0 就先设置头
        if (noSkuList.get().size() == 0) {
            noSkuList.get().add(head);
        }
        //count --
        ThreadLocalUtils.delCreateNumberLong(count);
        //sumNoSku ++
        ThreadLocalUtils.inCreateNumberInteger(sumErrorSku);
        List<String> skuListNo = new ArrayList<>();
        //拿到那一行信息
        for (int i = 0; i < totalNumber; i++) {
            if (row.getCell(i) != null) {
                skuListNo.add(row.getCell(i).toString());
            } else {
                skuListNo.add(null);
            }
        }
        noSkuList.get().add(skuListNo);
        noSkuList.set(noSkuList.get());
    }

    /**
     * set pojo cpr
     */
    public SalesAmazonAdCpr setCprPojo(int j, SalesAmazonAdCpr saCpr, Cell
            cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead, int totalNumber) {
        String strAdCpr;
        if (xlsListHead.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            saCpr.setDate(lon(cell));
        else if (xlsListHead.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            strAdCpr = str(cell);
            saCpr.setCampaignName(strAdCpr);
        } else if (xlsListHead.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
            strAdCpr = str(cell);
            saCpr.setAdGroupName(strAdCpr);
        } else if (xlsListHead.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose()) {
            strAdCpr = str(cell);
            saCpr.setAdvertisedSku(strAdCpr);
        } else if (xlsListHead.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
            strAdCpr = str(cell);
            saCpr.setAdvertisedAsin(strAdCpr);
        } else if (xlsListHead.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose())
            saCpr.setImpressions(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose())
            saCpr.setClicks(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose())
            saCpr.setTotalSpend(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose())
            saCpr.setSales(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose())
            saCpr.setRoas(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose())
            saCpr.setOrdersPlaced(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(11).getImportTemplet()) && importHead.get(11).getOpenClose())
            saCpr.setTotalUnits(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(12).getImportTemplet()) && importHead.get(12).getOpenClose())
            saCpr.setSameSkuUnitsOrdered(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(13).getImportTemplet()) && importHead.get(13).getOpenClose())
            saCpr.setOtherSkuUnitsOrdered(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(14).getImportTemplet()) && importHead.get(14).getOpenClose())
            saCpr.setSameSkuUnitsSales(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(15).getImportTemplet()) && importHead.get(15).getOpenClose())
            saCpr.setOtherSkuUnitsSales(bigDecimal(cell));
        if (findAndSetSkuId(j, totalNumber, saCpr) == null) return null;

        return saCpr;
    }


    /**
     * set pojo str
     */
    public SalesAmazonAdStr setStrPojo(int j, SalesAmazonAdStr adStr, Cell
            cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead) {
        String strAdStr;
        //get的变量还能进行优化
        if (xlsListHead.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            adStr.setDate(lon(cell));
        else if (xlsListHead.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            strAdStr = str(cell);
            adStr.setCampaignName(strAdStr);
        } else if (xlsListHead.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
            strAdStr = str(cell);
            adStr.setAdGroupName(strAdStr);
        } else if (xlsListHead.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose()) {
            strAdStr = str(cell);
            adStr.setTargeting(strAdStr);
        } else if (xlsListHead.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
            strAdStr = str(cell);
            adStr.setMatchType(strAdStr);
        } else if (xlsListHead.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose()) {
            strAdStr = str(cell);
            adStr.setCustomerSearchTerm(strAdStr);
        } else if (xlsListHead.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose())
            adStr.setImpressions(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose())
            adStr.setClicks(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose())
            adStr.setTotalSpend(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose())
            adStr.setSales(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose())
            adStr.setRoas(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(11).getImportTemplet()) && importHead.get(11).getOpenClose())
            adStr.setOrdersPlaced(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(12).getImportTemplet()) && importHead.get(12).getOpenClose())
            adStr.setTotalUnits(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(13).getImportTemplet()) && importHead.get(13).getOpenClose())
            adStr.setAdvertisedSkuUnitsOrdered(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(14).getImportTemplet()) && importHead.get(14).getOpenClose())
            adStr.setOtherSkuUnitsOrdered(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(15).getImportTemplet()) && importHead.get(15).getOpenClose())
            adStr.setAdvertisedSkuUnitsSales(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(16).getImportTemplet()) && importHead.get(16).getOpenClose())
            adStr.setOtherSkuUnitsSales(bigDecimal(cell));
        return adStr;
    }

    /**
     * set pojo oar
     */
    public SalesAmazonAdOar setOarPojo(int j, SalesAmazonAdOar adOar, Cell
            cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead, int totalNumber) {
        String strAdOar;
        if (xlsListHead.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            adOar.setDate(lon(cell));
        else if (xlsListHead.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setCampaignName(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setAdGroupName(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setAdvertisedSku(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setAdvertisedAsin(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setTargeting(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setMatchType(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose()) {
            strAdOar = str(cell);
            adOar.setOtherAsin(strAdOar);
        } else if (xlsListHead.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose())
            adOar.setOtherAsinUnits(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose())
            adOar.setOtherAsinUnitsOrdered(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose()) {
            adOar.setOtherAsinUnitsOrderedSales(bigDecimal(cell));
        }
        if (findAndSetSkuId(j, totalNumber, adOar) == null) return null;
        return adOar;
    }

    /**
     * 封装查询 设置skuId
     *
     * @param j
     * @param totalNumber
     * @param obj
     * @return
     */
    public String findAndSetSkuId(int j, int totalNumber, Object obj) {
        Long skuId;
        if ((j + 1) == totalNumber) {
            if (obj instanceof SalesAmazonAdOar) {
                SalesAmazonAdOar saOar = (SalesAmazonAdOar) obj;
                skuId = skuService.selSkuId(saOar.getShopId(), saOar.getSiteId(), saOar.getAdvertisedSku());
                if (skuId == null) {
                    return null;
                }
                saOar.setSkuId(skuId);
            } else if (obj instanceof SalesAmazonAdCpr) {
                SalesAmazonAdCpr saCpr = (SalesAmazonAdCpr) obj;
                skuId = skuService.selSkuId(saCpr.getShopId(), saCpr.getSiteId(), saCpr.getAdvertisedSku());
                if (skuId == null) {
                    return null;
                }
                saCpr.setSkuId(skuId);
            }
        }
        return "ok";
    }

    /**
     * set 订单处理费用
     */
    public SalesAmazonFbaHandlingFee setHLFeeInfo(int j, SalesAmazonFbaHandlingFee lFee, Cell
            cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead,
                                                  List<String> xlsListHead, Integer totalNumber) {
        Integer sId;
        Integer seId;
        Long skuId;
        if (xlsListHead.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose()) {
            String shopName = str(cell);
            sId = shopService.getSId(shopName);
            if (sId == null) return null;
            lFee.setShopId(sId);
        } else if (xlsListHead.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            String siteName = str(cell);
            if (StringUtils.isBlank(siteName)) return null;
            seId = siteService.serviceGetSiteId(null, siteName);
            if (seId == null) return null;
            lFee.setSiteId(seId);
        } else if (xlsListHead.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
            String skuName = str(cell);
            skuId = skuService.selSkuId(lFee.getShopId(), lFee.getSiteId(), skuName);
            if (skuId == null) return null;
            lFee.setSkuId(skuId);
        } else if (xlsListHead.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose())
            lFee.setEffectiveDate(lon(cell));
        else if (xlsListHead.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose())
            lFee.setStdFbaHdFee(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose())
            lFee.setRemark(str(cell));
        if ((j + 1) == totalNumber) {
            //查询数据校验
            if (hLFeeService.serviceGetExists(lFee) == null) return null;
        }
        return lFee;
    }

    /**
     * set pojo hl
     */
    public SalesAmazonAdHl setHlPojo(int j, SalesAmazonAdHl adHl, Cell
            cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead) {
        String strAdHl;

        if (xlsListHead.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            adHl.setDate(lon(cell));
        else if (xlsListHead.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            strAdHl = str(cell);
            adHl.setCampaignName(strAdHl);
        } else if (xlsListHead.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose())
            adHl.setImpressions(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose())
            adHl.setClicks(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose())
            adHl.setCtr(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose())
            adHl.setCpc(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose())
            adHl.setSpend(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose())
            adHl.setAcos(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose())
            adHl.setRoas(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose())
            adHl.setTotalSales(bigDecimal(cell));
        else if (xlsListHead.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose())
            adHl.setTotalOrders(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(11).getImportTemplet()) && importHead.get(11).getOpenClose())
            adHl.setTotalUnits(dou(cell));
        else if (xlsListHead.get(j).equals(importHead.get(12).getImportTemplet()) && importHead.get(12).getOpenClose())
            adHl.setConversionRate(dou(cell));
        return adHl;
    }

    /**
     * 封装 String  类型转换
     *
     * @return
     */
    @Nullable
    private String str(Object obj) {
        String strObj;
        if (obj instanceof Cell) {
            Cell cell = (Cell) obj;
            String cV = XlsUtils.getCellValue(cell);
            if (cV.equals("-1")) {
                return null;
            }
            strObj = StrUtils.repString(cV.trim());
            return strObj;
        }
        return null;
    }

    /**
     * 封装 Long  类型转换
     *
     * @param cell
     * @return
     */
    @Nullable
    private Long lon(Cell cell) {
        Long lonCell;
        String cV = XlsUtils.getCellValue(cell);
        if (cV.equals("-1")) {
            return null;
        }
        lonCell = StrUtils.replaceLong(cV.trim());
        return lonCell;
    }

    /**
     * 封装 Doublie  类型转换
     *
     * @param cell
     * @return
     */
    @Nullable
    private Double dou(Cell cell) {
        Double DouCell;
        String cV = XlsUtils.getCellValue(cell);
        if (cV.equals("-1")) {
            return null;
        }
        DouCell = StrUtils.repDouble(cV.trim());
        return DouCell;
    }

    /**
     * 封装 BigDecimal  类型转换
     *
     * @param cell
     * @return
     */
    private BigDecimal bigDecimal(Cell cell) {
        String cV = XlsUtils.getCellValue(cell);
        if (cV.equals("-1")) {
            return null;
        }
        return StrUtils.repDecimal(cV.trim());
    }

    /**
     * 封装 int 类型转换
     *
     * @param cell
     * @return
     */
    private Integer integer(Cell cell) {
        String cV = XlsUtils.getCellValue(cell);
        if (cV.equals("-1")) {
            return null;
        }
        return Integer.parseInt(cV.trim());
    }

    /**
     * 对比xls 表头信息是否一致
     *
     * @return
     */
    public boolean compareHeadXls(List<String> xlsListHead, List<String> slqHead) {
        return ArrUtils.eqOrderList(slqHead, xlsListHead);
    }
    //#######################Xls


    //#######################Csv
    @Override
    @Transactional
    @Async("executor")
    public Future<ResponseBase> importCsv(String uuIdName, String saveFilePath, String fileName, Integer
            siteId, Integer shopId, Long uid, Integer pId, Long recordingId, Integer mId, String businessTime) throws
            Exception {
        future = new AsyncResult<>(threadCsv(uuIdName, saveFilePath, fileName, siteId, shopId, uid,
                pId, recordingId, mId, businessTime));
        return future;
    }

    /**
     * 封装csv店铺选择
     *
     * @param saveFilePath
     * @param fileName
     * @param siteId
     * @param shopId
     * @return
     */
    public ResponseBase threadCsv(String uuIdName, String saveFilePath, String fileName, Integer
            siteId, Integer
                                          shopId, Long uid, Integer
                                          pId, Long recordingId, Integer tbId, String businessTime) throws Exception {

        List<String> csvHeadList;
        String filePath = saveFilePath + uuIdName;
        String csvJson;
        JSONObject rowJson;
        int row;
        // 创建CSV读对象
        CsvReader csvReader = null;
        //获得头信息长度
        csvJson = CSVUtil.startReadLine(filePath, siteId, tbId);
        rowJson = JSONObject.parseObject(csvJson);
        row = (Integer) rowJson.get("index");
        if (row == -1) {
            //返回错误信息
            return setErrorInfo(recordingId, "表中真实字段第一行信息比对不上", null);
        }
        //拿到之前的表头信息
        csvHeadList = JSONObject.parseArray(rowJson.get("head").toString(), String.class);
        //拿到数据库的表头 进行校验
        List<String> sqlHeadList = getHeadInfo(siteId, tbId, null, shopId);
        //表头转换
        List<String> newCsvHeadList = UploadStore.conversionList(csvHeadList);
        //对比表头是否一致
        boolean isFlg = compareHeadCsv(newCsvHeadList, sqlHeadList);
        if (!isFlg) {
            //返回错误信息
            return setErrorInfo(recordingId, Constants.HEADER_EXCEPTION, JsonUtils.json(sqlHeadList));
        }
        try (InputStreamReader isr = FileUtils.streamReader(filePath)) {
            csvReader = new CsvReader(isr);
            //创建对象设置文件总数
            RealTimeData timeData = RealTimeDataStore.getTimeData(filePath);
            ResponseBase responseCsv = saveCsv(csvReader, row, shopId, siteId, uid, pId, recordingId, tbId, businessTime, newCsvHeadList, timeData);
            return saveUserUploadInfo(responseCsv, recordingId, fileName, newCsvHeadList, 2, saveFilePath, uuIdName);
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
            clear();
        }
    }

    /**
     * csv财务数据解析
     *
     * @param row
     * @param sId
     * @param seId
     * @param uid
     * @return
     */
    public ResponseBase saveCsv(CsvReader csvReader, int row, Integer sId, Integer seId, Long uid, Integer
            pId, Long
                                        recordingId, Integer menuId, String businessTime, List<String> csvHeadList, RealTimeData timeData) {
        List<FinancialSalesBalance> fsbList = null;
        List<SalesAmazonFbaBusinessreport> sfbList = null;
        // 开始时间
        Long begin = new Date().getTime();
        int index = 0;
        List<?> tList = new ArrayList<>();
        //获得数据库是否存入的信息
        List<BasicSalesAmazonCsvTxtXslHeader> isImportHead = headService.sqlHead(seId, menuId, null, sId);
        //通过uid 查找账号
        String userName = userService.serviceGetName(uid);
        Map<String, Integer> intMap = new HashMap<>();
        //获得 ctx 对象
        ChannelHandlerContext ctx = chatService.getCtx(uid);
        int k = 0;
        try {
            while (csvReader.readRecord()) {
                if (index >= row) {
                    //numberCount++
                    ThreadLocalUtils.inCreateNumberLong(numberCount);
                    //count ++ 成功数量
                    ThreadLocalUtils.inCreateNumberLong(count);
                    //85 == 财务上传ID | 104 运营上传
                    if (menuId == Constants.FINANCE_ID || menuId == Constants.FINANCE_ID_YY) {
                        fsbList = ArrUtils.listT(tList);
                        FinancialSalesBalance fb = setFsb(sId, seId, userName, pId.longValue(), recordingId);
                        for (int j = 0; j < csvReader.getColumnCount(); j++) {
                            k = j;
                            fb = saveFinance(fb, csvReader, sId, seId, csvHeadList, isImportHead, j);
                            if (fb == null) {
                                break;
                            }
                        }
                        if (fb != null) {
                            fsbList.add(fb);
                        }
                    }
                    //108 == 业务上传ID
                    else if (menuId == Constants.BUSINESS_ID) {
                        sfbList = ArrUtils.listT(tList);
                        SalesAmazonFbaBusinessreport sfb = setBusPort(sId, seId, userName, recordingId);
                        for (int j = 0; j < csvReader.getColumnCount(); j++) {
                            k = j;
                            sfb = saveBusiness(sfb, csvReader, sId, seId, Long.parseLong(businessTime), csvHeadList, isImportHead, j);
                            if (sfb == null) {
                                break;
                            }
                        }
                        if (sfb != null) {
                            sfbList.add(sfb);
                        }
                    }
                }
                index++;
                sendRealTimeData(ctx, intMap, timeData, index + row);
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                return setErrorInfo(recordingId, "====>参数空指针异常" + e.getMessage(), null);
            }
            e.printStackTrace();
            chatService.sendMessage(ctx, JsonUtils.getJsonTypeError("error", ChatType.PROGRESS_BAR));
            return setErrorInfo(recordingId, "出错字段" + csvHeadList.get(k) + "下" + (numberCount.get() + row) + "行信息错误,错误原因," + e.getMessage(), null);
        }
        int number = 0;
        try {
            //财务
            if (fsbList != null && fsbList.size() > 0) {
                //插入数据
                number = fsbService.addInfo(fsbList, menuId);
            }
            //业务
            else if (sfbList != null && sfbList.size() > 0) {
                number = busService.addSalesAmazonAdBusList(sfbList);
            }
        } catch (Exception e) {
            chatService.sendMessage(ctx, JsonUtils.getJsonTypeError("error", ChatType.PROGRESS_BAR));
            return setErrorInfo(recordingId, "数据库存入异常", null);
        }
        if (number != 0) {
            return printCount(begin, count.get(), index, ctx);
        }
        return JsonData.setResultError("存入数据失败,所有数据都不匹配");
    }

    /**
     * 业务报告存入对象
     */
    public SalesAmazonFbaBusinessreport saveBusiness(SalesAmazonFbaBusinessreport sfb, CsvReader
            csvReader, Integer
                                                             sId, Integer seId, Long
                                                             businessTime, List<String> csvHeadList, List<BasicSalesAmazonCsvTxtXslHeader> importHead, int j) throws
            IOException {
        sfb.setDate(businessTime);
        //(Parent) ASIN == (Parent) ASIN
        if (csvHeadList.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            sfb.setfAsin(StrUtils.repString(csvReader.get(j)));
        else if (csvHeadList.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            sfb.setsAsin(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
            sfb.setpName(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose()) {
            sfb.setSessionsVisit(StrUtils.replaceInteger(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
            sfb.setSessionsPer(StrUtils.repDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose()) {
            sfb.setPageViews(StrUtils.replaceInteger(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose()) {
            sfb.setBuyBoxPer(StrUtils.repDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose()) {
            sfb.setOrder(StrUtils.replaceInteger(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose()) {
            sfb.setOrderB2B(StrUtils.replaceInteger(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose()) {
            sfb.setSales(StrUtils.repDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose()) {
            sfb.setSalesB2B(StrUtils.repDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(11).getImportTemplet()) && importHead.get(11).getOpenClose()) {
            sfb.setOrderItems(StrUtils.replaceInteger(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(12).getImportTemplet()) && importHead.get(12).getOpenClose()) {
            sfb.setOrderItemsB2B(StrUtils.replaceInteger(csvReader.get(j)));
        }
        if ((j + 1) == csvReader.getColumnCount()) {
            Long skuId = skuService.getAsinSkuId(sId, seId, sfb.getsAsin());
            String result = skuList(skuId, csvReader, sfb.getfAsin());
            if (StringUtils.isEmpty(result)) {
                return null;
            }
            sfb.setSkuId(skuId);
        }
        return sfb;
    }


    /**
     * csv 财务存入对象
     */
    public FinancialSalesBalance saveFinance(FinancialSalesBalance fsb, CsvReader csvReader, Integer
            sId, Integer
                                                     seId,
                                             List<String> csvHeadList, List<BasicSalesAmazonCsvTxtXslHeader> importHead, int j) throws
            IOException {
        //设置时间类型转换
        if (csvHeadList.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            DateUtils.setDate(fsb, seId, csvReader.get(j));
        else if (csvHeadList.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            fsb.setSettlementId(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
            String type = StrUtils.repString(csvReader.get(j));
            if (StringUtils.isEmpty(type)) {
                fsb.setType(type);
            } else if (!setType(type, seId, csvReader, fsb)) {
                return null;
            }
        } else if (csvHeadList.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose())
            fsb.setOrderId(StrUtils.repString(csvReader.get(j)));
        else if (csvHeadList.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
            fsb.setFinancialSku(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose()) {
            fsb.setDescription(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose()) {
            fsb.setoQuantity(StrUtils.replaceLong(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose()) {
            fsb.setMarketplace(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose()) {
            fsb.setFulfillment(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose()) {
            fsb.setCity(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose()) {
            fsb.setState(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(11).getImportTemplet()) && importHead.get(11).getOpenClose()) {
            fsb.setPostal(StrUtils.repString(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(12).getImportTemplet()) && importHead.get(12).getOpenClose()) {
            fsb.setSales(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(13).getImportTemplet()) && importHead.get(13).getOpenClose()) {
            fsb.setShippingCredits(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(14).getImportTemplet()) && importHead.get(14).getOpenClose()) {
            fsb.setGiftwrapCredits(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(15).getImportTemplet()) && importHead.get(15).getOpenClose()) {
            fsb.setPromotionalRebates(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(16).getImportTemplet()) && importHead.get(16).getOpenClose()) {
            fsb.setSalesTax(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(17).getImportTemplet()) && importHead.get(17).getOpenClose()) {
            fsb.setMarketplaceFacilitatorTax(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(18).getImportTemplet()) && importHead.get(18).getOpenClose()) {
            fsb.setSellingFees(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(19).getImportTemplet()) && importHead.get(19).getOpenClose()) {
            fsb.setFbaFee(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(20).getImportTemplet()) && importHead.get(20).getOpenClose()) {
            fsb.setOtherTransactionFees(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(21).getImportTemplet()) && importHead.get(21).getOpenClose()) {
            fsb.setOther(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(22).getImportTemplet()) && importHead.get(22).getOpenClose()) {
            fsb.setTotal(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(23).getImportTemplet()) && importHead.get(23).getOpenClose()) {
            fsb.setLowValueGoods(StrUtils.replaceDecimal(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(24).getImportTemplet()) && importHead.get(23).getOpenClose()) {
            fsb.setPointFee(StrUtils.replaceDecimal(csvReader.get(j)));
        }

        //这里最后执行
        if ((j + 1) == csvReader.getColumnCount()) {
            Long skuId;
            if (fsb.getFinancialSku() == null) {
                skuId = 0L;
            } else {
                skuId = skuService.selSkuId(sId, seId, fsb.getFinancialSku());
            }
            String result = skuList(skuId, csvReader, fsb.getFinancialSku());
            if (StringUtils.isEmpty(result)) {
                return null;
            }
            fsb.setSkuId(skuId);
            //通过typeName设置信息
            FsbStore.setInfo(fsb.getType(), fsb);
            //设置广告税
            FsbStore.setAdTax(fsb);
            //计算
            FsbStore.calculation(fsb);
        }
        return fsb;
    }

    /**
     * csv 封装获取没有SKU的文件List
     *
     * @param skuId
     * @param csvReader
     * @return
     */
    public String skuList(Long skuId, CsvReader csvReader, String sku) throws IOException {
        //不为空  判断skuID
        if (StringUtils.isNotEmpty(sku)) {
            String result = exportCsvType(csvReader, skuId);
            //如果sku是空的  直接返回设置NULL
            if (StringUtils.isEmpty(result)) {
                return null;
            }
        }
        return "success";
    }

    /**
     * csv 对比表头返回
     *
     * @return
     */
    public boolean compareHeadCsv
    (List<String> headList, List<String> sqlHeadList) {
        //如果不一致返回false
        return ArrUtils.eqOrderList(headList, sqlHeadList);
    }

    /**
     * 通用设置CSV 没有sku/typeName导出文件
     *
     * @param skuId
     * @return
     */
    public String exportCsvType(CsvReader csvReader, Long skuId) throws IOException {
        if (skuId == null || skuId == -1) {
            ThreadLocalUtils.inCreateList(noSkuList);
            //count --
            ThreadLocalUtils.delCreateNumberLong(count);
            //sumNoSku ++
            ThreadLocalUtils.inCreateNumberInteger(sumErrorSku);
            List<String> skuListNo = new ArrayList<>();
            for (int i = 0; i < csvReader.getColumnCount(); i++) {
                skuListNo.add(csvReader.get(i));
            }
            noSkuList.get().add(skuListNo);
            noSkuList.set(noSkuList.get());
            return null;
        }
        return "success";
    }


    /**
     * csv 设置TypeName
     */
    public boolean setType(String type, Integer seId, CsvReader csvReader, FinancialSalesBalance fsb) {
        String typeName;
        try {
            typeName = orderTypeName(type, seId, csvReader);
            if (StringUtils.isNotEmpty(typeName)) {
                fsb.setType(typeName);
                return true;
            }
        } catch (IOException e) {
            throw new LsException("IO异常" + e.getMessage());
        }
        return false;
    }

    /**
     * csv 获取没有typeName的文件List
     *
     * @param csvReader
     * @return
     */
    public String orderTypeName(String type, Integer seId, CsvReader csvReader) throws IOException {
        String typeName = AmazontypeService.getTypeName(seId, type);
        if (StringUtils.isEmpty(typeName)) {
            return exportCsvType(csvReader, -1L);
        }
        return typeName;
    }

    //#######################Csv


    /**
     * 封装noSku写入状态
     *
     * @param recordingId
     * @param fileName
     * @param head
     * @return
     */
    private ResponseBase saveUserUploadInfo(ResponseBase responseBase, Long recordingId, String
            fileName, List<String> head, int type, String saveFilePath, String uuidName) {
        if (responseBase.getCode() == 200) {
            if (noSkuList.get() != null && noSkuList.get().size() > 0) {
                if (type == 1) {
                    //写入xlsx 文件写入到服务器的地址   Constants.WRITE_SAVE_FILE_PATH
                    XlsUtils.outPutXssFile(noSkuList.get(), Constants.WRITE_SAVE_FILE_PATH, uuidName);
                } else if (type == 2) {
                    //写入CSV文件到本地
                    CSVUtil.write(head, noSkuList.get(), Constants.WRITE_SAVE_FILE_PATH, uuidName);
                } else if (type == 3) {
                    //写入Txt
                    TxtUtils.writeFileTxt(noSkuList.get(), Constants.WRITE_SAVE_FILE_PATH, uuidName);
                }
                //上传成功 有些skuId 记录上传信息~
                String msg = responseBase.getMsg() + " ,有" + sumErrorSku.get() + "条没有skuId/没有type";
                sumErrorSku.set(0);
                return upUserUpload(2, recordingId, fileName, msg, saveFilePath, uuidName);
            }
            //上传成功 都有skuId~
            return upUserUpload(0, recordingId, fileName, responseBase.getMsg(), saveFilePath, uuidName);
        } else {
            //存入信息报错
            return upUserUpload(1, recordingId, fileName, responseBase.getMsg(), saveFilePath, uuidName);
        }
    }

    /**
     * 封装recordInfo通用更新方法
     */
    private ResponseBase upUserUpload(int status, Long id, String fileName, String msg, String
            saveFilePath, String uuIdName) {
        UserUpload upload;
        switch (status) {
            case 0:
                upload = recordInfo(status, msg, id, fileName, saveFilePath, uuIdName);
                return JsonData.setResultSuccess(msg, upload);
            case 1:
                upload = recordInfo(status, msg, id, fileName, saveFilePath, uuIdName);
                return JsonData.setResultError("error/" + msg, upload);
            case 2:
                int fileIndex = saveFilePath.lastIndexOf("/");
                upload = recordInfo(status, msg, id, "NO" + fileName, saveFilePath.substring(0, fileIndex) + "SkuNo/", uuIdName);
                return JsonData.setResultSuccess(msg, upload);
            case 3:
                upload = recordInfo(status, msg, id, fileName, saveFilePath, uuIdName);
                return JsonData.setResultError(msg, upload);
            case 4:
                break;
        }
        return null;
    }

    /**
     * 封装更新信息
     *
     * @param status
     * @param msg
     */
    private UserUpload recordInfo(Integer status, String msg, Long id, String fileName, String
            saveFilePath, String
                                          uuIdName) {
        UserUpload upload = new UserUpload(id, new Date().getTime());
        if (status == 2) {
            upload.setUuidName(uuIdName);
            upload.setFilePath(saveFilePath);
        }
        upload.setName(fileName);
        upload.setStatus(status);
        upload.setRemark(msg);
        userUploadService.upUploadInfo(upload);
        return upload;

    }


    /**
     * 封装通用打印输出语句 方法
     *
     * @param
     * @return
     */
    public ResponseBase printCount(Long begin, Long successNumber, int index, ChannelHandlerContext ctx) {
        chatService.sendMessage(ctx, JsonUtils.getJsonTypeSuccess("success", ChatType.PROGRESS_BAR));
        // 结束时间
        Long end = new Date().getTime();
        return JsonData.setResultSuccess("总共" + index + "条数据/ 真实数据" + successNumber + "条数据插入成功/====>失败 " + sumErrorSku.get() + "条/花费时间 : " + (end - begin) / 1000 + " s");
    }

    /**
     * 封装通用获得头信息对比
     *
     * @param seId
     * @param mId
     * @return
     */
    public List<String> getHeadInfo(Integer seId, int mId, Integer areaId, Integer shopId) {
        //85  mId 跟 104 mId头信息一致
        if (mId == Constants.FINANCE_ID_YY) {
            return headService.headerList(seId, Constants.FINANCE_ID, areaId, shopId);
        }
        return headService.headerList(seId, mId, areaId, shopId);
    }


    /**
     * 获得skuId 订单信息表 通过 sku
     *
     * @param sku
     * @param sId
     * @param seId
     * @return
     */
    public boolean skuEqSku(String sku, Integer sId, Integer seId, Object obj) {
        if (StringUtils.isBlank(sku)) {
            return false;
        }
        Long skuId = skuService.selSkuId(sId, seId, sku);
        if (skuId == null) {
            return false;
        }
        //接收订单信息
        if (obj instanceof SalesAmazonFbaReceivestock) {
            SalesAmazonFbaReceivestock receive = (SalesAmazonFbaReceivestock) obj;
            receive.setSkuId(skuId);
            return true;
        }
        return false;
    }

    /**
     * 洲业务 sku asin  业务对比获得sku 特殊需求
     *
     * @param sku
     * @param asin
     */
    public boolean skuEqAsin(String sku, String asin, Integer sId, Integer seId, Object obj) {
        if (StringUtils.isNotEmpty(sku) && StringUtils.isNotEmpty(asin)) {
            //查询skuId
            Long skuId = skuService.selSkuId(sId, seId, sku);
            Long asinId = skuService.getAsinSkuId(sId, seId, asin);
            if (skuId == null || asinId == null) {
                return false;
            }
            //订单
            if (obj instanceof SalesAmazonFbaTradeReport) {
                SalesAmazonFbaTradeReport sftReport = (SalesAmazonFbaTradeReport) obj;
                if (skuId.equals(asinId)) {
                    sftReport.setSkuId(skuId);
                    return true;
                }
            }
            //退货
            if (obj instanceof SalesAmazonFbaRefund) {
                SalesAmazonFbaRefund sftRefund = (SalesAmazonFbaRefund) obj;
                if (skuId.equals(asinId)) {
                    sftRefund.setSkuId(skuId);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断传入的对象是否是null
     *
     * @param obj
     * @param txtHeadList
     * @param line
     * @return
     */
    public int isObjNull(Object obj, List<String> txtHeadList, String line) {
        if (obj == null) {
            //先拿到这一行信息 newLine
            exportTxtType(txtHeadList, line);
            return -1;
        }
        return 1;
    }

    /**
     * 通用设置Txt 没有sku/导出文件
     *
     * @return
     */
    public void exportTxtType(List<String> head, String line) {
        ThreadLocalUtils.inCreateList(noSkuList);
        //count --
        ThreadLocalUtils.delCreateNumberLong(count);
        //sumNoSku ++
        ThreadLocalUtils.inCreateNumberInteger(sumErrorSku);
        if (noSkuList.get().size() == 0) {
            noSkuList.get().add(head);
        }
        List<String> skuListNo = new ArrayList<>();
        skuListNo.add(line);
        noSkuList.get().add(skuListNo);
        noSkuList.set(noSkuList.get());
    }
//##########################################################通用方法

//###############设置表头

    /**
     * FBA遗弃存入
     */
    public SalesAmazonFbaAbandon setAbandon(Integer sId, String userName, Long recordingId, Integer aId) {
        return new SalesAmazonFbaAbandon(sId, new Date().getTime(), userName, recordingId, aId);
    }

    /**
     * 订单处理费 通用存储
     */
    public SalesAmazonFbaHandlingFee setHLFee(String userName, Long recordingId) {
        return new SalesAmazonFbaHandlingFee(new Date().getTime(), userName, recordingId);
    }

    /**
     * 长期仓储费通用存储
     */
    public SalesAmazonFbaLongWarehouseFee setLWar(Integer sId, String userName, Long recordingId) {
        return new SalesAmazonFbaLongWarehouseFee(sId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 月度仓储费通用存储
     */
    public SalesAmazonFbaMonthWarehouseFee setMWar(Integer sId, String userName, Long recordingId) {
        return new SalesAmazonFbaMonthWarehouseFee(sId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 期末库存通用对象
     */
    public SalesAmazonFbaInventoryEnd setEnd(Integer sId, String userName, Long recordingId) {
        return new SalesAmazonFbaInventoryEnd(sId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 接收库存通用对象
     */
    public SalesAmazonFbaReceivestock setReceives(Integer sId, String userName, Long recordingId) {
        return new SalesAmazonFbaReceivestock(sId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 退货报告通用对象
     */
    public SalesAmazonFbaRefund setRefund(Integer sId, String userName, Long recordingId) {
        return new SalesAmazonFbaRefund(sId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 订单报告通用对象
     */
    public SalesAmazonFbaTradeReport setTraPort(Integer sId, String userName, Long recordingId) {
        return new SalesAmazonFbaTradeReport(sId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 业务报告通用对象
     */
    public SalesAmazonFbaBusinessreport setBusPort(Integer sId, Integer seId, String userName, Long recordingId) {
        return new SalesAmazonFbaBusinessreport(sId, seId, new Date().getTime(), userName, recordingId);
    }

    /**
     * 财务设置通用对象
     */
    public FinancialSalesBalance setFsb(Integer sId, Integer seId, String userName, Long pId, Long recordingId) {
        return new FinancialSalesBalance(sId, seId, pId, new Date().getTime(), userName, recordingId);
    }

    /**
     * H1设置通用对象
     */
    public SalesAmazonAdHl setHl(Integer sId, Integer seId, String userName, Long recordingId) {
        return new SalesAmazonAdHl(sId, seId, new Date().getTime(), userName, recordingId);
    }

    /**
     * Cpr设置通用对象
     */
    public SalesAmazonAdCpr setCpr(Integer sId, Integer seId, String userName, Long recordingId) {
        return new SalesAmazonAdCpr(sId, seId, new Date().getTime(), userName, recordingId);
    }

    /**
     * Oar设置通用对象
     */
    public SalesAmazonAdOar setOar(Integer sId, Integer seId, String userName, Long recordingId) {
        return new SalesAmazonAdOar(sId, seId, new Date().getTime(), userName, recordingId);
    }

    /**
     * Str设置通用对象
     */
    public SalesAmazonAdStr setStr(Integer sId, Integer seId, String userName, Long recordingId) {
        return new SalesAmazonAdStr(sId, seId, new Date().getTime(), userName, recordingId);
    }

//###############设置表头

    /**
     * 错误更新信息
     *
     * @param recordingId 文件记录表ID
     * @param msg         错误消息
     * @param data        错误数据
     */
    public ResponseBase setErrorInfo(Long recordingId, String msg, String data) {
        //更新上传信息
        recordInfo(1, msg, recordingId, null, null, null);
        if (StringUtils.isEmpty(data)) {
            return JsonData.setResultError(msg);
        }
        return JsonData.setResultError(msg + data);
    }

    public void sendRealTimeData(ChannelHandlerContext ctx, Map<String, Integer> intMap, RealTimeData
            timeData,
                                 int index) {
        if (ctx != null) {
            //设置进度
            RealTimeDataStore.setSchedule(timeData, index);
            //转换 数据
            String msg = JsonUtils.getJsonObj(ThreadLocalUtils.inCreateSet(timeDataSet, timeData));
            //设置进度 传输
            chatService.schedule(ctx, intMap, timeData.getPercentage(), JsonUtils.getJsonTypeSuccess(msg, ChatType.PROGRESS_BAR));
        }
    }

}

package com.dt.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.BasePublicMapper.BasicPublicAmazonTypeMapper;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonWarehouse;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.model.RealTimeData;
import com.dt.user.model.SalesAmazonAd.*;
import com.dt.user.model.UserUpload;
import com.dt.user.service.BasePublicService.BasicPublicSiteService;
import com.dt.user.service.BasePublicService.BasicPublicSkuService;
import com.dt.user.service.BasePublicService.BasicSalesAmazonCsvTxtXslHeaderService;
import com.dt.user.service.BasePublicService.BasicSalesAmazonWarehouseService;
import com.dt.user.service.ConsumerService;
import com.dt.user.service.FinancialSalesBalanceService;
import com.dt.user.service.SalesAmazonAdService.*;
import com.dt.user.service.UserService;
import com.dt.user.service.UserUploadService;
import com.dt.user.store.RealTimeDataStore;
import com.dt.user.store.UploadStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.*;
import com.dt.user.websocket.WebSocketServer;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BasicPublicAmazonTypeMapper typeMapper;
    @Autowired
    private BasicSalesAmazonWarehouseService warehouseService;

    @Autowired
    private BasicPublicSiteService siteService;

    @Autowired
    private BasicPublicSkuService skuService;

    @Autowired
    private BasicSalesAmazonCsvTxtXslHeaderService headService;

    @Autowired
    private SalesAmazonFbaTradeReportService tradeReportService;

    @Autowired
    private SalesAmazonFbaRefundService refundService;

    @Autowired
    private SalesAmazonFbaReceivestockService receivestockService;

    @Autowired
    private SalesAmazonFbaInventoryEndService endService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserUploadService userUploadService;
    @Autowired
    private WebSocketServer ws;

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

    //#######################Txt


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
                setErrorInfo(recordingId, Constants.HEADER_EXCEPTION + JsonUtils.json(head));
            }
            //多线程处理
            ResponseBase responseTxt = saveTxt(br, shopId, uid, recordingId, lineHead, menuId, aId);
            return saveUserUploadInfo(responseTxt.getMsg(), recordingId, fileName, null, 3, saveFilePath, uuIdName);
        } finally {
            CrrUtils.clearListThread(noSkuList);
            count.set(0L);
            numberCount.set(0L);
        }
    }

    private ResponseBase saveTxt(BufferedReader br, Integer shopId, Long uid, Long
            recordingId, String lineHead, Integer menuId, Integer aId) throws IOException {
        // 开始时间
        Long begin = new Date().getTime();
        List<SalesAmazonFbaReceivestock> sfReceivesList = null;
        List<SalesAmazonFbaRefund> safRefundList = null;
        List<SalesAmazonFbaTradeReport> safTradList = null;
        List<SalesAmazonFbaInventoryEnd> safEndList = null;
        List<?> tList = new ArrayList<>();
        //获得数据库是否存入的信息
        List<BasicSalesAmazonCsvTxtXslHeader> isImportHead = headService.sqlHead(null, menuId, aId, shopId);
        //通过uid 查找账号
        String userName = userService.serviceGetName(uid);
        //设置头行List
        List<String> txtHeadList = UploadStore.setLineHeadList(lineHead);
        String line;
        int index = 0;
        try {
            while ((line = br.readLine()) != null) {
                //numberCount++
                CrrUtils.inCreateNumberLong(numberCount);
                //count ++ 成功数量
                CrrUtils.inCreateNumberLong(count);
                // 一次读入一行数据
                String[] newLine = line.split("\t", -1);
                switch (menuId) {
                    //订单报告
                    case 109:
                        safTradList = ArrUtils.listT(tList);
                        SalesAmazonFbaTradeReport sftPort = setTraPort(shopId, userName, recordingId);
                        for (int i = 0; i < newLine.length; i++) {
                            sftPort = saveTradeReport(i, sftPort, newLine, shopId, txtHeadList, isImportHead);
                            if (sftPort == null) {
                                //先拿到这一行信息 newLine
                                exportTxtType(txtHeadList, line);
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
                            sfRefund = saveAmazonFbaRefund(i, sfRefund, newLine, shopId, aId, txtHeadList, isImportHead);
                            if (sfRefund == null) {
                                //先拿到这一行信息 newLine
                                exportTxtType(txtHeadList, line);
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
                            sfReceives = saveReceiveStock(i, sfReceives, newLine, txtHeadList, isImportHead);
                            if (sfReceives == null) {
                                //先拿到这一行信息 newLine
                                exportTxtType(txtHeadList, line);
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
                            sfEnd = salesEnd(i, sfEnd, newLine, txtHeadList, isImportHead);
                            if (sfEnd == null) {
                                //先拿到这一行信息 newLine
                                exportTxtType(txtHeadList, line);
                                break;
                            }
                        }
                        if (sfEnd != null) {
                            safEndList.add(sfEnd);
                        }
                        break;
                }
                index++;
            }
        } catch (Exception e) {
            setErrorInfo(recordingId, (numberCount.get() - 1) + "行信息错误,错误原因," + e.getMessage());
        }
        int countTrad = 0;
        try {
            if (safTradList != null) {
                if (safTradList.size() > 0) {
                    countTrad = tradeReportService.AddSalesAmazonAdTrdList(safTradList);
                }
            } else if (safRefundList != null) {
                if (safRefundList.size() > 0) {
                    //导入数据库
                    countTrad = refundService.AddSalesAmazonAdRefundList(safRefundList);
                }
            } else if (sfReceivesList != null) {
                if (sfReceivesList.size() > 0) {
                    //导入数据库
                    countTrad = receivestockService.AddSalesAmazonAdReceivestockList(sfReceivesList);
                }
            } else if (safEndList != null) {
                if (safEndList.size() > 0) {
                    //导入数据库
                    countTrad = endService.AddSalesAmazonAdInventoryEndList(safEndList);
                }
            }
        } catch (Exception e) {
            setErrorInfo(recordingId, "数据库存入异常");
        }
        if (countTrad != 0) {
            return printCount(begin, count.get(), index);
        }
        throw new LsException("存入数据失败,请检查信息/文件中所有行的shuId 无效");
    }

    /**
     * 期末库存信息存入
     *
     * @param sft
     * @param j
     * @return
     * @throws IOException
     */
    public SalesAmazonFbaInventoryEnd salesEnd(int i, SalesAmazonFbaInventoryEnd sft, String[] j,
                                               List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {

        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            sft.setDate(DateUtils.getTime(j[i], Constants.ORDER_RETURN));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            sft.setFnsku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            sft.setSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            sft.setProductName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            sft.setQuantity(StrUtils.replaceInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            String fc = StrUtils.repString(j[i]);
            if (StringUtils.isEmpty(fc)) {
                return null;
            }
            sft.setFc(fc);
            BasicSalesAmazonWarehouse warehouse = warehouseService.getWarehouse(fc);
            if (warehouse == null) {
                return null;
            }
            if (warehouse.getSiteId() == null || warehouse.getAmazonWarehouseId() == null) {
                return null;
            }
            sft.setSiteId(warehouse.getSiteId());
            sft.setAwId(warehouse.getAmazonWarehouseId());
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            sft.setDisposition(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(7).getImportTemplet()) && isImportHead.get(7).getOpenClose()) {
            sft.setCountry(StrUtils.repString(j[i]));
        }
        return sft;
    }

    /**
     * 接收订单信息存入
     *
     * @param sft
     * @param j
     * @return
     * @throws IOException
     */
    public SalesAmazonFbaReceivestock saveReceiveStock(int i, SalesAmazonFbaReceivestock sft, String[] j,
                                                       List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            sft.setDate(DateUtils.getTime(j[i], Constants.ORDER_RETURN));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            sft.setFnsku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose()) {
            sft.setSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            sft.setProductName(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            sft.setQuantity(StrUtils.replaceInteger(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            sft.setFbaShipmentId(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            String fc = StrUtils.repString(j[i]);
            if (StringUtils.isEmpty(fc)) {
                return null;
            }
            sft.setFc(fc);
            BasicSalesAmazonWarehouse warehouse = warehouseService.getWarehouse(fc);
            if (warehouse == null) {
                return null;
            }
            if (warehouse.getSiteId() == null || warehouse.getAmazonWarehouseId() == null) {
                return null;
            }
            sft.setAwId(warehouse.getAmazonWarehouseId());
            sft.setSiteId(warehouse.getSiteId());
        }
        return sft;
    }

    /**
     * 退货报告信息存入
     *
     * @param sft
     * @param j
     * @return
     * @throws IOException
     */
    public SalesAmazonFbaRefund saveAmazonFbaRefund(int i, SalesAmazonFbaRefund sft, String[] j, Integer sId, Integer aId,
                                                    List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            sft.setDate(DateUtils.getTime(j[i], Constants.ORDER_RETURN));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose()) {
            String oId = StrUtils.repString(j[i]);
            if (StringUtils.isEmpty(oId)) {
                return null;
            }
            sft.setOrderId(oId);
            //查询 获得site Id
            SalesAmazonFbaTradeReport serviceReport = tradeReportService.getReport(sId, oId);
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
            sft.setSku(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose()) {
            sft.setsAsin(StrUtils.repString(j[i]));
            boolean isFlgId = skuEqAsin(sft.getSku(), sft.getsAsin(), sId, sft.getSiteId(), sft);
            if (!isFlgId) {
                return null;
            }
        } else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose()) {
            sft.setFnsku(StrUtils.repString(j[i]));
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
            if (aId == 4 && sft.getSiteId() == 9) {
                sft.setLicensePlateNumber(StrUtils.repString(j[i]));
            } else {
                sft.setRefundStaus(StrUtils.repString(j[i]));
            }
        } else if (txtHeadList.get(i).equals(isImportHead.get(11).getImportTemplet()) && isImportHead.get(11).getOpenClose()) {
            if (aId == 4 && sft.getSiteId() == 9) {
                sft.setCustomerRemarks(StrUtils.repString(j[i]));
            } else {
                sft.setLicensePlateNumber(StrUtils.repString(j[i]));
            }
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
    public SalesAmazonFbaTradeReport saveTradeReport(int i, SalesAmazonFbaTradeReport sft, String[] j,
                                                     Integer sId, List<String> txtHeadList, List<BasicSalesAmazonCsvTxtXslHeader> isImportHead) {
        //下标对应  并且 是开启导入状态
        if (txtHeadList.get(i).equals(isImportHead.get(0).getImportTemplet()) && isImportHead.get(0).getOpenClose())
            sft.setAmazonOrderId(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(1).getImportTemplet()) && isImportHead.get(1).getOpenClose())
            sft.setMerchantOrderId(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(2).getImportTemplet()) && isImportHead.get(2).getOpenClose())
            sft.setDate(DateUtils.getTime(j[i], Constants.ORDER_RETURN));
        else if (txtHeadList.get(i).equals(isImportHead.get(3).getImportTemplet()) && isImportHead.get(3).getOpenClose())
            sft.setLastUpdatedDate(DateUtils.getTime(j[i], Constants.ORDER_RETURN));
        else if (txtHeadList.get(i).equals(isImportHead.get(4).getImportTemplet()) && isImportHead.get(4).getOpenClose())
            sft.setOrderStatus(StrUtils.repString(j[i]));
        else if (txtHeadList.get(i).equals(isImportHead.get(5).getImportTemplet()) && isImportHead.get(5).getOpenClose()) {
            sft.setFulfillmentChannel(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(6).getImportTemplet()) && isImportHead.get(6).getOpenClose()) {
            String siteUrl = StrUtils.repString(j[i]);
            sft.setSalesChannel(siteUrl);
            //查询 获得site Id
            Integer siteId = siteService.getSiteId(siteUrl);
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
            sft.setSku(StrUtils.repString(j[i]));
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
        else if (txtHeadList.get(i).equals(isImportHead.get(18).getImportTemplet()) && isImportHead.get(18).getOpenClose()) {
            sft.setShippingPrice(StrUtils.repDouble(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(19).getImportTemplet()) && isImportHead.get(19).getOpenClose()) {
            sft.setShippingPrice(StrUtils.repDouble(j[i]));
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
        } else if (txtHeadList.get(i).equals(isImportHead.get(32).getImportTemplet()) && isImportHead.get(32).getOpenClose()) {
            sft.setIsReplacementOrder(StrUtils.repString(j[i]));
        } else if (txtHeadList.get(i).equals(isImportHead.get(33).getImportTemplet()) && isImportHead.get(33).getOpenClose()) {
            sft.setOriginalOrderId(StrUtils.repString(j[i]));
        }
        return sft;
    }

    //#######################Txt
    //#######################Xls
    @Override
    @Transactional
    @Async("executor")
    public Future<ResponseBase> importXls(String uuIdName, String saveFilePath, String fileName, Integer siteId, Integer shopId, Long uid, Long recordingId, Integer tbId) throws Exception {
        future = new AsyncResult<>(threadXls(uuIdName, saveFilePath, fileName, siteId, shopId, uid,
                recordingId, tbId));
        return future;
    }


    public ResponseBase threadXls(String uuIdName, String saveFilePath, String fileName, Integer siteId, Integer shopId, Long uid, Long
            recordingId, Integer menuId) throws Exception {
        String filePath = saveFilePath + uuIdName;
        //判断文件类型 fileType()
        File file = new File(filePath);
        try (FileInputStream in = new FileInputStream(filePath);
             Workbook wb = XlsUtils.fileType(in, file)) {
            if (wb == null) {
                //返回错误信息
                setErrorInfo(recordingId, "不是excel文件");
            }
            assert wb != null;
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
                setErrorInfo(recordingId, Constants.HEADER_EXCEPTION + JsonUtils.json(sqlHead));
            }
            //创建对象设置文件总数
            RealTimeData timeData = RealTimeDataStore.getTimeData(filePath);
            ResponseBase responseXls = saveXls(shopId, siteId, uid, recordingId, totalNumber, sqlHead, menuId, sheet, xlsListHead, timeData);
            return saveUserUploadInfo(responseXls.getMsg(), recordingId, fileName, null, 1, filePath, uuIdName);
        } finally {
            CrrUtils.clearListThread(noSkuList);
            count.set(0L);
            numberCount.set(0L);
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
    public ResponseBase saveXls(Integer shopId, Integer siteId, Long uid, Long
            recordingId, int totalNumber, List<String> sqlHead, Integer menuId, Sheet sheet, List<String> xlsListHead, RealTimeData timeData) {
        // 开始时间
        Long begin = new Date().getTime();
        Row row;
        Cell cell;
        List<SalesAmazonAdCpr> cprList = null;
        List<SalesAmazonAdStr> strList = null;
        List<SalesAmazonAdOar> oarList = null;
        List<SalesAmazonAdHl> hlList = null;
        List<?> tList = new ArrayList<>();
        int index = 0;
        int line = 1;
        int lastRowNum = sheet.getLastRowNum(); // 获取总行数
        //获得数据库是否存入的信息
        List<BasicSalesAmazonCsvTxtXslHeader> isImportHead = headService.sqlHead(siteId, menuId, null, shopId);
        //通过uid 查找账号
        String userName = userService.serviceGetName(uid);
        //保存J的索引 为了拿到 出错的头 字段
        int k = 0;
        try {
            Map<String, Integer> intMap = new HashMap<>();
            for (int i = line; i <= lastRowNum; i++) {
                //numberCount++
                CrrUtils.inCreateNumberLong(numberCount);
                //count ++ 成功数量
                CrrUtils.inCreateNumberLong(count);
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
                } else if (menuId == 125) {
                    hlList = ArrUtils.listT(tList);
                    SalesAmazonAdHl adHl = setHl(shopId, siteId, userName, recordingId);
                    for (int j = 0; j < totalNumber; j++) {
                        k = j;
                        cell = row.getCell(j);
                        adHl = setHlPojo(j, adHl, cell, isImportHead, xlsListHead);
                    }
                    hlList.add(adHl);
                }
                index++;
                //设置进度 传输
                ws.schedule(intMap, RealTimeDataStore.setSchedule(timeData, index), timeDataSet, timeData, uid);

            }
        } catch (Exception e) {
            setErrorInfo(recordingId, "出错字段" + xlsListHead.get(k) + "下" + (numberCount.get() + 1) + "行信息错误,错误原因," + e.getMessage());
        }
        int saveCount = 0;
        try {
            if (cprList != null) {
                if (cprList.size() > 0) {
                    saveCount = cprService.AddSalesAmazonAdCprList(cprList);
                }
            }
            if (strList != null) {
                if (strList.size() > 0) {
                    saveCount = strService.AddSalesAmazonAdStrList(strList);
                }
            }
            if (oarList != null) {
                if (oarList.size() > 0) {
                    saveCount = oarService.AddSalesAmazonAdOarList(oarList);
                }
            }
            if (hlList != null) {
                if (hlList.size() > 0) {
                    saveCount = hlService.AddSalesAmazonAdHlList(hlList);
                }
            }
        } catch (Exception e) {
            setErrorInfo(recordingId, "数据库存入异常");
        }
        if (saveCount > 0) {
            return printCount(begin, count.get(), index);
        }

        throw new LsException("存入数据失败,请检查信息/文件中所有行的shuId 无效");
    }

    /**
     * xls/sku设置
     *
     * @return
     */
    public void skuSetting(Row row, int totalNumber, List<String> head) {
        CrrUtils.inCreateList(noSkuList);
        //如果等于0 就先设置头
        if (noSkuList.get().size() == 0) {
            noSkuList.get().add(head);
        }
        //count --
        CrrUtils.delCreateNumberLong(count);
        //sumNoSku ++
        CrrUtils.inCreateNumberInteger(sumErrorSku);
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
    public SalesAmazonAdCpr setCprPojo(int j, SalesAmazonAdCpr saCpr, Cell cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead, int totalNumber) {
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
        if (findBySkuId(j, totalNumber, saCpr) == null) return null;

        return saCpr;
    }


    /**
     * set pojo str
     */
    public SalesAmazonAdStr setStrPojo(int j, SalesAmazonAdStr adStr, Cell cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead) {
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
    public SalesAmazonAdOar setOarPojo(int j, SalesAmazonAdOar adOar, Cell cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead, int totalNumber) {
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
        if (findBySkuId(j, totalNumber, adOar) == null) return null;
        return adOar;
    }

    /**
     * 封装查询
     *
     * @param j
     * @param totalNumber
     * @param obj
     * @return
     */
    public String findBySkuId(int j, int totalNumber, Object obj) {
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
     * set pojo hl
     */
    public SalesAmazonAdHl setHlPojo(int j, SalesAmazonAdHl adHl, Cell cell, List<BasicSalesAmazonCsvTxtXslHeader> importHead, List<String> xlsListHead) {
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
    public String str(Object obj) {
        String strObj;
        if (obj instanceof Cell) {
            Cell cell = (Cell) obj;
            strObj = StrUtils.repString(XlsUtils.getCellValue(cell).trim());
            if (strObj.equals("-1")) {
                return null;
            }
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
    public Long lon(Cell cell) {
        Long lonCell;
        lonCell = StrUtils.replaceLong(XlsUtils.getCellValue(cell).trim());
        if (lonCell == -1L) {
            return null;
        }
        return lonCell;
    }

    /**
     * 封装 Doublie  类型转换
     *
     * @param cell
     * @return
     */
    public Double dou(Cell cell) {
        Double DouCell;
        DouCell = StrUtils.repDouble(XlsUtils.getCellValue(cell).trim());
        if (DouCell == -1.0) {
            return null;
        }
        return DouCell;
    }

    /**
     * 封装 BigDecimal  类型转换
     *
     * @param cell
     * @return
     */
    public BigDecimal bigDecimal(Cell cell) {
        return StrUtils.repDecimal(XlsUtils.getCellValue(cell).trim());
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
    public Future<ResponseBase> importCsv(String uuIdName, String saveFilePath, String fileName, Integer siteId, Integer shopId, Long uid, Integer pId, Long recordingId, Integer tbId, String businessTime) throws Exception {
        future = new AsyncResult<>(threadCsv(uuIdName, saveFilePath, fileName, siteId, shopId, uid,
                pId, recordingId, tbId, businessTime));
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
    public ResponseBase threadCsv(String uuIdName, String saveFilePath, String fileName, Integer siteId, Integer shopId, Long uid, Integer
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
            setErrorInfo(recordingId, "表中真实字段第一行信息比对不上");
        }
        //拿到之前的表头信息
        csvHeadList = JSONObject.parseArray(rowJson.get("head").toString(), String.class);
        //拿到数据库的表头 进行校验
        List<String> sqlHeadList = getHeadInfo(siteId, tbId, null, shopId);
        //对比表头是否一致
        boolean isFlg = compareHeadCsv(csvHeadList, sqlHeadList);
        if (!isFlg) {
            //返回错误信息
            setErrorInfo(recordingId, Constants.HEADER_EXCEPTION + JsonUtils.json(sqlHeadList));
        }
        try (InputStreamReader isr = FileUtils.streamReader(filePath)) {
            csvReader = new CsvReader(isr);
            ResponseBase responseCsv = saveCsv(csvReader, row, shopId, siteId, uid, pId, recordingId, tbId, businessTime, csvHeadList);
            return saveUserUploadInfo(responseCsv.getMsg(), recordingId, fileName, csvHeadList, 2, saveFilePath, uuIdName);
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
            CrrUtils.clearListThread(noSkuList);
            count.set(0L);
            numberCount.set(0L);
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
    public ResponseBase saveCsv(CsvReader csvReader, int row, Integer sId, Integer seId, Long uid, Integer pId, Long
            recordingId, Integer menuId, String businessTime, List<String> csvHeadList) {
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
        try {
            while (csvReader.readRecord()) {
                if (index >= row) {
                    //numberCount++
                    CrrUtils.inCreateNumberLong(numberCount);
                    //count ++ 成功数量
                    CrrUtils.inCreateNumberLong(count);
                    //85 == 财务上传ID | 104 运营上传
                    if (menuId == Constants.FINANCE_ID || menuId == Constants.FINANCE_ID_YY) {
                        fsbList = ArrUtils.listT(tList);
                        FinancialSalesBalance fb = setFsb(sId, seId, userName, pId.longValue(), recordingId);
                        for (int j = 0; j < csvReader.getColumnCount(); j++) {
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
            }
        } catch (Exception e) {
            setErrorInfo(recordingId, (numberCount.get() - 1) + "行信息错误,错误原因," + e.getMessage());
        }
        int number = 0;
        try {
            //财务
            if (fsbList != null) {
                if (fsbList.size() > 0) {
                    //插入数据
                    number = fsbService.addInfo(fsbList, menuId);
                }
            }
            //业务
            if (sfbList != null) {
                if (sfbList.size() > 0) {
                    number = busService.AddSalesAmazonAdBusList(sfbList);

                }
            }
        } catch (Exception e) {
            setErrorInfo(recordingId, "数据库存入异常");
        }
        if (number != 0) {
            return printCount(begin, count.get(), index);
        }
        throw new LsException("存入数据失败,请检查信息/文件中所有行的shuId 无效");
    }

    /**
     * 美国 业务存入对象
     */
    public SalesAmazonFbaBusinessreport saveBusiness(SalesAmazonFbaBusinessreport sfb, CsvReader csvReader, Integer
            sId, Integer seId, Long businessTime, List<String> csvHeadList, List<BasicSalesAmazonCsvTxtXslHeader> importHead, int j) throws IOException {
        sfb.setDate(businessTime);
        if (seId == 1 || seId == 4 || seId == 5 || seId == 6
                || seId == 7 || seId == 8 || seId == 9) {
            if (csvHeadList.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
                sfb.setfAsin(StrUtils.repString(csvReader.get(j)));
            else if (csvHeadList.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
                sfb.setsAsin(StrUtils.repString(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
                sfb.setpName(StrUtils.repString(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose()) {
                sfb.setSessionsVisit(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
                sfb.setSessionsPer(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose()) {
                sfb.setPageViews(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose()) {
                sfb.setBuyBoxPer(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose()) {
                sfb.setOrder(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose()) {
                sfb.setOrderB2B(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose()) {
                sfb.setSales(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(10).getImportTemplet()) && importHead.get(10).getOpenClose()) {
                sfb.setSalesB2B(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(11).getImportTemplet()) && importHead.get(11).getOpenClose()) {
                sfb.setOrderItems(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(12).getImportTemplet()) && importHead.get(12).getOpenClose()) {
                sfb.setOrderItemsB2B(StrUtils.replaceInteger(csvReader.get(j)));
            }
        } else {
            if (csvHeadList.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
                sfb.setfAsin(StrUtils.repString(csvReader.get(j)));
            else if (csvHeadList.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
                sfb.setsAsin(StrUtils.repString(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(2).getImportTemplet()) && importHead.get(2).getOpenClose()) {
                sfb.setpName(StrUtils.repString(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(3).getImportTemplet()) && importHead.get(3).getOpenClose()) {
                sfb.setSessionsVisit(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(4).getImportTemplet()) && importHead.get(4).getOpenClose()) {
                sfb.setSessionsPer(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(5).getImportTemplet()) && importHead.get(5).getOpenClose()) {
                sfb.setPageViews(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(6).getImportTemplet()) && importHead.get(6).getOpenClose()) {
                sfb.setBuyBoxPer(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(7).getImportTemplet()) && importHead.get(7).getOpenClose()) {
                sfb.setOrder(StrUtils.replaceInteger(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(8).getImportTemplet()) && importHead.get(8).getOpenClose()) {
                sfb.setSales(StrUtils.repDouble(csvReader.get(j)));
            } else if (csvHeadList.get(j).equals(importHead.get(9).getImportTemplet()) && importHead.get(9).getOpenClose()) {
                sfb.setOrderItems(StrUtils.replaceInteger(csvReader.get(j)));
            }
        }
        if (j == csvReader.getColumnCount()) {
            Long skuId = skuService.getAsinSkuId(sId, seId, sfb.getsAsin());
            String result = skuList(skuId, csvReader, sfb.getfAsin());
            if (StringUtils.isEmpty(result)) {
                return null;
            }
        }
        return sfb;
    }

    /**
     * csv 财务存入对象
     */
    public FinancialSalesBalance saveFinance(FinancialSalesBalance fsb, CsvReader csvReader, Integer sId, Integer seId,
                                             List<String> csvHeadList, List<BasicSalesAmazonCsvTxtXslHeader> importHead, int j) throws
            IOException {
        //设置时间类型转换
        if (csvHeadList.get(j).equals(importHead.get(0).getImportTemplet()) && importHead.get(0).getOpenClose())
            DateUtils.setDate(fsb, seId, csvReader.get(j));
        else if (csvHeadList.get(j).equals(importHead.get(1).getImportTemplet()) && importHead.get(1).getOpenClose()) {
            fsb.setSettlemenId(StrUtils.repString(csvReader.get(j)));
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
            fsb.setSku(StrUtils.repString(csvReader.get(j)));
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
            fsb.setSales(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(13).getImportTemplet()) && importHead.get(13).getOpenClose()) {
            fsb.setShippingCredits(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(14).getImportTemplet()) && importHead.get(14).getOpenClose()) {
            fsb.setGiftwrapCredits(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(15).getImportTemplet()) && importHead.get(15).getOpenClose()) {
            fsb.setPromotionalRebates(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(16).getImportTemplet()) && importHead.get(16).getOpenClose()) {
            fsb.setSalesTax(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(17).getImportTemplet()) && importHead.get(17).getOpenClose()) {
            fsb.setMarketplaceFacilitatorTax(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(18).getImportTemplet()) && importHead.get(18).getOpenClose()) {
            fsb.setSellingFees(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(19).getImportTemplet()) && importHead.get(19).getOpenClose()) {
            fsb.setFbaFee(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(20).getImportTemplet()) && importHead.get(20).getOpenClose()) {
            fsb.setOtherTransactionFees(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(21).getImportTemplet()) && importHead.get(21).getOpenClose()) {
            fsb.setOther(StrUtils.replaceDouble(csvReader.get(j)));
        } else if (csvHeadList.get(j).equals(importHead.get(22).getImportTemplet()) && importHead.get(22).getOpenClose()) {
            fsb.setTotal(StrUtils.replaceDouble(csvReader.get(j)));
        }
        //这里最后执行
        if ((j + 1) == csvReader.getColumnCount()) {
            StrUtils.isService(fsb.getType(), fsb);
            Long skuId = skuService.selSkuId(sId, seId, fsb.getSku());
            String result = skuList(skuId, csvReader, fsb.getSku());
            if (StringUtils.isEmpty(result)) {
                return null;
            }
            fsb.setSkuId(skuId);
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
            if (StringUtils.isEmpty(result)) {
                return null;
            }
        }
        //如果sku是空的  直接返回设置NULL
        return "success";
    }

    /**
     * csv 对比表头返回
     *
     * @return
     */
    public boolean compareHeadCsv
    (List<String> oldHeadList, List<String> sqlHeadList) {
        List<String> headList = new ArrayList<>();
        //转换下头信息
        for (int i = 0; i < oldHeadList.size(); i++) {
            String head = oldHeadList.get(i).replace("\"", "").replace("﻿", "").trim();
            headList.add(head);
            System.out.println(head);
        }
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
            CrrUtils.inCreateList(noSkuList);
            //count --
            CrrUtils.delCreateNumberLong(count);
            //sumNoSku ++
            CrrUtils.inCreateNumberInteger(sumErrorSku);
            List<String> skuListNo = new ArrayList<>();
            for (int i = 0; i < csvReader.getColumnCount(); i++) {
                skuListNo.add(csvReader.get(i).replace(",", "."));
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
            e.printStackTrace();
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
        String typeName = typeMapper.getTypeName(seId, type);
        //如果数据库查询出来为空
        if (StringUtils.isEmpty(typeName)) {
            String result = exportCsvType(csvReader, -1L);
            return result;
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
    private ResponseBase saveUserUploadInfo(String msg, Long recordingId, String
            fileName, List<String> head, int type, String saveFilePath, String uuidName) {
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
            msg = " ,有" + sumErrorSku.get() + "条没有skuId/没有type";
            sumErrorSku.set(0);
            return upUserUpload(2, recordingId, fileName, msg, saveFilePath, uuidName);
        }
        //上传成功 都有skuId~
        return upUserUpload(0, recordingId, fileName, msg, saveFilePath, uuidName);
    }

    /**
     * 封装通用更新方法
     */
    private ResponseBase upUserUpload(int status, Long id, String fileName, String msg, String saveFilePath, String uuIdName) {
        UserUpload upload;
        switch (status) {
            case 0:
                upload = recordInfo(status, msg, id, fileName, null, null);
                return JsonData.setResultSuccess(msg, upload);
            case 2:
                int fileIndex = saveFilePath.lastIndexOf("/");
                upload = recordInfo(status, msg, id, "NO" + fileName, saveFilePath.substring(0, fileIndex) + "SkuNo/", uuIdName);
                return JsonData.setResultSuccess(msg, upload);
        }
        return null;
    }

    /**
     * 封装更新信息
     *
     * @param status
     * @param msg
     */
    private UserUpload recordInfo(Integer status, String msg, Long id, String fileName, String saveFilePath, String uuIdName) {
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
    public ResponseBase printCount(Long begin, Long successNumber, int index) {
        // 结束时间
        Long end = new Date().getTime();
        return JsonData.setResultSuccess("总共" + index + "条数据/ 真实数据" + successNumber + "条数据插入成功/====>失败 " + sumErrorSku.get() + "条/花费时间 : " + (end - begin) / 1000 + " s");
    }

    /**
     * 封装通用获得头信息对比
     *
     * @param seId
     * @param tbId
     * @return
     */
    public List<String> getHeadInfo(Integer seId, int tbId, Integer areaId, Integer shopId) {
        //85 tbId 跟 104 tbId头信息一致
        if (tbId == Constants.FINANCE_ID_YY) {
            return headService.headerList(seId, Constants.FINANCE_ID, areaId, shopId);
        }
        return headService.headerList(seId, tbId, areaId, shopId);
    }

    /**
     * 洲业务 sku asin  业务对比获得sku
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
     * 通用设置Txt 没有sku/导出文件
     *
     * @return
     */
    public void exportTxtType(List<String> head, String line) {
        CrrUtils.inCreateList(noSkuList);
        //count --
        CrrUtils.delCreateNumberLong(count);
        //sumNoSku ++
        CrrUtils.inCreateNumberInteger(sumErrorSku);
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
     */
    public void setErrorInfo(Long recordingId, String msg) {
        recordInfo(1, msg, recordingId, null, null, null);
        throw new LsException(msg);
    }
}

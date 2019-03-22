package com.dt.user.controller;


import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.customize.PermissionCheck;
import com.dt.user.exception.LsException;
import com.dt.user.model.*;
import com.dt.user.service.*;
import com.dt.user.toos.Constants;
import com.dt.user.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadController {
    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private UserUploadService userUploadService;


    /**
     * 下载接口
     *
     * @param request
     * @param response
     * @param fileMap
     * @return
     */
    @PostMapping("/downloadCommonFile")
    @PermissionCheck("download")
    public ResponseBase downloadFile(HttpServletRequest
                                             request, HttpServletResponse response, @RequestBody Map<String, Object> fileMap) {
        String filePath = (String) fileMap.get("filePath");
        FileUtils.downloadFile(filePath, response, request);
        return null;
    }

    /**
     * 上传接口
     *
     * @param request
     * @param sId
     * @param seId
     * @param payId
     * @param menuId
     * @param areaId
     * @param businessTime
     * @return
     */
    @PostMapping("/file")
    @PermissionCheck("upload")
    public ResponseBase uploadFile(HttpServletRequest request, @RequestParam("sId") String sId,
                                   @RequestParam("seId") String seId, @RequestParam("payId") String payId,
                                   @RequestParam("menuId") String menuId,
                                   @RequestParam("areaId") String areaId, @RequestParam("businessTime") String businessTime) {
        MultipartFile file;
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("files");
        //记录用户上传信息~
        boolean isUpload = true;
        int fileCount = 0;
        String msg;
        List<UserUpload> uploadList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < files.size(); i++) {
                file = files.get(i);
                // String contentType = file.getContentType();//图片||文件类型
                String fileName = file.getOriginalFilename();//图片||文件名字
                String uuId = UuIDUtils.fileUuId(fileName);
                try {
                    FileUtils.uploadFile(file.getBytes(), Constants.SAVE_FILE_PATH, uuId);
                    msg = "上传成功~";
                } catch (Exception e) {
                    isUpload = false;
                    msg = "上传失败~" + fileName;
                    fileCount++;
                    sb.append(fileName);
                }
                //店铺ID
                Integer shopId = StrUtils.isIntegerNull(sId);
                //站点ID
                Integer siteId = StrUtils.isIntegerNull(seId);
                //菜单ID
                Integer tbId = StrUtils.isIntegerNull(menuId);
                // 付款类型选择ID
                Integer pId = StrUtils.isIntegerNull(payId);
                // 洲ID
                Integer aId = StrUtils.isIntegerNull(areaId);
                int status = isUpload ? 0 : 4;
                //记录用户上传信息~
                UserUpload upload = uploadOperating(siteId, shopId, fileName, Constants.SAVE_FILE_PATH, ReqUtils.getUid(), pId, status, msg, tbId, aId, businessTime, uuId);
                if (isUpload) {
                    uploadList.add(upload);
                }
                isUpload = true;
            }
            String getMsg = "上传了" + files.size() + "个文件/" + "其中" + fileCount + "个文件失败~ 失败文件名字" + sb.toString() + "";
            return JsonData.setResultSuccess(getMsg, uploadList);
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            return JsonData.setResultError("上传异常,请检查问题", uploadList);
        }
    }

    /**
     * 数据处理接口
     *
     * @return
     */
    @PostMapping("/addInfo")
    public ResponseBase redFileInfo(@RequestBody UserUpload upload) {
        List<ResponseBase> responseBaseList = new ArrayList<>();
        int baseNum = upload.getUploadSuccessList().size();
        ResponseBase responseBase;
        if (baseNum > 0) {
            try {
                for (int i = 0; i < baseNum; i++) {
                    UserUpload userUpload = upload.getUploadSuccessList().get(i);
                    int fileIndex = userUpload.getName().lastIndexOf(".");
                    String typeFile = userUpload.getName().substring(fileIndex + 1);
                    if (typeFile.equals("csv")) {
                        responseBase = consumerService.importCsv(userUpload.getUuidName(), userUpload.getFilePath(), userUpload.getName(), userUpload.getSiteId(), userUpload.getShopId(), userUpload.getUid(),
                                userUpload.getpId(), userUpload.getId(), userUpload.getTbId(), userUpload.getBusinessTime()).get();
                        responseBaseList.add(responseBase);
                    } else if (typeFile.equals("xlsx") || typeFile.equals("xls")) {
                        responseBase = consumerService.importXls(userUpload.getUuidName(), userUpload.getFilePath(), userUpload.getName(), userUpload.getSiteId(), userUpload.getShopId(), userUpload.getUid(), userUpload.getId(), userUpload.getTbId()).get();
                        responseBaseList.add(responseBase);
                    } else if (typeFile.equals("txt")) {
                        responseBase = consumerService.importTxt(userUpload.getUuidName(), userUpload.getFilePath(), userUpload.getName(), userUpload.getShopId(), userUpload.getUid(), userUpload.getId(), userUpload.getTbId(), userUpload.getAreaId()).get();
                        responseBaseList.add(responseBase);
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new LsException("数据处理异常");
            }
        }
        return JsonData.setResultSuccess(responseBaseList);
    }


    /**
     * 通过记录用户上传信息操作
     *
     * @param siteId
     * @param shopId
     * @param fileName
     * @param saveFilePath
     * @param uId
     * @return
     */
    public UserUpload uploadOperating(Integer siteId, Integer shopId,
                                      String fileName, String saveFilePath,
                                      Long uId, Integer pId, Integer status,
                                      String msg, Integer tbId, Integer aId, String businessTime, String uuId) {
        UserUpload upload = new UserUpload();
        //存入打碎后的文件名称
        upload.setUuidName(uuId);
        //存入真实文件名字
        upload.setName(fileName);
        //存入上传时间
        upload.setCreateDate(new Date().getTime());
        //用户ID
        upload.setUid(uId);
        //上传服务器路径
        upload.setFilePath(saveFilePath);
        //站点ID
        if (siteId != null) {
            upload.setSiteId(siteId);
        }
        //店铺ID
        if (shopId != null) {
            upload.setShopId(shopId);
        }
        //区域ID
        upload.setAreaId(aId);
        //付款类型ID
        upload.setpId(pId);
        //上传状态
        upload.setStatus(status);
        //上传信息
        upload.setRemark(msg);
        //菜单信息
        upload.setTbId(tbId);
        //业务报告时间信息
        if (!businessTime.equals("undefined")) {
            upload.setBusinessTime(businessTime);
        }
        userUploadService.addUserUploadInfo(upload);
        return upload;
    }
}
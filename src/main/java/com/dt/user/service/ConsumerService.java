package com.dt.user.service;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.UserUpload;

import java.util.concurrent.Future;

public interface ConsumerService {
    /**
     * 封装处理数据Txt
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
    Future<ResponseBase> importTxt(String uuIdName, String saveFilePath, String fileName, Integer shopId, Long uid, Long
            recordingId, Integer tbId, Integer aId) throws Exception;

    /**
     * 封装处理数据Xls
     * @return
     */
    Future<ResponseBase> importXls(UserUpload userUpload) throws Exception;


    /**
     * 封装处理数据Csv
     * @return
     */
    Future<ResponseBase> importCsv(UserUpload userUpload) throws Exception;
}
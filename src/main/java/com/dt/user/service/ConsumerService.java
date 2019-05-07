package com.dt.user.service;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.UserUpload;

import java.util.concurrent.Future;

public interface ConsumerService {
    /**
     * 封装处理数据Txt
     * @return
     */
    Future<ResponseBase> importTxt(UserUpload userUpload) throws Exception;

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
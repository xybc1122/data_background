package com.dt.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.JavaSqlNameMapper;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.Parent.ParentUploadInfo;
import com.dt.user.service.JavaSqlNameService;
import com.dt.user.service.RedisService;
import com.dt.user.toos.Constants;
import com.dt.user.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JavaSqlNameServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/19 14:42
 **/
@Service
public class JavaSqlNameServiceImpl implements JavaSqlNameService {
    @Autowired
    private JavaSqlNameMapper nameMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public ResponseBase serviceSet(JavaSqlName javaSqlName) {
        int result = nameMapper.set(javaSqlName);
        if (result > 0) {
            return JsonData.setResultSuccess("success");
        }
        return JsonData.setResultError("error");
    }

    @Override
    public List<JavaSqlName> get(String model) {
        String rList = redisService.getStringKey(Constants.MODEL + model);
        if (StringUtils.isEmpty(rList)) {
            //走DB
            List<JavaSqlName> javaSqlNames = nameMapper.selectSqlName(model);
            if (javaSqlNames != null && javaSqlNames.size() > 0) {
                //刷入缓存
                redisService.setString(Constants.MODEL + model, JsonUtils.getJsonObj(javaSqlNames));
                return javaSqlNames;
            }
        }
        return JSONObject.parseArray(rList, JavaSqlName.class);
    }
}

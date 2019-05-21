package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.SystemMapper.SystemUserConfigMapper;
import com.dt.project.model.System.SystemUserConfig;
import com.dt.project.service.RedisService;
import com.dt.project.service.SystemService.SystemUserConfigService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName SystemUserConfigServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/20 10:12
 **/
@Service
public class SystemUserConfigServiceImpl implements SystemUserConfigService {
    @Autowired
    private SystemUserConfigMapper configMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Integer serviceSaveUserConfig(SystemUserConfig userConfig) {
        int result = configMapper.saveUserConfig(userConfig);
        if (result == 0) {
            throw new LsException("新增失败");
        }
        return userConfig.getConfigId().intValue();
    }

    @Override
    @Transactional
    public ResponseBase saveUserConfig(Map<String, Object> confMap) {
        Integer mid = (Integer) confMap.get("mid");
        String programName = (String) confMap.get("programName");
        if (mid == null || programName == null) {
            return JsonData.setResultError("error");
        }
        String keys = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid;
        Set setKeys = redisService.getKeys(keys);
        if (setKeys.size() >= 3) {
            return JsonData.setResultError("不能超过3个方案");
        }
        for (Object key : setKeys) {
            String v = key.toString();
            if (v.substring(v.indexOf(",") + 1).equals(programName)) {
                return JsonData.setResultError("方案名重复");
            }
        }
        Integer configId = serviceSaveUserConfig(new
                SystemUserConfig(mid, new Date().getTime(), ReqUtils.getUserName()));
        String configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + configId + "," + programName;
        redisService.setString(configKey, setJSON(confMap, mid, configId, programName));
        return JsonData.setResultSuccess("success");
    }

    @Override
    public ResponseBase getConfig(Integer mid) {
        String configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid;
        //模糊查询所有configKey开头的 key
        Set configKeys = redisService.getKeys(configKey);
        List<Object> userConfigList = new ArrayList<Object>();
        for (Object key : configKeys) {
            userConfigList.add(JSONObject.parseObject(redisService.getStringKey(key.toString())));
        }
        return JsonData.setResultSuccess("success", userConfigList);
    }

    @Override
    @Transactional
    public ResponseBase delConfig(Map<String, Object> confMap) {
        Integer mid = (Integer) confMap.get("mid");
        String configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/";

        return null;
    }

    @Override
    public ResponseBase upConfig(Map<String, Object> confMap) {
        String configKey;
        Integer configId = (Integer) confMap.get("configId");
        Integer mid = (Integer) confMap.get("mid");
        String programName = (String) confMap.get("programName");
        if (mid == null || programName == null || configId == null) {
            return JsonData.setResultError("error");
        }
        configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + configId;
        Set configKeys = redisService.getKeys(configKey);
        for (Object key : configKeys) {
            redisService.delKey(key.toString());
        }
        redisService.setString(configKey + "," + programName, setJSON(confMap, mid, configId, programName));
        return JsonData.setResultSuccess("success");
    }

    private String setJSON(Map<String, Object> confMap, Integer mid, Integer configId, String programName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hiddenFieldsList", confMap.get("hiddenFieldsList"));
        jsonObject.put("queryTwoList", confMap.get("queryTwoList"));
        jsonObject.put("inputQueryData", confMap.get("inputQueryData"));
        jsonObject.put("dropTable", confMap.get("dropTable"));
        jsonObject.put("mid", mid);
        jsonObject.put("configId", configId);
        jsonObject.put("uid", ReqUtils.getUid());
        jsonObject.put("programName", programName);
        jsonObject.put("createDate", new Date().getTime());
        return jsonObject.toJSONString();
    }
}

package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.systemMapper.SystemUserConfigMapper;
import com.dt.project.model.system.SystemUserConfig;
import com.dt.project.redis.RedisService;
import com.dt.project.service.systemService.SystemUserConfigService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
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
        String configKey = null;
        try {
            Integer mid = (Integer) confMap.get("mid");
            String programName = (String) confMap.get("programName");
            List dropTableList = (List) confMap.get("dropTable");
            if (mid == null || programName == null || dropTableList == null || dropTableList.size() == 0) {
                return JsonData.setResultError("error");
            }
            Set setKeys = keys(mid);
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
            configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + configId + "," + programName;
            redisService.setString(configKey, setJSON(confMap, mid, configId, programName, dropTableList));
            return JsonData.setResultSuccess("success");
        } catch (Exception e) {
            if (configKey != null) {
                redisService.delKey(configKey);
            }
            throw new LsException("error");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseBase getConfig(Integer mid) {
        Set setKeys = keys(mid);
        List<Object> userConfigList = new ArrayList<Object>();
        Set<String> sortSet = new TreeSet<String>((o1, o2) -> o2.compareTo(o1));
        sortSet.addAll(setKeys);
        for (Object key : sortSet) {
            JSONObject object = JSONObject.parseObject(redisService.getStringKey(key.toString()));
            //1代表没有被物理删除的
            if (object.containsKey("delOrNot")) {
                if ((Integer) object.get("delOrNot") == 1) {
                    userConfigList.add(object);
                }
            }
        }
        return JsonData.setResultSuccess("success", userConfigList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseBase delConfig(Map<String, Object> confMap) {
        try {
            Integer mid = (Integer) confMap.get("mid");
            List configIds = (List) confMap.get("configIds");
            Set setKeys = keys(mid);
            List<JSONObject> listObj = new ArrayList<>();
            List<String> keys = new ArrayList<>();
            //获得keys 跟JSONObj 对象
            for (Object key : setKeys) {
                keys.add(key.toString());
                listObj.add(JSONObject.parseObject(redisService.getStringKey(key.toString())));
            }
            redisService.stringRedisTemplate().execute(new SessionCallback<List<Object>>() {
                public List<Object> execute(RedisOperations operations) throws DataAccessException {
                    operations.multi();
                    for (int i = 0; i < listObj.size(); i++) {
                        JSONObject object = listObj.get(i);
                        if (object.containsKey("configId")) {
                            if (configIds != null && configIds.size() > 0) {
                                for (Object configId : configIds) {
                                    if ((int) configId == (int) object.get("configId")) {
                                        object.put("delOrNot", 0);
                                        operations.opsForValue().set(keys.get(i), object.toJSONString());
                                    }
                                }
                            }
                        }
                    }
                    return operations.exec();
                }
            });
            return JsonData.setResultSuccess("success");
        } catch (Exception e) {
            return JsonData.setResultError("error");
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public ResponseBase upConfig(Map<String, Object> confMap) {
        String configKey;
        try {
            Integer configId = (Integer) confMap.get("configId");
            Integer mid = (Integer) confMap.get("mid");
            List dropTableList = (List) confMap.get("dropTable");
            String programName = (String) confMap.get("programName");
            if (mid == null || programName == null || configId == null || dropTableList == null || dropTableList.size() == 0) {
                return JsonData.setResultError("error");
            }
            configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid + "/" + configId;
            redisService.stringRedisTemplate().execute(new SessionCallback<List<Object>>() {
                public List<Object> execute(RedisOperations operations) throws DataAccessException {
                    Set<String> keys = operations.keys(configKey + "*");
                    operations.multi();
                    if (keys == null) {
                        throw new LsException("警告异常key找不到");
                    }
                    operations.delete(keys);
                    operations.opsForValue().set(configKey + "," + programName, setJSON(confMap, mid, configId, programName, dropTableList));
                    return operations.exec();
                }
            });
            return JsonData.setResultSuccess("success");
        } catch (Exception e) {
            throw new LsException("error");
        }
    }

    /**
     * 获得Keys
     *
     * @param mid
     * @return
     */
    private Set keys(Integer mid) {
        String configKey = Constants.USER_CONFIG + ReqUtils.getUid() + "/" + mid;
        //模糊查询所有configKey开头的 key
        return redisService.getKeys(configKey);
    }

    private String setJSON(Map<String, Object> confMap, Integer mid, Integer configId, String programName, List dropTableList) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hiddenFieldsList", confMap.get("hiddenFieldsList"));
        jsonObject.put("queryTwoList", confMap.get("queryTwoList"));
        jsonObject.put("inputQueryData", confMap.get("inputQueryData"));
        jsonObject.put("dropTable", dropTableList);
        jsonObject.put("mid", mid);
        jsonObject.put("configId", configId);
        jsonObject.put("uid", ReqUtils.getUid());
        jsonObject.put("delOrNot", 1);
        jsonObject.put("programName", programName);
        jsonObject.put("createDate", new Date().getTime());
        return jsonObject.toJSONString();
    }
}

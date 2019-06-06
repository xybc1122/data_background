package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.HeadMenuMapper;
import com.dt.project.model.TableHead;
import com.dt.project.model.TbHeadMenu;
import com.dt.project.redis.RedisService;
import com.dt.project.service.HeadMenuService;
import com.dt.project.service.TableHeadService;
import com.dt.project.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class HeadMenuMapperServiceImpl implements HeadMenuService {

    @Autowired
    private HeadMenuMapper headMenuMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private TableHeadService tableHeadService;

    @Override
    @Transactional
    public ResponseBase addHeadMenu(Map<String, Object> mhMap) {
        String mid = (String) mhMap.get("mid");
        List<Integer> thIds = (List<Integer>) mhMap.get("thIds");
        TbHeadMenu tbHeadMenu = new TbHeadMenu();
        for (Integer thId : thIds) {
            tbHeadMenu.setMid(Long.parseLong(mid));
            tbHeadMenu.setThId(thId.longValue());
            int result = headMenuMapper.addHeadMenu(tbHeadMenu);
            if (result == 0) {
                throw new LsException("新增失败");
            }
        }
        setConfig(thIds, Integer.parseInt(mid), "save");
        return JsonData.setResultSuccess("新增成功");
    }

    @Override
    @Transactional
    public ResponseBase delHeadMenu(Map<String, Object> mhMap) {
        String mid = (String) mhMap.get("mid");
        List<Integer> thIds = (List<Integer>) mhMap.get("thIds");
        TbHeadMenu tbHeadMenu = new TbHeadMenu();
        for (Integer thId : thIds) {
            tbHeadMenu.setMid(Long.parseLong(mid));
            tbHeadMenu.setThId(thId.longValue());
            int result = headMenuMapper.delHeadMenu(tbHeadMenu);
            if (result == 0) {
                throw new LsException("删除失败");
            }
        }
        setConfig(thIds, Integer.parseInt(mid), "del");
        return JsonData.setResultSuccess("删除成功");
    }

    /**
     * 设置config Key里的 dropTable
     *
     * @param thIds
     * @param mid
     */
    private void setConfig(List<Integer> thIds, Integer mid, String type) {
        if (thIds.size() <= 0) {
            return;
        }
        String configKey = Constants.USER_CONFIG + 5 + "/" + 75;
        Set keys = redisService.getKeys(configKey);
        if (keys.size() <= 0) {
            return;
        }
        List<Integer> hidList = new ArrayList<>();
        for (Object key : keys) {
            JSONArray dropTableArr;
            String configValue = redisService.getStringKey(key.toString());
            JSONObject configJson = JSONObject.parseObject(configValue);
            String programName = (String) configJson.get("programName");
            Integer configId = (Integer) configJson.get("configId");
            //收集id 跟下标
            if (configJson.containsKey("dropTable")) {
                dropTableArr = configJson.getJSONArray("dropTable");
                if (type.equals("del")) {
                    for (Object tableHead : dropTableArr) {
                        JSONObject tHJson = (JSONObject) JSONObject.parse(tableHead.toString());
                        if (tHJson.containsKey("id")) {
                            hidList.add((Integer) tHJson.get("id"));
                        }
                    }
                    //如果有匹配删除
                    for (Integer thId : thIds) {
                        for (int j = 0; j < hidList.size(); j++) {
                            if (thId.equals(hidList.get(j))) {
                                dropTableArr.remove(j);
                                break;
                            }
                        }
                    }
                } else if (type.equals("save")) {
                    //in查询 add到 dropTableArr里
                    List<TableHead> tMenuList = tableHeadService.serviceGetListTableHead(thIds);
                    dropTableArr.addAll(tMenuList);
                }
                configJson.put("dropTable", dropTableArr);
                redisService.setString(configKey + "/" + configId + "," + programName, configJson.toJSONString());
            }
        }
    }
}

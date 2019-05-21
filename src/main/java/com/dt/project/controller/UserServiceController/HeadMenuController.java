package com.dt.project.controller.UserServiceController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.TableHead;
import com.dt.project.model.TbHeadMenu;
import com.dt.project.service.HeadMenuService;
import com.dt.project.service.RedisService;
import com.dt.project.service.TableHeadService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api/v1/hm")
@RestController
public class HeadMenuController {

    @Autowired
    private HeadMenuService headMenuService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private TableHeadService tableHeadService;

    /**
     * 新增菜单跟表头关联数据
     *
     * @param mhMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/saveHeadMenu")
    public ResponseBase saveHeadMenu(@RequestBody Map<String, Object> mhMap) {
        String mid = (String) mhMap.get("mid");
        List<Integer> thIds = (List<Integer>) mhMap.get("thIds");
        TbHeadMenu tbHeadMenu = new TbHeadMenu();
        for (Integer thId : thIds) {
            tbHeadMenu.setMid(Long.parseLong(mid));
            tbHeadMenu.setThId(thId.longValue());
            headMenuService.addHeadMenu(tbHeadMenu);
        }
        setConfig(thIds, Integer.parseInt(mid), "save");
        return JsonData.setResultSuccess("新增成功");
    }

    /**
     * 删除菜单跟表头关联数据
     *
     * @param mhMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/delTbHeadMenu")
    public ResponseBase delTbHeadMenu(@RequestBody Map<String, Object> mhMap) {
        String mid = (String) mhMap.get("mid");
        List<Integer> thIds = (List<Integer>) mhMap.get("thIds");
        TbHeadMenu tbHeadMenu = new TbHeadMenu();
        for (Integer thId : thIds) {
            tbHeadMenu.setMid(Long.parseLong(mid));
            tbHeadMenu.setThId(thId.longValue());
            headMenuService.delHeadMenu(tbHeadMenu);
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

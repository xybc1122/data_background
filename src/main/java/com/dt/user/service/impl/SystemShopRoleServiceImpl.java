package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SystemMapper.SystemShopRoleMapper;
import com.dt.user.model.System.SystemShopRole;
import com.dt.user.service.SystemService.SystemShopRoleService;
import com.dt.user.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Date;

/**
 * @ClassName SystemShopRoleServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 13:32
 **/
@Service
public class SystemShopRoleServiceImpl implements SystemShopRoleService {


    @Autowired
    private SystemShopRoleMapper roleMapper;

    @Override
    @Transactional
    public ResponseBase serviceInsertShopRole(Map<String, Object> sRMap) {
        String shopIds = (String) sRMap.get("sIds");
        String delSid = (String) sRMap.get("delSid");
        Integer rId = (Integer) sRMap.get("rId");
        if (rId == null) return JsonData.setResultError("参数为空,请检查");
        try {
            //如果删除 不是null
            if (StringUtils.isNotBlank(delSid)) roleMapper.deleteByShopRole(rId, delSid);
            //删除角色下的所有关联
            if (StringUtils.isNotBlank(shopIds)) {
                int index = shopIds.indexOf(",");
                if (index != -1) {
                    String[] sIdsArr = shopIds.split(",");
                    for (String sId : sIdsArr) {
                        set(Integer.parseInt(sId), rId);
                    }
                    return JsonData.setResultSuccess("success");
                }
                //如果只有一个参数 直接更新;
                set(Integer.parseInt(shopIds), rId);
            }
        } catch (Exception e) {
            return JsonData.setResultError("error");
        }
        return JsonData.setResultSuccess("success");
    }

    /**
     * 设置参数
     *
     * @param sid
     * @param rid
     */
    public void set(Integer sid, Integer rid) {
        //添加店铺ID  添加角色ID
        roleMapper.insertShopRole(new SystemShopRole(rid, sid, new Date().getTime(), ReqUtils.getUserName()));
    }
}

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
        Integer rId = (Integer) sRMap.get("rId");
        if (StringUtils.isBlank(shopIds) || rId == null) {
            return JsonData.setResultError("参数为空，请检查");
        }
        try {
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
            return JsonData.setResultSuccess("success");
        } catch (Exception e) {
            return JsonData.setResultError("error");
        }
    }

    /**
     * 设置参数
     *
     * @param sId
     * @param rId
     */
    public void set(Integer sId, Integer rId) {
        //添加店铺ID  添加角色ID
        roleMapper.insertShopRole(new SystemShopRole(rId, sId, new Date().getTime(), ReqUtils.getUserName()));
    }
}

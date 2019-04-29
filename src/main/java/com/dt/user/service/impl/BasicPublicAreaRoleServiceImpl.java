package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.AreaRoleDto;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.BasePublicMapper.BasicPublicAreaRoleMapper;
import com.dt.user.model.BasePublicModel.BasicPublicAreaRoleSite;
import com.dt.user.service.BasePublicService.BasicPublicAreaRoleService;
import com.dt.user.service.BasePublicService.BasicPublicAreaRoleSiteService;
import com.dt.user.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName BasicPublicAreaRoleServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/28 10:51
 **/
@Service
public class BasicPublicAreaRoleServiceImpl implements BasicPublicAreaRoleService {
    @Autowired
    private BasicPublicAreaRoleMapper aRMapper;
    @Autowired
    private BasicPublicAreaRoleSiteService aRSService;


    @Override
    @Transactional
    public ResponseBase serviceInsertARole(AreaRoleDto record) {
        int listCount = 0;
        int arrCount = 0;
        boolean listFlg = false;
        boolean arrFlg = false;
        String uName = ReqUtils.getUserName();
        Long date = new Date().getTime();
        if (record.getAreaRoleDtoList() != null && record.getAreaRoleDtoList().size() > 0) {
            for (AreaRoleDto aR : record.getAreaRoleDtoList()) {
                //是否是全部删除 true全部删除
                if (aR.getRemoveArea()) {
                    //先查找获得arid
                    Integer arId = serviceSelectArId(aR.getAid(), record.getRid());
                    if (arId == null) throw new LsException("表中无AR_ID操作失败");
                    //删除 区域 角色表数据
                    serviceDeleteByARole(aR.getAid(), record.getRid());
                    //如果这里是  != -1
                    if (aR.getDelSeId().contains(",")) {
                        String[] strDelSeId = aR.getDelSeId().split(",");
                        for (String delId : strDelSeId) {
                            //循环删除
                            aRSService.serviceDeleteARS(arId, Integer.parseInt(delId));
                        }
                    } else {
                             //单个删除
                             aRSService.serviceDeleteARS(arId, Integer.parseInt(aR.getDelSeId()));
                    }
                }
                if (StringUtils.isNotBlank(aR.getSeIds())) {
                    aR.setRid(record.getRid());
                    aR.setCreateDate(date);
                    aR.setCreateUser(uName);
                    //添加 角色 区域表
                    listCount += aRMapper.insertARole(aR);
                    if (listCount == record.getAreaRoleDtoList().size()) listFlg = true;
                    //如果这里 != -1
                    if (aR.getSeIds().contains(",")) {
                        String[] strAR = aR.getSeIds().split(",");
                        for (String seId : strAR) {
                            //先添加 角色跟区域配置表
                            arrCount += set(aR.getArId(), Integer.parseInt(seId), date, uName);
                        }
                        if (arrCount == strAR.length) arrFlg = true;
                    } else {
                        //如果是-1
                        arrCount += set(aR.getArId(), Integer.parseInt(aR.getSeIds()), date, uName);
                        if (arrCount > 0) arrFlg = true;
                    }

                    // if (listFlg && arrFlg) return JsonData.setResultSuccess("success");
                }
            }
        }
        // throw new LsException("error");
        return null;
    }


    @Override
    public int serviceDeleteByARole(Integer aid, Integer rid) {
        return aRMapper.deleteByARole(aid, rid);
    }

    @Override
    public Integer serviceSelectArId(Integer aid, Integer rid) {
        return aRMapper.selectArId(aid, rid);
    }

    public int set(Integer arId, Integer seId, Long date, String userName) {
        BasicPublicAreaRoleSite aRS = new BasicPublicAreaRoleSite();
        aRS.setArId(arId);
        aRS.setSeId(seId);
        aRS.setCreateDate(date);
        aRS.setCreateUser(userName);
        return aRSService.serviceInsertARSInfo(aRS);
    }
}

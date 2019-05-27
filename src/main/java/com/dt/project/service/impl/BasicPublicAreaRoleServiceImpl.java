package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.dto.AreaRoleDto;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.basePublicMapper.BasicPublicAreaRoleMapper;
import com.dt.project.model.basePublicModel.BasicPublicAreaRoleSite;
import com.dt.project.service.basePublicService.BasicPublicAreaRoleService;
import com.dt.project.service.basePublicService.BasicPublicAreaRoleSiteService;
import com.dt.project.utils.ReqUtils;
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
        String uName = ReqUtils.getUserName();
        Long date = new Date().getTime();
        if (record.getAreaRoleDtoList() != null && record.getAreaRoleDtoList().size() > 0) {
            for (AreaRoleDto aR : record.getAreaRoleDtoList()) {
                //如果是null 值代表 没有修改区域   是否选择 区域 如果是true  代表选中
                if (aR.getAreaChecked() != null && aR.getAreaChecked()) {
                    aR.setRid(record.getRid());
                    aR.setCreateDate(date);
                    aR.setCreateUser(uName);
                    //添加 角色 区域表
                    int iARCount = aRMapper.insertARole(aR);
                    if (iARCount <= 0) throw new LsException("insertARole添加失败");

                    if (StringUtils.isNotBlank(aR.getSeIds())) {
                        //如果下面还有要添加的站点的话
                        saveSite(aR.getSeIds(), aR.getArId(), date, uName);
                    }
                }
                //如果没有操作区域  只添加站点的话
                if (aR.getAreaChecked() == null) {
                    //单独只添加站点的话 说明已经有洲了
                    if (StringUtils.isNotBlank(aR.getSeIds())) {
                        Integer arId = serviceSelectArId(aR.getAid(), record.getRid());
                        saveSite(aR.getSeIds(), arId, date, uName);
                    }
                }
                //如果有删除的数据
                if (StringUtils.isNotBlank(aR.getDelSeId())) {
                    //先查找获得arid
                    Integer arId = serviceSelectArId(aR.getAid(), record.getRid());
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
                if (aR.getAreaChecked() != null && !aR.getAreaChecked()) {
                    //删除 区域 角色表数据
                    serviceDeleteByARole(aR.getAid(), record.getRid());
                }
            }
        }
        return JsonData.setResultSuccess("success");
    }


    @Override
    public int serviceDeleteByARole(Integer aid, Integer rid) {
        int delCount = aRMapper.deleteByARole(aid, rid);
        if (delCount <= 0) throw new LsException("deleteByARole删除失败");
        return delCount;
    }

    @Override
    public Integer serviceSelectArId(Integer aid, Integer rid) {
        Integer arId = aRMapper.selectArId(aid, rid);
        if (arId == null) throw new LsException("表中无AR_ID操作失败");
        return arId;
    }

    public void set(Integer arId, Integer seId, Long date, String userName) {
        BasicPublicAreaRoleSite aRS = new BasicPublicAreaRoleSite();
        aRS.setArId(arId);
        aRS.setSeId(seId);
        aRS.setCreateDate(date);
        aRS.setCreateUser(userName);
        int seCount = aRSService.serviceInsertARSInfo(aRS);
        if (seCount <= 0) throw new LsException("insertARSInfo添加失败");
    }

    /**
     * save站点
     *
     * @param seIds
     * @param arId
     * @return
     */
    public void saveSite(String seIds, Integer arId, Long date, String uName) {
        //如果这里 != -1
        if (seIds.contains(",")) {
            String[] strAR = seIds.split(",");
            for (String seId : strAR) {
                //先添加 角色跟区域配置表
                set(arId, Integer.parseInt(seId), date, uName);

            }
        } else {
            //如果是-1
            set(arId, Integer.parseInt(seIds), date, uName);
        }
    }


}

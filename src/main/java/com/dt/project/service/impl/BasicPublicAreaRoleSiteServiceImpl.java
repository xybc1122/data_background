package com.dt.project.service.impl;

import com.dt.project.exception.LsException;
import com.dt.project.mapper.basePublicMapper.BasicPublicAreaRoleSiteMapper;
import com.dt.project.model.basePublic.BasicPublicAreaRoleSite;
import com.dt.project.service.basePublicService.BasicPublicAreaRoleSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BasicPublicAreaRoleSiteServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/28 13:01
 **/
@Service
public class BasicPublicAreaRoleSiteServiceImpl implements BasicPublicAreaRoleSiteService {

    @Autowired
    private BasicPublicAreaRoleSiteMapper aRSiteMapper;

    @Override
    public int serviceInsertARSInfo(BasicPublicAreaRoleSite record) {
        return aRSiteMapper.insertARSInfo(record);
    }

    @Override
    public int serviceDeleteARS(Integer arId, Integer seId) {
        int delCount = aRSiteMapper.deleteARS(arId, seId);
        if (delCount <= 0) throw new LsException("deleteARS删除失败");
        return delCount;
    }
}

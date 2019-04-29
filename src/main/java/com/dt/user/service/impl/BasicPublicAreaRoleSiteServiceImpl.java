package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicAreaRoleSiteMapper;
import com.dt.user.model.BasePublicModel.BasicPublicAreaRoleSite;
import com.dt.user.service.BasePublicService.BasicPublicAreaRoleSiteService;
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
        return aRSiteMapper.deleteARS(arId, seId);
    }
}

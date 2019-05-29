package com.dt.project.service.impl;

import com.dt.project.mapper.GeneralPurposeMapper;
import com.dt.project.service.GeneralPurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralPurposeServiceImpl implements GeneralPurposeService {
    @Autowired
    private GeneralPurposeMapper generalPurposeMapper;

    @Override
    public int serviceDeleteByGeneral(List ids, String table, String thisId) {
        return generalPurposeMapper.deleteByGeneral(ids, table, thisId);
    }
}

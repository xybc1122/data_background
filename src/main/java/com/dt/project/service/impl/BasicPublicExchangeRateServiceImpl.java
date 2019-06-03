package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.ExchangeRateDto;
import com.dt.project.mapper.basePublicMapper.BasicPublicExchangeRateMapper;
import com.dt.project.model.basePublic.BasicPublicExchangeRate;
import com.dt.project.service.basePublicService.BasicPublicExchangeRateService;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BasicPublicExchangeRateServiceImpl implements BasicPublicExchangeRateService {
    @Autowired
    private SystemLogStatusService logStatusService;
    @Autowired
    private BasicPublicExchangeRateMapper rateMapper;

    @Override
    public List<ExchangeRateDto> getRateInfo(ExchangeRateDto rateDto) {
        return rateMapper.getRateInfo(rateDto);
    }

    @Override
    @Transactional
    public ResponseBase serviceUpRate(BasicPublicExchangeRate rate) {
        int result = rateMapper.upRate(rate);
        //通用更新消息
        return logStatusService.msgCodeUp(result, rate.getSystemLogStatus(), rate.getStatusId());
    }

    @Override
    @Transactional
    public ResponseBase serviceDelRate(Map<String, String> rateMap) {
        int result = rateMapper.delRate(rateMap.get("thisIds"));
        return logStatusService.msgCodeDel(result, rateMap);
    }

    @Override
    public ResponseBase serviceSaveRate(BasicPublicExchangeRate rate) {
        //新增公司数据
        int result = rateMapper.saveRate((BasicPublicExchangeRate) logStatusService.setObjStatusId(rate));
        return JsonUtils.saveMsg(result);
    }
}

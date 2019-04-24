package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ExchangeRateDto;
import com.dt.user.mapper.BasePublicMapper.BasicPublicExchangeRateMapper;
import com.dt.user.model.BasePublicModel.BasicPublicExchangeRate;
import com.dt.user.service.BasePublicService.BasicPublicExchangeRateService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.toos.Constants;
import com.dt.user.utils.JsonUtils;
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

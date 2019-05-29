package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.dto.ExchangeRateDto;
import com.dt.project.model.basePublicModel.BasicPublicExchangeRate;
import com.dt.project.provider.BasicPublicExchangeRateProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicExchangeRateMapper {


    //查询汇率信息
    @SelectProvider(type = BasicPublicExchangeRateProvider.class, method = "findRate")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<ExchangeRateDto> getRateInfo(ExchangeRateDto rateDto);

    /**
     * 更新汇率信息
     */
    @UpdateProvider(type = BasicPublicExchangeRateProvider.class, method = "upRatePro")
    int upRate(BasicPublicExchangeRate rate);

    /**
     * 批量删除数据/更新
     */
    @UpdateProvider(type = BasicPublicExchangeRateProvider.class, method = "delRatePro")
    int delRate(@Param("thisIds") String thisIds);

    /**
     * 新增汇率数据
     */
    @Insert("INSERT INTO `basic_public_exchange_rate`\n" +
            "(`currency_id`,`to_rmb`,`to_usd`,`status_id`)" +
            "VALUES (#{currencyId}, #{toRmb},#{toUsd},\n" +
            "#{statusId});")
    int saveRate(BasicPublicExchangeRate rate);


}

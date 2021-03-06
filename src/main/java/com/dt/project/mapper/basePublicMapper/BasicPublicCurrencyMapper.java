package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.dto.CurrencyDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicCurrencyMapper {
    /**
     * 查询币别所有相关信息
     *
     * @return
     */
    @Select("SELECT\n" +
            "`currency_id`,`number`,`currency_name`,\n" +
            "`currency_short_name_eng`,`currency_symbol`,`status_id`\n" +
            "FROM `basic_public_currency`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<CurrencyDto> findByListCurrency();
}

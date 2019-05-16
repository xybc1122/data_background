package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.dto.CountryDto;
import com.dt.project.provider.BasicPublicCountryProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicCountryMapper {

    /**
     * 查询获得国家信息
     */
    @SelectProvider(type = BasicPublicCountryProvider.class, method = "findCountry")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<CountryDto> findByCountry(CountryDto country);




}

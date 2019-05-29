package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.dto.TaxrateDto;
import com.dt.project.provider.BasicPublicTaxrateProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicDutiesTaxrateMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/13 11:02
 **/
public interface BasicPublicDutiesTaxrateMapper {

    /**
     * 查询关税 税率
     * @return
     */
    @SelectProvider(type = BasicPublicTaxrateProvider.class, method = "findTaxrate")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<TaxrateDto> findByListTaxrate(TaxrateDto taxrateDto);
}

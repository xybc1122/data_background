package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicPublicVatTaxrate;
import com.dt.project.provider.BasicPublicVatSurTaxrateProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicVatTaxrateMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:09
 **/
public interface BasicPublicVatTaxrateMapper {


    /**
     * 查询附加税税率相关信息
     *
     * @return
     */
    @SelectProvider(type = BasicPublicVatSurTaxrateProvider.class, method = "findVatSur")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicVatTaxrate> findByListSurTaxrate(BasicPublicVatTaxrate taxrate);


}

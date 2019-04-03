package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicPublicVatSurTaxrate;
import com.dt.user.provider.BasicPublicVatSurTaxrateProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicVatSurTaxrateMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:09
 **/
public interface BasicPublicVatSurTaxrateMapper {


    /**
     * 查询附加税税率相关信息
     *
     * @return
     */
    @SelectProvider(type = BasicPublicVatSurTaxrateProvider.class, method = "findVatSur")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicVatSurTaxrate> findByListSurTaxrate(BasicPublicVatSurTaxrate taxrate);


}

package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicPurchasePrice;
import com.dt.project.provider.BasicPurchasePriceProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPurchasePriceMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 14:07
 **/
public interface BasicPurchasePriceMapper {

    /**
     * 查询采购价格
     *
     * @return
     */
    @SelectProvider(type = BasicPurchasePriceProvider.class, method = "findPrice")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPurchasePrice> findByListPrice(BasicPurchasePrice price);

}
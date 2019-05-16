package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.dto.ShopDto;
import com.dt.project.model.BasePublicModel.BasicPublicShop;
import com.dt.project.provider.BasicPublicShopProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicShopMapper {

    /**
     * 查询店铺所有相关信息
     *
     * @return
     */
    @Select("SELECT s.`shop_id`,s.`number`,s.`shop_name`," +
            "s.`shop_name_eng`,s.`shop_short_code`,s.`principal`,s.status_id,c.company_name,p.platform_type_name\n" +
            "FROM `basic_public_shop`AS s\n" +
            "LEFT JOIN `basic_public_company`AS c ON c.`company_id`=s.`company_id`" +
            "LEFT JOIN `basic_public_platform_type`AS p ON p.`platform_type_id`=s.`platform_type_id`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<ShopDto> findByListShop();

    /**
     * 通过角色ID查询店铺名字
     *
     * @return
     */
    @SelectProvider(type = BasicPublicShopProvider.class, method = "selectShopInfo")
    List<BasicPublicShop> selectShopInfo(@Param("rId") String rId);



    /**
     * 通过店铺名称查询店铺ID
     *
     * @return
     */
    @Select("SELECT `shop_id` from `basic_public_shop` where shop_name=#{shopName}")
    Integer getSId(@Param("shopName") String shopName);
}

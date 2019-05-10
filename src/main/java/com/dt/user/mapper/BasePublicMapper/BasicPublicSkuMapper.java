package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.dto.SkuDto;
import com.dt.user.model.BasePublicModel.BasicPublicSku;
import com.dt.user.provider.BasicPublicSkuProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicSkuMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 11:09
 **/
public interface BasicPublicSkuMapper {
    /**
     * 查询SKU 信息
     *
     * @return
     */
    @SelectProvider(type = BasicPublicSkuProvider.class, method = "findSku")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<SkuDto> findByListSku(SkuDto skuDto);

    /**
     * 通过店铺ID  站点ID  skuName 查找 skuId
     *
     * @param sId
     * @param siteId
     * @param skuName
     * @return
     */
    @Select("SELECT `sku_id`\n" +
            "FROM `basic_public_sku`\n" +
            "WHERE shop_id=#{sId} AND site_id=#{siteId} AND sku=#{skuName} LIMIT 1")
    Long getSkuId(@Param("sId") Integer sId, @Param("siteId") Integer siteId, @Param("skuName") String skuName);


    /**
     * 通过站点 店铺  id  查找对应的sku
     *
     * @param sId
     * @param siteId
     * @return
     */
    @Select("SELECT `sku_id`,`sku`" +
            "FROM `basic_public_sku`" +
            "WHERE shop_id=#{sId} AND site_id=#{siteId} AND sku LIKE CONCAT('%',#{kuName},'%') ")
    List<BasicPublicSku> getListKu(@Param("sId") Integer sId, @Param("siteId") Integer siteId, @Param("kuName") String kuName);

    /**
     * 通过店铺ID  站点ID  sAsin 查找 skuId
     *
     * @param sId
     * @param siteId
     * @return
     */
    @Select("SELECT `sku_id`\n" +
            "FROM `basic_public_sku`\n" +
            "WHERE shop_id=#{sId} AND site_id=#{siteId} AND s_asin=#{sAsin} LIMIT 1")
    Long getAsinSkuId(@Param("sId") Integer sId, @Param("siteId") Integer siteId, @Param("sAsin") String sAsin);

    /**
     * 查询所有sku
     *
     * @return
     */
    @Select(" SELECT\n" +
            "`sku_id`,\n" +
            "`sku`\n" +
            "FROM `basic_public_sku`")
    List<BasicPublicSku> selAllSku();


}

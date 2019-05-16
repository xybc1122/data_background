package com.dt.project.provider;

import com.dt.project.dto.SkuDto;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPublicSkuProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 11:14
 **/
public class BasicPublicSkuProvider {


    public String findSku(SkuDto skuDto) {
        SQL sql = new SQL();
        String Alias = "ku";
        sql.SELECT(" ku.`sku_id`,ku.`sku`,ku.`fnsku`,\n" +
                "  ku.`s_asin`,ku.`product_id`,ku.`status_id`,\n" +
                "  sp.`shop_name`,si.`site_name`,cl.`class_name`,pr.`product_name`\n" +
                "FROM `basic_public_sku` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS sp ON sp.`shop_id`=ku.`shop_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site`AS si ON si.`site_id`=ku.`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_sales_amazon_handling_class` AS cl ON cl.`class_id`=ku.`class_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_product` AS pr ON pr.`product_id`=ku.`product_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(skuDto.getSystemLogStatus(), Alias, sql);
        //站点名称
        if (StringUtils.isNotBlank(skuDto.getSiteName())) {
            sql.WHERE("si.`site_name`=#{siteName}");
        }
        //国家名称
        if (StringUtils.isNotBlank(skuDto.getShopName())) {
            sql.WHERE("sp.`shop_name`=#{shopName}");
        }
        //订单处理名称
        if (StringUtils.isNotBlank(skuDto.getClassName())) {
            sql.WHERE("cl.`class_name`=#{className}");
        }
        //产品名称
        if (StringUtils.isNotBlank(skuDto.getProductName())) {
            sql.WHERE("pr.`product_name`=#{productName}");
        }
        //sku
        if (StringUtils.isNotBlank(skuDto.getSku())) {
            sql.WHERE(Alias + ".`sku`=#{sku}");
        }
        //fnsku
        if (StringUtils.isNotBlank(skuDto.getFnsku())) {
            sql.WHERE(Alias + ".`fnsku`=#{fnsku}");
        }
        //s_asin 子ASIN
        if (StringUtils.isNotBlank(skuDto.getsAsin())) {
            sql.WHERE(Alias + ".`s_asin`=#{sAsin}");
        }
        return sql.toString();

    }
}

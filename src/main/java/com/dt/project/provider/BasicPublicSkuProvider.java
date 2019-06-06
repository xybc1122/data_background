package com.dt.project.provider;

import com.dt.project.model.dto.SkuDto;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
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
        String alias = "ku";
        sql.SELECT(" ku.`sku_id`,ku.`sku`,ku.`fn_sku`,\n" +
                "  ku.`s_asin`,ku.`product_id`,ku.`status_id`,\n" +
                "  sp.`shop_name`,si.`site_name`,cl.`class_name`,pr.`product_name`\n" +
                "FROM `basic_public_sku` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS sp ON sp.`shop_id`=ku.`shop_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site`AS si ON si.`site_id`=ku.`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_sales_amazon_handling_class` AS cl ON cl.`class_id`=ku.`class_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_product` AS pr ON pr.`product_id`=ku.`product_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(skuDto.getSystemLogStatus(), alias, sql);
        //站点名称
        if (StringUtils.isNotBlank(skuDto.getSiteName())) {
            AppendSqlStore.sqlWhere(skuDto.getSiteName(), "si.`site_name`", sql, Constants.SELECT,alias);
        }
        //国家名称
        if (StringUtils.isNotBlank(skuDto.getShopName())) {
            AppendSqlStore.sqlWhere(skuDto.getShopName(), "sp.`shop_name`", sql, Constants.SELECT,alias);
        }
        //订单处理名称
        if (StringUtils.isNotBlank(skuDto.getClassName())) {
            AppendSqlStore.sqlWhere(skuDto.getClassName(), "cl.`class_name`", sql, Constants.SELECT,alias);
        }
        //产品名称
        if (StringUtils.isNotBlank(skuDto.getProductName())) {
            AppendSqlStore.sqlWhere(skuDto.getProductName(), "pr.`product_name`", sql, Constants.SELECT,alias);
        }
        //sku
        if (StringUtils.isNotBlank(skuDto.getSku())) {
            AppendSqlStore.sqlWhere(skuDto.getSku(), alias + ".`sku` ", sql, Constants.SELECT,alias);
        }
        //fnSku
        if (StringUtils.isNotBlank(skuDto.getFnSku())) {
            AppendSqlStore.sqlWhere(skuDto.getFnSku(), alias + ".`fn_sku`", sql, Constants.SELECT,alias);
        }
        //s_asin 子ASIN
        if (StringUtils.isNotBlank(skuDto.getsAsin())) {
            AppendSqlStore.sqlWhere(skuDto.getsAsin(), alias + ".`s_asin`", sql, Constants.SELECT,alias);
        }
        ProviderSqlStore.del(alias, sql);
        return sql.toString();

    }
}

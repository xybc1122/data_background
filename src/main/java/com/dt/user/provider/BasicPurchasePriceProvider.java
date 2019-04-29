package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicPurchasePrice;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPurchasePriceProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 14:08
 **/
public class BasicPurchasePriceProvider {


    public String findPrice(BasicPurchasePrice price) {
        SQL sql = new SQL();
        String Alias = "ep";
        sql.SELECT("ep.`purchase_price_id`,\n" +
                "ep.`not_tax_price`,p.`product_name`,\n" +
                "ep.`tax_price`,ep.`status_id`\n" +
                "FROM `basic_purchase_price` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_product` as p on p.`products_id`= " + Alias + ".`product_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(price.getSystemLogStatus(), Alias, sql);
        //不含税价格
        if (price.getNotTaxPrice() != null) {
            sql.WHERE(Alias + ".not_tax_price=#{notTaxPrice}");
        }
        //含税价格
        if (price.getTaxPrice() != null) {
            sql.WHERE(Alias + ".tax_price=#{taxPrice}");
        }
        //产品名称
        if (StringUtils.isNotBlank(price.getProductName())) {
            sql.WHERE("p.`product_name`=#{productName}");
        }
        return sql.toString();
    }
}

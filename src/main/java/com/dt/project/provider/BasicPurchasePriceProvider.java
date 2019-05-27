package com.dt.project.provider;

import com.dt.project.model.basePublicModel.BasicPurchasePrice;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
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
        String alias = "ep";
        sql.SELECT("ep.`purchase_price_id`,\n" +
                "ep.`not_tax_price`,p.`product_name`,\n" +
                "ep.`tax_price`,ep.`status_id`\n" +
                "FROM `basic_purchase_price` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_product` as p on p.`products_id`= " + alias + ".`product_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(price.getSystemLogStatus(), alias, sql);
        //不含税价格
        AppendSqlStore.sqlWhere(price.getNotTaxPrice(), alias + ".not_tax_price", sql, Constants.SELECT);
        //含税价格
        AppendSqlStore.sqlWhere(price.getTaxPrice(), alias + ".tax_price", sql, Constants.SELECT);
        //产品名称
        AppendSqlStore.sqlWhere(price.getProductName(), "p.`product_name`", sql, Constants.SELECT);
        return sql.toString();
    }
}

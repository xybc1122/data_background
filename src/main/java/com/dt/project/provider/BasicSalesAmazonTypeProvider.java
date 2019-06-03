package com.dt.project.provider;

import com.dt.project.model.basePublic.BasicSalesAmazonType;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicSalesAmazonTypeProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 10:47
 **/
public class BasicSalesAmazonTypeProvider {


    public String findAmazonType(BasicSalesAmazonType amazonType) {
        SQL sql = new SQL();
        String alias = "t";
        sql.SELECT(" t.`order_type_id`,t.`order_type_name`,t.`order_type`," +
                "t.`status_id`,si.`site_name`\n" +
                "FROM `basic_sales_amazon_type` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS si ON si.`site_id`=" + alias + ".`site_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(amazonType.getSystemLogStatus(), alias, sql);
        //站点名称
        AppendSqlStore.sqlWhere(amazonType.getSiteName(), "si.site_name", sql, Constants.SELECT);
        //订单类型名称
        AppendSqlStore.sqlWhere(amazonType.getOrderTypeName(), alias + ".order_type_name", sql, Constants.SELECT);
        //order_type
        AppendSqlStore.sqlWhere(amazonType.getOrderType(), alias + ".order_type", sql, Constants.SELECT);
        return sql.toString();
    }


}

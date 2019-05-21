package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonDescription;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicSalesAmazonDescriptionProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:50
 **/
public class BasicSalesAmazonDescriptionProvider {

    public String getDescription(BasicSalesAmazonDescription description) {
        SQL sql = new SQL();
        String alias = "de";
        sql.SELECT(" de.`order_description_id`,\n" +
                "de.`order_description_name`,\n" +
                "de.`old_order_description`,\n" +
                "de.`new_order_description`,de.status_id,\n" +
                "s.`site_name`\n" +
                "FROM `basic_sales_amazon_description` AS " + alias + " ");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS s ON s.`site_id`=de.`site_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(description.getSystemLogStatus(), alias, sql);

        //站点名称
        AppendSqlStore.sqlWhere(description.getSiteName(), "s.site_name", sql, Constants.SELECT);
        //订单描述名称
        AppendSqlStore.sqlWhere(description.getOrderDescriptionName(), alias + ".order_description_name", sql, Constants.SELECT);
        //原订单描述
        AppendSqlStore.sqlWhere(description.getOldOrderDescription(), alias + ".old_order_description", sql, Constants.SELECT);
        //新订单描述
        AppendSqlStore.sqlWhere(description.getNewOrderDescription(), alias + ".new_order_description", sql, Constants.SELECT);
        return sql.toString();
    }
}

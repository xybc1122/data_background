package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonDescription;
import com.dt.project.store.ProviderSqlStore;
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
        String Alias = "de";
        sql.SELECT(" de.`order_description_id`,\n" +
                "de.`order_description_name`,\n" +
                "de.`old_order_description`,\n" +
                "de.`new_order_description`,de.status_id,\n" +
                "s.`site_name`\n" +
                "FROM `basic_sales_amazon_description` AS " + Alias + " ");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS s ON s.`site_id`=de.`site_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(description.getSystemLogStatus(), Alias, sql);

        //站点名称
        if (StringUtils.isNotBlank(description.getSiteName())) {
            sql.WHERE("s.site_name=#{siteName}");
        }
        //订单描述名称
        if (StringUtils.isNotBlank(description.getOrderDescriptionName())) {
            sql.WHERE(Alias + ".order_description_name=#{orderDescriptionName}");
        }
        //原订单描述
        if (StringUtils.isNotBlank(description.getOldOrderDescription())) {
            sql.WHERE(Alias + ".old_order_description=#{oldOrderDescription}");
        }
        //新订单描述
        if (StringUtils.isNotBlank(description.getNewOrderDescription())) {
            sql.WHERE(Alias + ".new_order_description=#{newOrderDescription}");
        }
        return sql.toString();
    }
}

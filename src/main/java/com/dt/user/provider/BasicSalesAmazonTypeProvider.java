package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonType;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        String Alias = "t";
        sql.SELECT(" t.`order_type_id`,t.`order_type_name`,t.`order_type`," +
                "t.`status_id`,si.`site_name`\n" +
                "FROM `basic_sales_amazon_type` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS si ON si.`site_id`=" + Alias + ".`site_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(amazonType.getSystemLogStatus(), Alias, sql);
        //站点名称
        if (StringUtils.isNotBlank(amazonType.getSiteName())) {
            sql.WHERE("si.site_name=#{siteName}");
        }
        //订单类型名称
        if (StringUtils.isNotBlank(amazonType.getOrderTypeName())) {
            sql.WHERE(Alias + ".order_type_name=#{orderTypeName}");
        }
        //order_type
        if (StringUtils.isNotBlank(amazonType.getOrderType())) {
            sql.WHERE(Alias + ".order_type=#{orderType}");
        }
        return sql.toString();
    }


}

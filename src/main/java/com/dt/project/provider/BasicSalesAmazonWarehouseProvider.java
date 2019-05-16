package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonWarehouse;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicSalesAmazonWarehouseProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 11:15
 **/
public class BasicSalesAmazonWarehouseProvider {

    public String findAmazonWarehouse(BasicSalesAmazonWarehouse amazonWarehouse) {
        SQL sql = new SQL();
        String Alias = "w";
        sql.SELECT("w.`amazon_warehouse_id`,w.`number`,si.`site_name`,w.`warehouse_code`,w.`country`,\n" +
                "  w.`address`,w.`city`, w.`state`,w.`zip`, w.`status_id`\n" +
                "FROM `basic_sales_amazon_warehouse` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS si ON si.`site_id`=" + Alias + ".`site_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(amazonWarehouse.getSystemLogStatus(), Alias, sql);
        //站点名称
        AppendSqlStore.sqlWhere(amazonWarehouse.getSiteName(), "si.site_name", sql, Constants.SELECT);
        //FBA仓库编号
        if (amazonWarehouse.getNumber() != null) {
            sql.WHERE(Alias + ".number=#{number}");
        }
        //FBA仓库代码
        AppendSqlStore.sqlWhere(amazonWarehouse.getWarehouseCode(), "w.warehouse_code", sql, Constants.SELECT);
        //国家
        AppendSqlStore.sqlWhere(amazonWarehouse.getCountry(), "w.country", sql, Constants.SELECT);
        //地址
        AppendSqlStore.sqlWhere(amazonWarehouse.getAddress(), "w.address", sql, Constants.SELECT);

        //城市
        AppendSqlStore.sqlWhere(amazonWarehouse.getCity(), "w.city", sql, Constants.SELECT);

        //州省
        AppendSqlStore.sqlWhere(amazonWarehouse.getState(), "w.state", sql, Constants.SELECT);
        //邮编
        AppendSqlStore.sqlWhere(amazonWarehouse.getZip(), "w.zip", sql, Constants.SELECT);
        return sql.toString();
    }

}

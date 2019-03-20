package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonWarehouse;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        ProviderSqlStore.saveStatus(amazonWarehouse.getSystemLogStatus(), Alias, sql);
        //站点名称
        if (StringUtils.isNotBlank(amazonWarehouse.getSiteName())) {
            sql.WHERE("si.site_name=#{siteName}");
        }
        //FBA仓库编号
        if (amazonWarehouse.getNumber() != null) {
            sql.WHERE(Alias + ".number=#{number}");
        }
        //FBA仓库代码
        if (StringUtils.isNotBlank(amazonWarehouse.getWarehouseCode())) {
            sql.WHERE(Alias + ".warehouse_code=#{warehouseCode}");
        }
        //国家
        if (StringUtils.isNotBlank(amazonWarehouse.getCountry())) {
            sql.WHERE(Alias + ".country=#{country}");
        }
        //地址
        if (StringUtils.isNotBlank(amazonWarehouse.getAddress())) {
            sql.WHERE(Alias + ".address=#{address}");
        }
        //城市
        if (StringUtils.isNotBlank(amazonWarehouse.getCity())) {
            sql.WHERE(Alias + ".city=#{city}");
        }
        //州省
        if (StringUtils.isNotBlank(amazonWarehouse.getState())) {
            sql.WHERE(Alias + ".state=#{state}");
        }
        //邮编
        if (StringUtils.isNotBlank(amazonWarehouse.getZip())) {
            sql.WHERE(Alias + ".zip=#{zip}");
        }
        return sql.toString();
    }

}

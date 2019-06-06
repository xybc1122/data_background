package com.dt.project.provider;

import com.dt.project.model.dto.TaxrateDto;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPublicTaxrateProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/13 14:45
 **/
public class BasicPublicTaxrateProvider {

    public String findTaxrate(TaxrateDto taxrateDto) {
        SQL sql = new SQL();
        String alias = "st";
        sql.SELECT("st.`duties_taxrate_id`,st.status_id,st.`tax_rate`," +
                "c.`country_name`,p.`products_name`\n" +
                "FROM `basic_public_duties_taxrate` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS c ON c.`country_id`=st.`country_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_products` AS p ON p.`products_id`=st.`products_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(taxrateDto.getSystemLogStatus(), alias, sql);
        //国家名称
        AppendSqlStore.sqlWhere(taxrateDto.getCountryName(), "c.country_name", sql, Constants.SELECT,alias);
        //税率
        AppendSqlStore.sqlWhere(taxrateDto.getTaxRate(), alias+".tax_rate", sql, Constants.SELECT,alias);
        //产品类目
        AppendSqlStore.sqlWhere(taxrateDto.getProductsName(), "p.products_name", sql, Constants.SELECT,alias);
        return sql.toString();
    }

}

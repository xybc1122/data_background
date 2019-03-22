package com.dt.user.provider;

import com.dt.user.dto.TaxrateDto;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        String Alias = "st";
        sql.SELECT("st.`duties_taxrate_id`,st.status_id,st.`tax_rate`," +
                "c.`country_name`,p.`products_name`\n" +
                "FROM `basic_public_duties_taxrate` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS c ON c.`country_id`=st.`country_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_products` AS p ON p.`products_id`=st.`products_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(taxrateDto.getSystemLogStatus(), Alias, sql);
        //国家名称
        if (StringUtils.isNotBlank(taxrateDto.getCountryName())) {
            sql.WHERE("c.country_name=#{countryName}");
        }
        //税率
        if (taxrateDto.getTaxRate() != null) {
            sql.WHERE(Alias+".tax_rate=#{taxRate}");
        }
        //产品类目
        if (StringUtils.isNotBlank(taxrateDto.getProductsName())) {
            sql.WHERE("p.products_name=#{productsName}");
        }
        return sql.toString();
    }

}

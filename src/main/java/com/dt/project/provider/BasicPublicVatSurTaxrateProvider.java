package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicPublicVatTaxrate;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPublicVatSurTaxrateProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:39
 **/
public class BasicPublicVatSurTaxrateProvider {

    public String findVatSur(BasicPublicVatTaxrate vatSurTaxrate) {
        SQL sql = new SQL();
        String Alias = "rt";
        sql.SELECT("rt.`taxrate_id`,rt.`company_id`,rt.`country_id`,rt.`tax_rate`,\n" +
                "rt.`status_id`,cou.`country_name`,com.`company_name`\n" +
                "FROM `basic_public_vat_taxrate` AS " + Alias + "\n");
        //国家
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS cou ON cou.`country_id`=" + Alias + ".`country_id`");
        //公司
        sql.LEFT_OUTER_JOIN("`basic_public_company` AS com ON com.`company_id`=" + Alias + ".`company_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(vatSurTaxrate.getSystemLogStatus(), Alias, sql);
        //公司名
        if (vatSurTaxrate.getCompanyId() != null) {
            sql.WHERE("com.company_name=#{companyName}");
        }
        //国家名
        if (vatSurTaxrate.getCountryId() != null) {
            sql.WHERE("cou.country_name=#{countryName}");
        }
        //税率
        if (vatSurTaxrate.getTaxRate() != null) {
            sql.WHERE(Alias + ".tax_rate=#{taxRate}");
        }
        return sql.toString();

    }


}

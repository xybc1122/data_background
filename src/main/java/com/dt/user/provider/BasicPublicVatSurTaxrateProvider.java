package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicPublicVatSurTaxrate;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPublicVatSurTaxrateProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:39
 **/
public class BasicPublicVatSurTaxrateProvider {

    public String findVatSur(BasicPublicVatSurTaxrate vatSurTaxrate) {
        SQL sql = new SQL();
        String Alias = "rt";
        sql.SELECT("rt.`taxrate_id`,rt.`tax_rate`,\n" +
                "rt.`effective_date`,rt.`status_id`,rt.tax_type,c.`country_name`\n" +
                "FROM `basic_public_vat_sur_taxrate` AS " + Alias + "\n");
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS c ON c.`country_id`=" + Alias + ".`country_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(vatSurTaxrate.getSystemLogStatus(), Alias, sql);

        //国家名称
        if (StringUtils.isNotBlank(vatSurTaxrate.getCountryName())) {
            sql.WHERE("c.`country_name`=#{countryName}");
        }
        //税率
        if (vatSurTaxrate.getTaxRate() != null) {
            sql.WHERE(Alias + ".tax_rate=#{taxRate}");
        }
        //生效日期
        if (vatSurTaxrate.getEffectiveDate() != null) {
            sql.WHERE(Alias + ".effective_date=#{effectiveDate}");
        }
        //税种
        if (vatSurTaxrate.getTaxType() != null) {
            sql.WHERE(Alias + ".tax_type=#{taxType}");
        }
        return sql.toString();

    }


}

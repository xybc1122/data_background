package com.dt.project.provider;

import com.dt.project.model.basePublicModel.BasicPublicVatTaxrate;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPublicVatSurTaxrateProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:39
 **/
public class BasicPublicVatSurTaxrateProvider {

    public String findVatSur(BasicPublicVatTaxrate vat) {
        SQL sql = new SQL();
        String alias = "rt";
        sql.SELECT("rt.`taxrate_id`,rt.`company_id`,rt.`country_id`,rt.`tax_rate`,\n" +
                "rt.`status_id`,cou.`country_name`,com.`company_name`\n" +
                "FROM `basic_public_vat_taxrate` AS " + alias + "\n");
        //国家
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS cou ON cou.`country_id`=" + alias + ".`country_id`");
        //公司
        sql.LEFT_OUTER_JOIN("`basic_public_company` AS com ON com.`company_id`=" + alias + ".`company_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(vat.getSystemLogStatus(), alias, sql);
        //公司名
        AppendSqlStore.sqlWhere(vat.getCompanyName(), "com.`company_name`", sql, Constants.SELECT);
        //国家名
        AppendSqlStore.sqlWhere(vat.getCountryName(), "cou.country_name", sql, Constants.SELECT);
        //税率
        AppendSqlStore.sqlWhere(vat.getTaxRate(), alias + ".tax_rate", sql, Constants.SELECT);
        return sql.toString();

    }


}

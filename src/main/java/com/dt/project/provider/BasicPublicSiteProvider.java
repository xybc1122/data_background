package com.dt.project.provider;

import com.dt.project.dto.SiteDto;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicSiteProvider {

    public String findSite(SiteDto siteDto) {
        SQL sql = new SQL();
        String alias = "s";
        sql.SELECT("s.`site_id`,s.`number`,s.`site_name`,s.`site_name_eng`,s.`site_short_name_eng`,s.`url`,s.`vat`," +
                "s.`principal`,s.status_id, c.`country_name`, cu.currency_name,cu.currency_short_name_eng,a.`area_name`," +
                "GROUP_CONCAT(e.employee_name) as employee_name FROM `basic_public_site` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS c ON c.`country_id`=s.`country_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_area` AS a ON a.`area_id`=s.`area_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS e ON e.`dept_id`=s.`principal`");
        sql.LEFT_OUTER_JOIN("`basic_public_currency` AS cu ON cu.`currency_id`=s.country_id");
        //状态数据查询
        ProviderSqlStore.selectStatus(siteDto.getSystemLogStatus(), alias, sql);
        //站点编号
        AppendSqlStore.sqlWhere(siteDto.getNumber(), alias + ".number", sql, Constants.SELECT);
        //站点名称
        AppendSqlStore.sqlWhere(siteDto.getSiteName(), alias + ".site_name", sql, Constants.SELECT);
        //站点英文名称
        AppendSqlStore.sqlWhere(siteDto.getSiteNameEng(), alias + ".site_name_eng", sql, Constants.SELECT);
        //站点英文简称
        AppendSqlStore.sqlWhere(siteDto.getSiteShortNameEng(), alias + ".site_short_name_eng", sql, Constants.SELECT);
        //URL
        AppendSqlStore.sqlWhere(siteDto.getUrl(), alias + ".url", sql, Constants.SELECT);
        //VAT税率
        AppendSqlStore.sqlWhere(siteDto.getVat(), alias + ".vat", sql, Constants.SELECT);
        //币别英文名称
        AppendSqlStore.sqlWhere(siteDto.getCurrencyShortNameEng(), "cu.currency_short_name_eng", sql, Constants.SELECT);
        //币别名称
        AppendSqlStore.sqlWhere(siteDto.getCurrencyName(), "cu.currency_name", sql, Constants.SELECT);
        //区域名称
        AppendSqlStore.sqlWhere(siteDto.getAreaName(), "a.`area_name`", sql, Constants.SELECT);
        //国家名称
        AppendSqlStore.sqlWhere(siteDto.getCountryName(), "c.`country_name`", sql, Constants.SELECT);
        //负责人
        AppendSqlStore.sqlWhere(siteDto.getEmployeeName(), "e.`employee_name`", sql, Constants.SELECT);
        sql.GROUP_BY("s.`site_id`");
        return sql.toString();
    }

    public String selSiteRole() {
        SQL sql = new SQL();
        sql.SELECT("se.`site_id`,se.`site_name`\n" +
                "FROM `basic_public_site` AS se," + ProviderSqlStore.siteJoinTable(sql, "se") + "");
        return sql.toString();
    }


    public String selectSiteInfo(Map<String, Object> seMap) {
        SQL sql = new SQL();
        String arIds = (String) seMap.get("arIds");
        sql.SELECT("se.`site_id`,se.`site_name`,se.site_short_name_eng \n" +
                "FROM `basic_public_site` AS se");
        sql.LEFT_OUTER_JOIN("`basic_public_area_role_site` AS ars ON ars.`se_id` = se.`site_id`");
        return sql.toString() + " WHERE " + StrUtils.in(arIds, "ars.`ar_id`") + " GROUP BY se.`site_name`";
    }

    public String getSId(Map<String, String> sMap) {
        String country = sMap.get("country");
        String sName = sMap.get("sName");
        return new SQL() {{
            SELECT("`site_id`");
            FROM("`basic_public_site`");
            if (StringUtils.isNotBlank(country)) {
                WHERE("site_short_name_eng=" + "'" + country + "'");
            }
            if (StringUtils.isNotBlank(sName)) {
                WHERE("site_name=" + "'" + sName + "'");
            }
        }}.toString();
    }
}

package com.dt.project.provider;

import com.dt.project.dto.SiteDto;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicSiteProvider {

    public String findSite(SiteDto siteDto) {
        SQL sql = new SQL();
        String Alias = "s";
        sql.SELECT("s.`site_id`,s.`number`,s.`site_name`,s.`site_name_eng`,s.`site_short_name_eng`,s.`url`,s.`vat`," +
                "s.`principal`,s.status_id, c.`country_name`, cu.currency_name,cu.currency_short_name_eng,a.`area_name`," +
                "GROUP_CONCAT(e.employee_name) as employee_name FROM `basic_public_site` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS c ON c.`country_id`=s.`country_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_area` AS a ON a.`area_id`=s.`area_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS e ON e.`dept_id`=s.`principal`");
        sql.LEFT_OUTER_JOIN("`basic_public_currency` AS cu ON cu.`currency_id`=s.country_id");
        //状态数据查询
        ProviderSqlStore.selectStatus(siteDto.getSystemLogStatus(), Alias, sql);
        //站点编号
        if (siteDto.getNumber() != null) {
            sql.WHERE(Alias + ".number=#{number}");
        }
        //站点名称
        if (StringUtils.isNotBlank(siteDto.getSiteName())) {
            sql.WHERE(Alias + ".site_name=#{siteName}");
        }
        //站点英文名称
        if (StringUtils.isNotBlank(siteDto.getSiteNameEng())) {
            sql.WHERE(Alias + ".site_name_eng=#{siteNameEng}");
        }
        //站点英文简称
        if (StringUtils.isNotBlank(siteDto.getSiteShortNameEng())) {
            sql.WHERE(Alias + ".site_short_name_eng=#{siteShortNameEng}");
        }
        //URL
        if (StringUtils.isNotBlank(siteDto.getUrl())) {
            sql.WHERE(Alias + ".url=#{url}");
        }
        //VAT税率
        if (siteDto.getVat() != null) {
            sql.WHERE(Alias + ".vat=#{vat}");
        }
        //币别英文名称
        if (StringUtils.isNotBlank(siteDto.getCurrencyShortNameEng())) {
            sql.WHERE("cu.currency_short_name_eng=#{currencyShortNameEng}");
        }
        //币别名称
        if (StringUtils.isNotBlank(siteDto.getCurrencyName())) {
            sql.WHERE("cu.currency_name=#{currencyName}");
        }
        //区域名称
        if (StringUtils.isNotBlank(siteDto.getAreaName())) {
            sql.WHERE("a.`area_name`=#{areaName}");
        }
        //国家名称
        if (StringUtils.isNotBlank(siteDto.getCountryName())) {
            sql.WHERE("c.`country_name`=#{countryName}");
        }
        //负责人
        if (StringUtils.isNotBlank(siteDto.getEmployeeName())) {
            sql.WHERE("e.`employee_name`=#{employeeName}");
        }
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
        Integer arId = (Integer) seMap.get("arId");
        sql.SELECT("se.`site_id`,se.`site_name`,se.site_short_name_eng \n" +
                "FROM `basic_public_site` AS se");
        sql.LEFT_OUTER_JOIN("`basic_public_area_role_site` AS ars ON ars.`se_id` = se.`site_id`");
        sql.WHERE("ars.`ar_id`=" + arId);
        return sql.toString();
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

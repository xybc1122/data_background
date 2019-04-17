package com.dt.user.provider;

import com.dt.user.dto.SiteDto;
import com.dt.user.store.ProviderSqlStore;
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
        ProviderSqlStore.saveStatus(siteDto.getSystemLogStatus(), Alias, sql);
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
        sql.GROUP_BY(Alias + ".`site_id`");
        return sql.toString();
    }

    public String getSiteId(Map<String, Object> sMap) {
        sMap.get("siteMap");
        return new SQL() {{
            SELECT("site_id");
            FROM("`basic_public_site`");
            if (StringUtils.isNotBlank(sMap.get("url").toString())) {
                WHERE("url=" + "'" + sMap.get("url").toString() + "'");
            }
            if (StringUtils.isNotBlank(sMap.get("country").toString())) {
                WHERE("site_name_eng=" + "'" + sMap.get("country").toString() + "'");
            }
        }}.toString();


    }

}

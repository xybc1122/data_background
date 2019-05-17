package com.dt.project.provider;

import com.dt.project.dto.CountryDto;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class BasicPublicCountryProvider {


    public String findCountry(CountryDto countryDto) {
        SQL sql = new SQL();
        String alias = "c";
        sql.SELECT("c.country_id,c.number,c.country_name,c.country_name_eng,c.status_id," +
                "c.country_short_name_eng,p.province_name," +
                "pc.city_name,pcc.`county_name`,l.language_name FROM `basic_public_country` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_province` AS p ON p.`country_id`=c.`country_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_province_city`AS pc ON pc.city_number=p.number");
        sql.LEFT_OUTER_JOIN("`basic_public_province_city_county`AS pcc ON pcc.city_number=pc.`city_number`");
        sql.LEFT_OUTER_JOIN("`basic_public_language`AS l ON l.language_id=c.`language_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(countryDto.getSystemLogStatus(), alias, sql);
        //国家名称
        AppendSqlStore.sqlWhere(countryDto.getCountryName(), alias + ".country_name", sql, Constants.SELECT);
        //国家编号
        AppendSqlStore.sqlWhere(countryDto.getNumber(), alias + ".number", sql, Constants.SELECT);
        //国家英文
        AppendSqlStore.sqlWhere(countryDto.getCountryNameEng(), alias + ".country_name_eng", sql, Constants.SELECT);
        //国家英文简写
        AppendSqlStore.sqlWhere(countryDto.getCountryShortNameEng(), alias + ".country_short_name_eng", sql, Constants.SELECT);
        //洲名字
        AppendSqlStore.sqlWhere(countryDto.getProvinceName(), "p.province_name", sql, Constants.SELECT);
        //市名字
        AppendSqlStore.sqlWhere(countryDto.getCityName(), "pc.city_name", sql, Constants.SELECT);
        //县名字
        AppendSqlStore.sqlWhere(countryDto.getCountyName(), "pcc.`county_name`", sql, Constants.SELECT);
        //语言
        AppendSqlStore.sqlWhere(countryDto.getLanguageName(), "l.`language_name`", sql, Constants.SELECT);
        ProviderSqlStore.del(alias, sql);
        return sql.toString();
    }

}

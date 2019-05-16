package com.dt.project.provider;

import com.dt.project.dto.CountryDto;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class BasicPublicCountryProvider {


    public String findCountry(CountryDto countryDto) {
        SQL sql = new SQL();
        String Alias = "c";
        sql.SELECT("c.country_id,c.number,c.country_name,c.country_name_eng,c.status_id," +
                "c.country_short_name_eng,p.province_name," +
                "pc.city_name,pcc.`county_name`,l.language_name FROM `basic_public_country` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_province` AS p ON p.`country_id`=c.`country_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_province_city`AS pc ON pc.city_number=p.number");
        sql.LEFT_OUTER_JOIN("`basic_public_province_city_county`AS pcc ON pcc.city_number=pc.`city_number`");
        sql.LEFT_OUTER_JOIN("`basic_public_language`AS l ON l.language_id=c.`language_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(countryDto.getSystemLogStatus(), Alias, sql);
        //国家名称
        if (StringUtils.isNotBlank(countryDto.getCountryName())) {
            sql.WHERE(Alias + ".country_name=#{countryName}");
        }
        //国家编号
        if (countryDto.getNumber() != null) {
            sql.WHERE(Alias + ".number=#{number}");
        }
        //国家英文
        if (StringUtils.isNotBlank(countryDto.getCountryNameEng())) {
            sql.WHERE(Alias + ".country_name_eng=#{countryNameEng}");
        }
        //国家英文简写
        if (StringUtils.isNotBlank(countryDto.getCountryShortNameEng())) {
            sql.WHERE(Alias + ".country_short_name_eng=#{countryShortNameEng}");
        }
        //洲名字
        if (StringUtils.isNotBlank(countryDto.getProvinceName())) {
            sql.WHERE("p.province_name=#{provinceName}");
        }
        //市名字
        if (StringUtils.isNotBlank(countryDto.getCityName())) {
            sql.WHERE("pc.city_name=#{cityName}");
        }
        //县名字
        if (StringUtils.isNotBlank(countryDto.getCountyName())) {
            sql.WHERE("pcc.`county_name`=#{countyName}");
        }
        //语言
        if (StringUtils.isNotBlank(countryDto.getLanguageName())) {
            sql.WHERE("l.`language_name`=#{languageName}");
        }
        sql.WHERE("c.del_or_not=0");
        return sql.toString();
    }

}

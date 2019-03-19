package com.dt.user.provider;

import com.dt.user.dto.ExchangeRateDto;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class BasicPublicExchangeRateProvider {

    public String findRate(ExchangeRateDto rateDto) {
        SQL sql = new SQL();
        String Alias = "r";
        sql.SELECT("r.exchange_rate_id, c.currency_name,\n" +
                "r.`to_rmb`,r.`to_usd`,r.`effective_date`,r.status_id\n" +
                "FROM `basic_public_exchange_rate` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_currency` AS c ON c.currency_id=r.`currency_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(rateDto.getSystemLogStatus(), Alias, sql);
        //币别名称
        if (StringUtils.isNotBlank(rateDto.getCurrencyName())) {
            sql.WHERE("c.currency_name=#{currencyName}");
        }
        //兑人民币汇率
        if (rateDto.getToRmb() != null) {
            sql.WHERE(Alias + ".to_rmb=#{toRmb}");
        }
        //兑美元汇率
        if (rateDto.getToUsd() != null) {
            sql.WHERE(Alias + ".to_usd=#{toUsd}");
        }
        //有效日期
        if (rateDto.getEffectiveDate() != null) {
            sql.WHERE(Alias + ".effective_date=#{effectiveDate}");
        }
        return sql.toString();
    }

}

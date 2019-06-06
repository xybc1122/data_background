package com.dt.project.provider;

import com.dt.project.model.dto.ExchangeRateDto;
import com.dt.project.model.basePublic.BasicPublicExchangeRate;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicExchangeRateProvider {

    public String findRate(ExchangeRateDto rateDto) {
        SQL sql = new SQL();
        String alias = "r";
        sql.SELECT("c.currency_symbol,r.exchange_rate_id, c.currency_name,\n" +
                "r.`to_rmb`,r.`to_usd`,r.e_date,r.status_id,r.version\n" +
                "FROM `basic_public_exchange_rate` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_currency` AS c ON c.currency_id=r.`currency_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(rateDto.getSystemLogStatus(), alias, sql);
        //币别名称
        AppendSqlStore.sqlWhere(rateDto.getCurrencyName(), "c.currency_name", sql, Constants.SELECT,alias);
        //币别符号
        AppendSqlStore.sqlWhere(rateDto.getCurrencySymbol(), "c.currency_symbol", sql, Constants.SELECT,alias);
        //兑人民币汇率
        AppendSqlStore.sqlWhere(rateDto.getToRmb(), alias + ".to_rmb", sql, Constants.SELECT,alias);
        //兑美元汇率
        AppendSqlStore.sqlWhere(rateDto.getToUsd(), alias + ".to_usd", sql, Constants.SELECT,alias);
        //有效日期
        if (rateDto.geteDates() != null && (rateDto.geteDates().size() > 0)) {
            sql.WHERE(alias + ".e_date BETWEEN  " + rateDto.geteDates().get(0) + " AND " + rateDto.geteDates().get(1) + "");
        }
        //删除
        ProviderSqlStore.del(alias, sql);
        return sql.toString();
    }

    public String upRatePro(BasicPublicExchangeRate rate) {
        SQL sql = new SQL();
        sql.UPDATE("`basic_public_exchange_rate`");
        //币别ID
        if (rate.getCurrencyId() != null) {
            sql.SET("currency_id=#{currencyId}");
        }
        //兑人民币汇率
        if (rate.getToRmb() != null) {
            sql.SET("to_rmb=#{toRmb}");
        }
        //兑美元汇率
        if (rate.getToUsd() != null) {
            sql.SET("to_usd=#{toUsd}");
        }
        if (rate.getStatusId() != null) {
            sql.SET("status_id=#{statusId}");
        }
        Integer version = rate.getVersion();
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
        sql.WHERE("exchange_rate_id=#{exchangeRateId}");
        return sql.toString();
    }

    public String delRatePro(Map<String, Object> mapDel) {
        String thisIds = mapDel.get("thisIds").toString();
        return StrUtils.updateSql(thisIds,
                "UPDATE `basic_public_exchange_rate`\n" + "SET `del_or_not` = ", "1", null, "exchange_rate_id");
    }


}

package com.dt.user.provider;

import com.dt.user.dto.ExchangeRateDto;
import com.dt.user.model.BasePublicModel.BasicPublicExchangeRate;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicExchangeRateProvider {

    public String findRate(ExchangeRateDto rateDto) {
        SQL sql = new SQL();
        String Alias = "r";
        sql.SELECT("r.exchange_rate_id, c.currency_name,\n" +
                "r.`to_rmb`,r.`to_usd`,r.status_id,r.version\n" +
                "FROM `basic_public_exchange_rate` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_currency` AS c ON c.currency_id=r.`currency_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(rateDto.getSystemLogStatus(), Alias, sql);
        //币别名称
        AppendSqlStore.sqlWhere(rateDto.getCurrencyName(), "c.currency_name", sql, Constants.SELECT);
        //兑人民币汇率
        if (rateDto.getToRmb() != null) {
            sql.WHERE(Alias + ".to_rmb=#{toRmb}");
        }
        //兑美元汇率
        if (rateDto.getToUsd() != null) {
            sql.WHERE(Alias + ".to_usd=#{toUsd}");
        }
        sql.WHERE("r.del_or_not=0");
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

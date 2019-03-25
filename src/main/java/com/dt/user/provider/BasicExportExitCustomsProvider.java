package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicExportExitCustoms;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicExportExitCustomsProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:49
 **/
public class BasicExportExitCustomsProvider {


    public String findExitCustoms(BasicExportExitCustoms customs) {
        SQL sql = new SQL();
        String Alias = "ec";
        sql.SELECT("`exit_customs_id`,\n" +
                "`c_number`,`exit_customs_name`,\n" +
                " `exit_customs_name_pinyin`,ec.`status_id`\n" +
                "FROM `basic_export_exit_customs` AS  " + Alias + "");
        //状态数据查询
        ProviderSqlStore.saveStatus(customs.getSystemLogStatus(), Alias, sql);

        //出境口岸代码
        if (StringUtils.isNotBlank(customs.getcNumber())) {
            sql.WHERE(Alias + ".c_number=#{cNumber}");
        }
        //出境口岸名称
        if (StringUtils.isNotBlank(customs.getExitCustomsName())) {
            sql.WHERE(Alias + ".exit_customs_name=#{exitCustomsName}");
        }
        //出境口岸名称拼音
        if (StringUtils.isNotBlank(customs.getExitCustomsNamePinyin())) {
            sql.WHERE(Alias + ".exit_customs_name_pinyin=#{exitCustomsNamePinyin}");
        }
        return sql.toString();
    }


}

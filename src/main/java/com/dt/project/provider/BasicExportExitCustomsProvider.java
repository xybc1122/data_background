package com.dt.project.provider;

import com.dt.project.model.basePublic.BasicExportExitCustoms;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
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
        String alias = "ec";
        sql.SELECT("`exit_customs_id`,\n" +
                "`c_number`,`exit_customs_name`,\n" +
                " `exit_customs_name_pinyin`,ec.`status_id`\n" +
                "FROM `basic_export_exit_customs` AS  " + alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(customs.getSystemLogStatus(), alias, sql);

        //出境口岸代码
        AppendSqlStore.sqlWhere(customs.getcNumber(), alias + ".c_number", sql, Constants.SELECT,alias);
        //出境口岸名称
        AppendSqlStore.sqlWhere(customs.getExitCustomsName(), alias + ".exit_customs_name", sql, Constants.SELECT,alias);
        //出境口岸名称拼音
        AppendSqlStore.sqlWhere(customs.getExitCustomsNamePinyin(), alias + ".exit_customs_name_pinyin", sql, Constants.SELECT,alias);
        return sql.toString();
    }


}

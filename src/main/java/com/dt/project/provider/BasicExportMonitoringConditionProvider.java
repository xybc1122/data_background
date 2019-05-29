package com.dt.project.provider;

import com.dt.project.model.basePublicModel.BasicExportMonitoringCondition;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicExportMonitoringConditionProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:01
 **/
public class BasicExportMonitoringConditionProvider {


    public String findMonitoring(BasicExportMonitoringCondition condition) {
        SQL sql = new SQL();
        String alias = "mc";
        sql.SELECT("`monitoring_condition_id`, `c_number`, `monitoring_condition_name`,mc.`status_id`\n" +
                "FROM `basic_export_monitoring_condition` AS " + alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(condition.getSystemLogStatus(), alias, sql);

        //监管条件名称
        AppendSqlStore.sqlWhere(condition.getMonitoringConditionName(), alias + ".monitoring_condition_name", sql, Constants.SELECT);
        //编号
        AppendSqlStore.sqlWhere(condition.getcNumber(), alias + ".c_number", sql, Constants.SELECT);
        return sql.toString();
    }


}

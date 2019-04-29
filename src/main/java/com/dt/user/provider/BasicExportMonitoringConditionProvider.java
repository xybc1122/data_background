package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicExportMonitoringCondition;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        String Alias = "mc";
        sql.SELECT("`monitoring_condition_id`, `c_number`, `monitoring_condition_name`,mc.`status_id`\n" +
                "FROM `basic_export_monitoring_condition` AS " + Alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(condition.getSystemLogStatus(), Alias, sql);

        //监管条件名称
        if (StringUtils.isNotBlank(condition.getMonitoringConditionName())) {
            sql.WHERE(Alias + ".monitoring_condition_name=#{monitoringConditionName}");
        }
        //编号
        if (StringUtils.isNotBlank(condition.getcNumber())) {
            sql.WHERE(Alias + ".c_number=#{cNumber}");
        }
        return sql.toString();
    }


}

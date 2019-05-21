package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonHandlingClass;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicSalesAmazonHandlingClassProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:32
 **/
public class BasicSalesAmazonHandlingClassProvider {

    public String getHandlingClass(BasicSalesAmazonHandlingClass handlingClass) {
        SQL sql = new SQL();
        String alias = "gc";
        sql.SELECT("gc.`class_id`,gc.`class_name`,\n" +
                " gc.`size`,`region`,\n" +
                "  gc.`codex`,gc.`status_id`\n" +
                "FROM `basic_sales_amazon_handling_class` as " + alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(handlingClass.getSystemLogStatus(), alias, sql);

        //处理类名称
        AppendSqlStore.sqlWhere(handlingClass.getClassName(), alias + ".class_name", sql, Constants.SELECT);
        //处理尺寸
        AppendSqlStore.sqlWhere(handlingClass.getSize(), alias + ".size", sql, Constants.SELECT);
        //区域
        AppendSqlStore.sqlWhere(handlingClass.getRegion(), alias + ".region", sql, Constants.SELECT);
        //规则
        AppendSqlStore.sqlWhere(handlingClass.getCodex(), alias + ".codex", sql, Constants.SELECT);
        return sql.toString();
    }
}

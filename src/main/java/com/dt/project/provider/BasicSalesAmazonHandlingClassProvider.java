package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonHandlingClass;
import com.dt.project.store.ProviderSqlStore;
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
        String Alias = "gc";
        sql.SELECT("gc.`class_id`,gc.`class_name`,\n" +
                " gc.`size`,`region`,\n" +
                "  gc.`codex`,gc.`status_id`\n" +
                "FROM `basic_sales_amazon_handling_class` as " + Alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(handlingClass.getSystemLogStatus(), Alias, sql);

        //处理类名称
        if (StringUtils.isNotBlank(handlingClass.getClassName())) {
            sql.WHERE(Alias + ".class_name=#{className}");
        }
        //处理尺寸
        if (StringUtils.isNotBlank(handlingClass.getSize())) {
            sql.WHERE(Alias + ".size=#{size}");
        }
        //区域
        if (StringUtils.isNotBlank(handlingClass.getRegion())) {
            sql.WHERE(Alias + ".region=#{region}");
        }
        //规则
        if (StringUtils.isNotBlank(handlingClass.getCodex())) {
            sql.WHERE(Alias + ".codex=#{codex}");
        }
        return sql.toString();
    }
}

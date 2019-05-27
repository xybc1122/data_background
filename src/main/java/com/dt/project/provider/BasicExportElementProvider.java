package com.dt.project.provider;

import com.dt.project.model.basePublicModel.BasicExportElement;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicExportElementProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:02
 **/
public class BasicExportElementProvider {

    public String findElement(BasicExportElement element) {
        SQL sql = new SQL();
        String alias = "e";
        sql.SELECT("e.`element_id`, e.`element_name`, e.`element_name_eng`, e.`status_id`\n" +
                "FROM`basic_export_element` AS " + alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(element.getSystemLogStatus(), alias, sql);
        //要素名称
        AppendSqlStore.sqlWhere(element.getElementName(), alias + ".element_name", sql, Constants.SELECT);
        //要素名称英文
        AppendSqlStore.sqlWhere(element.getElementNameEng(), alias + ".element_name_eng", sql, Constants.SELECT);
        return sql.toString();
    }
}

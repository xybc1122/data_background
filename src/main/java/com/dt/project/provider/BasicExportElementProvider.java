package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicExportElement;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        String Alias = "e";
        sql.SELECT("e.`element_id`, e.`element_name`, e.`element_name_eng`, e.`status_id`\n" +
                "FROM`basic_export_element` AS " + Alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(element.getSystemLogStatus(), Alias, sql);
        //要素名称
        if (StringUtils.isNotBlank(element.getElementName())) {
            sql.WHERE(Alias + ".element_name=#{elementName}");
        }
        //要素名称英文
        if (StringUtils.isNotBlank(element.getElementNameEng())) {
            sql.WHERE(Alias + ".element_name_eng=#{elementNameEng}");
        }
        return sql.toString();
    }
}

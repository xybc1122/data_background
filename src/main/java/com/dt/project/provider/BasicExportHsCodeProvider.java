package com.dt.project.provider;

import com.dt.project.model.basePublic.BasicExportHsCode;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicExportHsCodeProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 11:09
 **/

public class BasicExportHsCodeProvider {


    public String findHsCode(BasicExportHsCode hsCode) {
        SQL sql = new SQL();
        String alias = "hc";
        sql.SELECT("hc.`hs_code_id`,hc.`hs_code`,\n" +
                "hc.`product_name`,hc.`product_name_eng`,\n" +
                "hc.`categories`,hc.`chapter`,hc.`status_id`\n" +
                "FROM `basic_export_hs_code` AS " + alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(hsCode.getSystemLogStatus(), alias, sql);
        //hs_code
        AppendSqlStore.sqlWhere(hsCode.getHsCode(), alias + ".hs_code", sql, Constants.SELECT);
        //品名
        AppendSqlStore.sqlWhere(hsCode.getProductName(), alias + ".product_name", sql, Constants.SELECT);
        //品名英文
        AppendSqlStore.sqlWhere(hsCode.getProductNameEng(), alias + ".product_name_eng", sql, Constants.SELECT);
        //商品分类
        AppendSqlStore.sqlWhere(hsCode.getCategories(), alias + ".categories", sql, Constants.SELECT);
        //商品章节
        AppendSqlStore.sqlWhere(hsCode.getChapter(), alias + ".chapter", sql, Constants.SELECT);
        return sql.toString();
    }
}

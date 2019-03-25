package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicExportHsCode;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        String Alias = "hc";
        sql.SELECT("hc.`hs_code_id`,hc.`hs_code`,\n" +
                "hc.`product_name`,hc.`product_name_eng`,\n" +
                "hc.`categories`,hc.`chapter`,hc.`status_id`\n" +
                "FROM `basic_export_hs_code` AS " + Alias + "");
        //状态数据查询
        ProviderSqlStore.saveStatus(hsCode.getSystemLogStatus(), Alias, sql);
        //hs_code
        if (StringUtils.isNotBlank(hsCode.getHsCode())) {
            sql.WHERE(Alias + ".hs_code=#{hsCode}");
        }
        //品名
        if (StringUtils.isNotBlank(hsCode.getProductName())) {
            sql.WHERE(Alias + ".product_name=#{productName}");
        }
        //品名英文
        if (StringUtils.isNotBlank(hsCode.getProductNameEng())) {
            sql.WHERE(Alias + ".product_name_eng=#{productNameEng}");
        }
        //商品分类
        if (hsCode.getCategories() != null) {
            sql.WHERE(Alias + ".categories=#{categories}");
        }
        //商品章节
        if (hsCode.getChapter() != null) {
            sql.WHERE(Alias + ".chapter=#{chapter}");
        }
        return sql.toString();
    }
}

package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicPublicProvinceRelation;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicPublicProvinceRelationProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 10:53
 **/
public class BasicPublicProvinceRelationProvider {


    public String findRelation(BasicPublicProvinceRelation relation) {
        SQL sql = new SQL();
        String alias = "r";
        sql.SELECT(" r.`province_relation_id`,r.`number`,\n" +
                "  r.`province_relation_name`,r.`status_id`,p.`province_name`\n" +
                "FROM `basic_public_province_relation` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_province` AS p ON p.`province_id`=r.`province_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(relation.getSystemLogStatus(), alias, sql);
        //省州名称
        if (StringUtils.isNotBlank(relation.getProvinceName())) {
            sql.WHERE("p.`province_name`=#{provinceName}");
        }
        //编号
        if (relation.getNumber() != null) {
            sql.WHERE(alias + ".`number`=#{number}");
        }
        //省州关联名称
        if (StringUtils.isNotBlank(relation.getProvinceRelationName())) {
            sql.WHERE(alias + ".`province_relation_name`=#{provinceRelationName}");
        }
        return sql.toString();
    }
}

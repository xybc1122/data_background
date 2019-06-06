package com.dt.project.provider;

import com.dt.project.model.basePublic.BasicLogisticsmgtTransportCompany;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName BasicLogisticsmgtTransportCompanyProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/18 14:46
 **/
public class BasicLogisticsmgtTransportCompanyProvider {

    public String findFreight(BasicLogisticsmgtTransportCompany company) {
        SQL sql = new SQL();
        String alias = "tc";
        sql.SELECT(" tc.`transport_company_id`,tc.`number`,tc.`transport_company_name`,tc.`transport_company_full_name`,\n" +
                " tc.`contact_person`,tc.`tel_phone`,tc.`mobile`,tc.`e_mail`,\n" +
                "  tc.`address`, tc.`status_id`\n" +
                "FROM `basic_logisticsmgt_transport_company` as " + alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(company.getSystemLogStatus(), alias, sql);
        //货运公司编号
        AppendSqlStore.sqlWhere(company.getNumber(), alias + ".number", sql, Constants.SELECT,alias);
        //货运公司简称
        AppendSqlStore.sqlWhere(company.getTransportCompanyName(), alias + ".`transport_company_name`", sql, Constants.SELECT,alias);
        //货运公司全称
        AppendSqlStore.sqlWhere(company.getTransportCompanyFullName(), alias + ".`transport_company_full_name`", sql, Constants.SELECT,alias);
        //联系人
        AppendSqlStore.sqlWhere(company.getContactPerson(), alias + ".`contact_person`", sql, Constants.SELECT,alias);
        //tel_phone 联系电话
        AppendSqlStore.sqlWhere(company.getTelPhone(), alias + ".`tel_phone`", sql, Constants.SELECT,alias);
        //mobile 移动号码
        AppendSqlStore.sqlWhere(company.getMobile(), alias + ".`mobile`", sql, Constants.SELECT,alias);
        //邮箱
        AppendSqlStore.sqlWhere(company.geteMail(), alias + ".`e_mail`", sql, Constants.SELECT,alias);
        //address 地址
        AppendSqlStore.sqlWhere(company.getAddress(), alias + ".`address`", sql, Constants.SELECT,alias);
        return sql.toString();
    }

}

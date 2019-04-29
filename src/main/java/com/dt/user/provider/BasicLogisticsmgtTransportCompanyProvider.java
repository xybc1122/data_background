package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
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
        String Alias = "tc";
        sql.SELECT(" tc.`transport_company_id`,tc.`number`,tc.`transport_company_name`,tc.`transport_company_full_name`,\n" +
                " tc.`contact_person`,tc.`tel_phone`,tc.`mobile`,tc.`e_mail`,\n" +
                "  tc.`address`, tc.`status_id`\n" +
                "FROM `basic_logisticsmgt_transport_company` as " + Alias + "");
        //状态数据查询
        ProviderSqlStore.selectStatus(company.getSystemLogStatus(), Alias, sql);
        //货运公司编号
        if (company.getNumber() != null) {
            sql.WHERE(Alias + ".number=#{number}");
        }
        //货运公司简称
        if (StringUtils.isNotBlank(company.getTransportCompanyName())) {
            sql.WHERE("POSITION('" + company.getTransportCompanyName() + "' IN tc.`transport_company_name`)");
        }
        //货运公司全称
        if (StringUtils.isNotBlank(company.getTransportCompanyFullName())) {
            sql.WHERE("POSITION('" + company.getTransportCompanyFullName() + "' IN tc.`transport_company_full_name`)");
        }
        //联系人
        if (StringUtils.isNotBlank(company.getContactPerson())) {
            sql.WHERE("POSITION('" + company.getContactPerson() + "' IN tc.`contact_person`)");
        }
        //tel_phone 联系电话
        if (StringUtils.isNotBlank(company.getTelPhone())) {
            sql.WHERE("POSITION('" + company.getTelPhone() + "' IN tc.`tel_phone`)");
        }
        //mobile 移动号码
        if (StringUtils.isNotBlank(company.getMobile())) {
            sql.WHERE("POSITION('" + company.getMobile() + "' IN tc.`mobile`)");
        }
        //邮箱
        if (StringUtils.isNotBlank(company.geteMail())) {
            sql.WHERE("POSITION('" + company.geteMail() + "' IN tc.`e_mail`)");
        }
        //address 地址
        if (StringUtils.isNotBlank(company.getAddress())) {
            sql.WHERE("POSITION('" + company.getAddress() + "' IN tc.`address`)");
        }
        return sql.toString();
    }

}

package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
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
        return new SQL() {{
            SELECT(" tc.`transport_company_id`,tc.`number`,tc.`transport_company_name`,tc.`transport_company_full_name`,\n" +
                    " tc.`contact_person`,tc.`tel_phone`,tc.`mobile`,tc.`e_mail`,\n" +
                    "  tc.`address`, tc.`status_id`\n" +
                    "FROM `basic_logisticsmgt_transport_company` as tc");
            if (company.getSystemLogStatus() != null) {
                LEFT_OUTER_JOIN("`system_log_status` AS ls ON ls.status_id=tc.`status_id`");
                //备注
                if (StringUtils.isNotBlank(company.getSystemLogStatus().getRemark())) {
                    WHERE("ls.remark=#{systemLogStatus.remark}");
                }
                //状态
                if (company.getSystemLogStatus().getStatus() != null) {
                    WHERE("ls.status=#{systemLogStatus.status}");
                }
                //创建时间
                if (company.getSystemLogStatus().getCreateDate() != null) {
                    WHERE("ls.create_date=#{systemLogStatus.createDate}");
                }
                //创建人
                if (company.getSystemLogStatus().getCreateUser() != null) {
                    WHERE("ls.create_user=#{systemLogStatus.createUser}");
                }
                //修改日期
                if (company.getSystemLogStatus().getModifyDate() != null) {
                    WHERE("ls.modify_date=#{systemLogStatus.modifyDate}");
                }
                //修改人
                if (company.getSystemLogStatus().getModifyUser() != null) {
                    WHERE("ls.modify_user=#{systemLogStatus.modifyUser}");
                }
                //审核时间
                if (company.getSystemLogStatus().getAuditDate() != null) {
                    WHERE("ls.audit_date=#{systemLogStatus.auditDate}");
                }
                //审核人
                if (company.getSystemLogStatus().getAuditUser() != null) {
                    WHERE("ls.audit_user=#{systemLogStatus.auditUser}");
                }
            }
            //货运公司编号
            if (company.getNumber() != null) {
                WHERE("number=#{number}");
            }
            //货运公司简称
            if (StringUtils.isNotBlank(company.getTransportCompanyName())) {
                WHERE("transport_company_name=#{transportCompanyName}");
            }
            //货运公司全称
            if (StringUtils.isNotBlank(company.getTransportCompanyFullName())) {
                WHERE("transport_company_full_name=#{transportCompanyFullName}");
            }
            //联系人
            if (StringUtils.isNotBlank(company.getContactPerson())) {
                WHERE("contact_person=#{contactPerson}");
            }
            //tel_phone 联系电话
            if (StringUtils.isNotBlank(company.getTelPhone())) {
                WHERE("tel_phone=#{telPhone}");
            }
            //mobile 移动号码
            if (StringUtils.isNotBlank(company.getMobile())) {
                WHERE("mobile=#{mobile}");
            }
            //邮箱
            if (StringUtils.isNotBlank(company.geteMail())) {
                WHERE("e_mail=#{eMail}");
            }
            //address 地址
            if (StringUtils.isNotBlank(company.getAddress())) {
                WHERE("address=#{address}");
            }
        }}.toString();
    }

}

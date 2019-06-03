package com.dt.project.provider;

import com.dt.project.model.basePublic.BasicPublicCompany;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName BasicPublicCompanyProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/12 9:01
 **/
public class BasicPublicCompanyProvider {


    public String upCompanyPro(BasicPublicCompany company) {
        SQL sql = new SQL();
        sql.UPDATE("`basic_public_company`");
        //公司编号
        if (company.getNumber() != null) {
            sql.SET("number=#{number}");
        }
        if (company.getStatusId() != null) {
            sql.SET("status_id=#{statusId}");
        }
        //公司名称
        if (StringUtils.isNotBlank(company.getCompanyName())) {
            sql.SET("company_name=#{companyName}");
        }
        //公司英文名称
        if (StringUtils.isNotBlank(company.getCompanyNameEng())) {
            sql.SET("company_name_eng=#{companyNameEng}");
        }
        //公司短代码
        if (StringUtils.isNotBlank(company.getCompanyShortCode())) {
            sql.SET("company_short_code=#{companyShortCode}");
        }
        //公司简称
        if (StringUtils.isNotBlank(company.getCompanyShortName())) {
            sql.SET("company_short_name=#{companyShortName}");
        }
        //公司英文简称
        if (StringUtils.isNotBlank(company.getCompanyShortNameEng())) {
            sql.SET("company_short_name_eng=#{companyShortNameEng}");
        }
        //公司地址
        if (StringUtils.isNotBlank(company.getAddress())) {
            sql.SET("address=#{address}");
        }
        //公司地址英文
        if (StringUtils.isNotBlank(company.getCompanyAddressEng())) {
            sql.SET("company_address_eng=#{companyAddressEng}");
        }
        //公司电话
        if (StringUtils.isNotBlank(company.getTelPhone())) {
            sql.SET("tel_phone=#{telPhone}");
        }
        //信用代码
        if (StringUtils.isNotBlank(company.getCreditCode())) {
            sql.SET("credit_code=#{creditCode}");
        }
        //开户行
        if (StringUtils.isNotBlank(company.getBankOfDeposit())) {
            sql.SET("bank_of_deposit=#{bankOfDeposit}");
        }
        //银行账号
        if (StringUtils.isNotBlank(company.getBankAccount())) {
            sql.SET("bank_account=#{bankAccount}");
        }
        //账号类型
        if (StringUtils.isNotBlank(company.getAccountType())) {
            sql.SET("account_type=#{accountType}");
        }
        Integer version = company.getVersion();
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
        sql.WHERE("company_id=#{companyId}");
        return sql.toString();
    }


    public String delCompanyPro(Map<String, Object> mapDel) {
        String thisIds = mapDel.get("thisIds").toString();
        return StrUtils.updateSql(thisIds,
                "UPDATE `basic_public_company`\n" + "SET `del_or_not` = ", "1", null, "company_id");
    }

}

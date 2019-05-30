package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.dto.CompanyDto;
import com.dt.project.model.basePublicModel.BasicPublicCompany;
import com.dt.project.provider.BasicPublicCompanyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicCompanyMapper {
    /**
     * 查询公司所有相关信息
     */
    @Select("SELECT `company_id`,`number`,`company_name`,`company_name_eng`,`company_short_name`,\n" +
            "`company_short_name_eng`,`credit_code`,company_short_code,`bank_of_deposit`,`bank_account`,`account_type`,`address`,`company_address_eng`,\n" +
            "`tel_phone`,status_id,version\n" +
            "FROM `basic_public_company` where del_or_not=0")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<CompanyDto> findByListCompany();


    /**
     * 修改公司信息
     */
    @UpdateProvider(type = BasicPublicCompanyProvider.class, method = "upCompanyPro")
    int upCompany(BasicPublicCompany company);

    /**
     * 批量删除数据/更新
     */
    @UpdateProvider(type = BasicPublicCompanyProvider.class, method = "delCompanyPro")
    int delCompany(@Param("thisIds") String thisIds);

    /**
     * 新增公司信息
     */
    @Insert("INSERT INTO `basic_public_company`\n" +
            "(`number`,`company_name`, `company_name_eng`,`company_short_code`," +
            "`company_short_name`,`company_short_name_eng`,\n" +
            "`address`,`company_address_eng`,`tel_phone`,`credit_code`," +
            "`bank_of_deposit`, `bank_account`,`account_type`,`status_id`)" +
            "VALUES (#{number}, #{companyName}, #{companyNameEng},#{companyShortCode},\n" +
            "#{companyShortName},#{companyShortNameEng},#{address},#{companyAddressEng},\n" +
            "#{telPhone},#{creditCode},#{bankOfDeposit},#{bankAccount},#{accountType},#{statusId});")
    int saveCompany(BasicPublicCompany company);
}

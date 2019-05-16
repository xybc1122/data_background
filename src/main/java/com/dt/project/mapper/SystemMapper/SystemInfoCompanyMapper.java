package com.dt.project.mapper.SystemMapper;

import com.dt.project.model.System.SystemInfoCompany;

import java.util.List;

import com.dt.project.provider.SystemInfoCompanySqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

public interface SystemInfoCompanyMapper {


    @SelectProvider(type = SystemInfoCompanySqlProvider.class, method = "countByExample")
    int countByExample(SystemInfoCompany example);

    @DeleteProvider(type = SystemInfoCompanySqlProvider.class, method = "deleteByExample")
    int deleteByExample(SystemInfoCompany example);


    /**
     * 新增公司 上传配置信息
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into system_info_company (company_name, ",
            "system_name, logo_url,status_id)",
            "values (#{companyName,jdbcType=VARCHAR}, ",
            "#{systemName,jdbcType=VARCHAR}, #{logoUrl,jdbcType=VARCHAR} ,#{statusId})"
    })
    int insertCompany(SystemInfoCompany record);

    @InsertProvider(type = SystemInfoCompanySqlProvider.class, method = "insertSelective")
    int insertSelective(SystemInfoCompany record);

    /**
     * 查询配置公司信息
     *
     * @param record
     * @return
     */
    @SelectProvider(type = SystemInfoCompanySqlProvider.class, method = "selectByInfoCompany")
    @Results({
            @Result(column = "c_id", property = "cid", jdbcType = JdbcType.INTEGER),
            @Result(column = "company_name", property = "companyName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "system_name", property = "systemName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "logo_url", property = "logoUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<SystemInfoCompany> selectByCompany(SystemInfoCompany record);









    @UpdateProvider(type = SystemInfoCompanySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemInfoCompany record);

    @UpdateProvider(type = SystemInfoCompanySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SystemInfoCompany record);
}
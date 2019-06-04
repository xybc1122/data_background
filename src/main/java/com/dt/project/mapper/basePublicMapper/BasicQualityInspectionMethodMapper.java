package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicQualityInspectionMethod;

import java.util.List;

import com.dt.project.provider.BasicQualityInspectionMethodSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface BasicQualityInspectionMethodMapper {
    @SelectProvider(type = BasicQualityInspectionMethodSqlProvider.class, method = "countByExample")
    int countByExample(BasicQualityInspectionMethod example);

    @DeleteProvider(type = BasicQualityInspectionMethodSqlProvider.class, method = "deleteByExample")
    int deleteByExample(BasicQualityInspectionMethod example);

    @Insert({
            "insert into basic_quality_inspection_method (inspection_method_id, number, ",
            "inspection_quarantine_name, status_id, ",
            "version, del_or_not)",
            "values (#{inspectionMethodId,jdbcType=INTEGER}, #{number,jdbcType=VARCHAR}, ",
            "#{inspectionQuarantineName,jdbcType=VARCHAR}, #{statusId,jdbcType=BIGINT}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(BasicQualityInspectionMethod record);

    @InsertProvider(type = BasicQualityInspectionMethodSqlProvider.class, method = "insertSelective")
    int insertSelective(BasicQualityInspectionMethod record);

    /**
     * 简单查询 检验方式
     *
     * @return
     */
    @Select("SELECT\n" +
            "  `inspection_method_id`,`number`,`inspection_quarantine_name`,`status_id`\n" +
            "FROM `basic_quality_inspection_method`\n")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicQualityInspectionMethod> selectByBQIMethod();


    @SelectProvider(type = BasicQualityInspectionMethodSqlProvider.class, method = "selectByExample")
    List<BasicQualityInspectionMethod> selectByExample(BasicQualityInspectionMethod example);

    @UpdateProvider(type = BasicQualityInspectionMethodSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicQualityInspectionMethod record);

    @UpdateProvider(type = BasicQualityInspectionMethodSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicQualityInspectionMethod record);
}
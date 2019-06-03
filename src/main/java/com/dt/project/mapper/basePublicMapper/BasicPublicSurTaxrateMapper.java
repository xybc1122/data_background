package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicPublicSurTaxrate;

import java.util.List;

import com.dt.project.provider.BasicPublicSurTaxrateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface BasicPublicSurTaxrateMapper {
    @SelectProvider(type = BasicPublicSurTaxrateSqlProvider.class, method = "countByExample")
    int countByExample(BasicPublicSurTaxrate example);

    @DeleteProvider(type = BasicPublicSurTaxrateSqlProvider.class, method = "deleteByExample")
    int deleteByExample(BasicPublicSurTaxrate example);

    @Insert({
            "insert into basic_public_sur_taxrate (taxrate_id, country_id, ",
            "products_id, is_all_cate, ",
            "tax_rate, status_id, ",
            "version, del_or_not)",
            "values (#{taxrateId,jdbcType=INTEGER}, #{countryId,jdbcType=INTEGER}, ",
            "#{productsId,jdbcType=INTEGER}, #{isAllCate,jdbcType=INTEGER}, ",
            "#{taxRate,jdbcType=DECIMAL}, #{statusId,jdbcType=BIGINT}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(BasicPublicSurTaxrate record);

    @InsertProvider(type = BasicPublicSurTaxrateSqlProvider.class, method = "insertSelective")
    int insertSelective(BasicPublicSurTaxrate record);


    /**
     * 查询附加税
     * *
     *
     * @param record
     * @return
     */
    @SelectProvider(type = BasicPublicSurTaxrateSqlProvider.class, method = "selectBySurTax")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicSurTaxrate> selectBySurTax(BasicPublicSurTaxrate record);


    @UpdateProvider(type = BasicPublicSurTaxrateSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPublicSurTaxrate record);

    @UpdateProvider(type = BasicPublicSurTaxrateSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPublicSurTaxrate record);
}
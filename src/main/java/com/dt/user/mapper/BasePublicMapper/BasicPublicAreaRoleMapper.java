package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.provider.BasicPublicAreaRoleSqlProvider;
import com.dt.user.model.BasePublicModel.BasicPublicAreaRole;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BasicPublicAreaRoleMapper {
    @SelectProvider(type= BasicPublicAreaRoleSqlProvider.class, method="countByExample")
    int countByExample(BasicPublicAreaRole example);

    @DeleteProvider(type=BasicPublicAreaRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(BasicPublicAreaRole example);

    @Insert({
        "insert into basic_public_area_role (ar_id, a_id, ",
        "r_id, create_user, ",
        "create_date)",
        "values (#{arId,jdbcType=INTEGER}, #{aId,jdbcType=INTEGER}, ",
        "#{rId,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=BINARY})"
    })
    int insert(BasicPublicAreaRole record);

    @InsertProvider(type=BasicPublicAreaRoleSqlProvider.class, method="insertSelective")
    int insertSelective(BasicPublicAreaRole record);

    @SelectProvider(type=BasicPublicAreaRoleSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ar_id", property="arId", jdbcType=JdbcType.INTEGER),
        @Result(column="a_id", property="aId", jdbcType=JdbcType.INTEGER),
        @Result(column="r_id", property="rId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.BINARY)
    })
    List<BasicPublicAreaRole> selectByExampleWithBLOBs(BasicPublicAreaRole example);

    @SelectProvider(type=BasicPublicAreaRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ar_id", property="arId", jdbcType=JdbcType.INTEGER),
        @Result(column="a_id", property="aId", jdbcType=JdbcType.INTEGER),
        @Result(column="r_id", property="rId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    List<BasicPublicAreaRole> selectByExample(BasicPublicAreaRole example);

    @UpdateProvider(type=BasicPublicAreaRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPublicAreaRole record);

    @UpdateProvider(type=BasicPublicAreaRoleSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BasicPublicAreaRole record);

    @UpdateProvider(type=BasicPublicAreaRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BasicPublicAreaRole record);
}
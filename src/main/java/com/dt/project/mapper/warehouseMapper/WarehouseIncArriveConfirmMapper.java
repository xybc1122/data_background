package com.dt.project.mapper.warehouseMapper;

import com.dt.project.provider.WarehouseIncArriveConfirmSqlProvider;
import com.dt.project.model.warehouse.WarehouseIncArriveConfirm;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface WarehouseIncArriveConfirmMapper {
    @SelectProvider(type = WarehouseIncArriveConfirmSqlProvider.class, method = "countByExample")
    int countByExample(WarehouseIncArriveConfirm example);

    @DeleteProvider(type = WarehouseIncArriveConfirmSqlProvider.class, method = "deleteByExample")
    int deleteByExample(WarehouseIncArriveConfirm example);

    @Insert({
            "insert into warehouse_inc_arrive_confirm (ac_id, date, ",
            "no, explanation, ",
            "dept_id, emp_id, manger_id, ",
            "children, closed, close_user, ",
            "close_date, order_confirm, ",
            "status_id, version, ",
            "del_or_not)",
            "values (#{acId,jdbcType=BIGINT}, #{date,jdbcType=BIGINT}, ",
            "#{no,jdbcType=VARCHAR}, #{explanation,jdbcType=VARCHAR}, ",
            "#{deptId,jdbcType=INTEGER}, #{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
            "#{children,jdbcType=BIT}, #{closed,jdbcType=INTEGER}, #{closeUser,jdbcType=VARCHAR}, ",
            "#{closeDate,jdbcType=BIGINT}, #{orderConfirm,jdbcType=INTEGER}, ",
            "#{statusId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    int insert(WarehouseIncArriveConfirm record);

    @InsertProvider(type = WarehouseIncArriveConfirmSqlProvider.class, method = "insertSelective")
    int insertSelective(WarehouseIncArriveConfirm record);

    /**
     * 查询到货确认
     *
     * @param record
     * @return
     */
    @SelectProvider(type = WarehouseIncArriveConfirmSqlProvider.class, method = "selectByWarIncArrive")
    List<WarehouseIncArriveConfirm> selectByWarIncArrive(WarehouseIncArriveConfirm record);

    @UpdateProvider(type = WarehouseIncArriveConfirmSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WarehouseIncArriveConfirm record);

    @UpdateProvider(type = WarehouseIncArriveConfirmSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") WarehouseIncArriveConfirm record);
}
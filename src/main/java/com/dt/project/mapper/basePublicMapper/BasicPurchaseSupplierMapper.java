package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicPurchaseSupplier;

import java.util.List;

import com.dt.project.provider.BasicPurchaseSupplierSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface BasicPurchaseSupplierMapper {
    @SelectProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "countByExample")
    int countByExample(BasicPurchaseSupplier example);

    @DeleteProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "deleteByExample")
    int deleteByExample(BasicPurchaseSupplier example);

    @Insert({
            "insert into basic_purchase_supplier (supplier_id, supplier_number, ",
            "supplier_full_name, supplier_full_name_eng, ",
            "suppliersupplier_short_code, supplier_short_name, ",
            "supplier_short_name_eng, credit_code, ",
            "bank_of_deposit, bank_account, ",
            "account_type, address, ",
            "address_eng, tel_phone, ",
            "status_id, version, ",
            "del_or_not)",
            "values (#{supplierId,jdbcType=INTEGER}, #{supplierNumber,jdbcType=INTEGER}, ",
            "#{supplierFullName,jdbcType=VARCHAR}, #{supplierFullNameEng,jdbcType=VARCHAR}, ",
            "#{suppliersupplierShortCode,jdbcType=VARCHAR}, #{supplierShortName,jdbcType=VARCHAR}, ",
            "#{supplierShortNameEng,jdbcType=VARCHAR}, #{creditCode,jdbcType=VARCHAR}, ",
            "#{bankOfDeposit,jdbcType=VARCHAR}, #{bankAccount,jdbcType=VARCHAR}, ",
            "#{accountType,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
            "#{addressEng,jdbcType=VARCHAR}, #{telPhone,jdbcType=VARCHAR}, ",
            "#{statusId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    int insert(BasicPurchaseSupplier record);

    @InsertProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "insertSelective")
    int insertSelective(BasicPurchaseSupplier record);

    /**
     * 查询供应商信息  id name
     *
     * @return
     */
    @Select("SELECT `supplier_id`,`supplier_full_name` FROM`basic_purchase_supplier`")
    List<BasicPurchaseSupplier> selectByPurchaseSupplier();


    @SelectProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "supplier_id", property = "supplierId", jdbcType = JdbcType.INTEGER),
            @Result(column = "supplier_number", property = "supplierNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "supplier_full_name", property = "supplierFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "supplier_full_name_eng", property = "supplierFullNameEng", jdbcType = JdbcType.VARCHAR),
            @Result(column = "suppliersupplier_short_code", property = "suppliersupplierShortCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "supplier_short_name", property = "supplierShortName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "supplier_short_name_eng", property = "supplierShortNameEng", jdbcType = JdbcType.VARCHAR),
            @Result(column = "credit_code", property = "creditCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_of_deposit", property = "bankOfDeposit", jdbcType = JdbcType.VARCHAR),
            @Result(column = "bank_account", property = "bankAccount", jdbcType = JdbcType.VARCHAR),
            @Result(column = "account_type", property = "accountType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address_eng", property = "addressEng", jdbcType = JdbcType.VARCHAR),
            @Result(column = "tel_phone", property = "telPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status_id", property = "statusId", jdbcType = JdbcType.BIGINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.INTEGER),
            @Result(column = "del_or_not", property = "delOrNot", jdbcType = JdbcType.BIT)
    })
    List<BasicPurchaseSupplier> selectByExample(BasicPurchaseSupplier example);

    @UpdateProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPurchaseSupplier record, @Param("example") BasicPurchaseSupplier example);

    @UpdateProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPurchaseSupplier record, @Param("example") BasicPurchaseSupplier example);
}
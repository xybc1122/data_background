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
//    @Select("SELECT `supplier_id`,`supplier_full_name` FROM`basic_purchase_supplier`")
//    List<BasicPurchaseSupplier> selectByPurchaseSupplier();


    @SelectProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "selectByPurchaseSupplier")
    List<BasicPurchaseSupplier> selectByPurchaseSupplier(BasicPurchaseSupplier example);

    @UpdateProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPurchaseSupplier record, @Param("example") BasicPurchaseSupplier example);

    @UpdateProvider(type = BasicPurchaseSupplierSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPurchaseSupplier record, @Param("example") BasicPurchaseSupplier example);
}
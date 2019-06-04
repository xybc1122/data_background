package com.dt.project.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.project.model.basePublic.BasicPurchaseSupplier;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.utils.FileUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPurchaseSupplierSqlProvider {

    public String countByExample(BasicPurchaseSupplier example) {
        BEGIN();
        SELECT("count(*)");
        FROM("basic_purchase_supplier");
        return SQL();
    }

    public String deleteByExample(BasicPurchaseSupplier example) {
        BEGIN();
        DELETE_FROM("basic_purchase_supplier");
        return SQL();
    }

    public String insertSelective(BasicPurchaseSupplier record) {
        BEGIN();
        INSERT_INTO("basic_purchase_supplier");

        if (record.getSupplierId() != null) {
            VALUES("supplier_id", "#{supplierId,jdbcType=INTEGER}");
        }

        if (record.getSupplierNumber() != null) {
            VALUES("supplier_number", "#{supplierNumber,jdbcType=INTEGER}");
        }

        if (record.getSupplierFullName() != null) {
            VALUES("supplier_full_name", "#{supplierFullName,jdbcType=VARCHAR}");
        }

        if (record.getSupplierFullNameEng() != null) {
            VALUES("supplier_full_name_eng", "#{supplierFullNameEng,jdbcType=VARCHAR}");
        }

        if (record.getSuppliersupplierShortCode() != null) {
            VALUES("suppliersupplier_short_code", "#{suppliersupplierShortCode,jdbcType=VARCHAR}");
        }

        if (record.getSupplierShortName() != null) {
            VALUES("supplier_short_name", "#{supplierShortName,jdbcType=VARCHAR}");
        }

        if (record.getSupplierShortNameEng() != null) {
            VALUES("supplier_short_name_eng", "#{supplierShortNameEng,jdbcType=VARCHAR}");
        }

        if (record.getCreditCode() != null) {
            VALUES("credit_code", "#{creditCode,jdbcType=VARCHAR}");
        }

        if (record.getBankOfDeposit() != null) {
            VALUES("bank_of_deposit", "#{bankOfDeposit,jdbcType=VARCHAR}");
        }

        if (record.getBankAccount() != null) {
            VALUES("bank_account", "#{bankAccount,jdbcType=VARCHAR}");
        }

        if (record.getAccountType() != null) {
            VALUES("account_type", "#{accountType,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }

        if (record.getAddressEng() != null) {
            VALUES("address_eng", "#{addressEng,jdbcType=VARCHAR}");
        }

        if (record.getTelPhone() != null) {
            VALUES("tel_phone", "#{telPhone,jdbcType=VARCHAR}");
        }

        if (record.getStatusId() != null) {
            VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
        }

        return SQL();
    }

    public String selectByPurchaseSupplier(BasicPurchaseSupplier record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "bps";
        sql.SELECT("`supplier_id`,`supplier_number`,`supplier_full_name`,`supplier_full_name_eng`,`suppliersupplier_short_code`,`supplier_short_name`,\n" +
                "`supplier_short_name_eng`,`credit_code`,`bank_of_deposit`,`bank_account`,`account_type`,`address`,\n" +
                "`address_eng`,`tel_phone`,\n" +
                "" + alias + ".`status_id`," + alias + ".`version`\n" +
                "FROM `basic_purchase_supplier` AS " + alias + "\n");
        FieldStore.query(record.getClass(), record.getJavaSqlName(), record, sql);
        ProviderSqlStore.selectStatus(record.getSystemLogStatus(), alias, sql);
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicPurchaseSupplier record = (BasicPurchaseSupplier) parameter.get("record");


        BEGIN();
        UPDATE("basic_purchase_supplier");

        if (record.getSupplierId() != null) {
            SET("supplier_id = #{record.supplierId,jdbcType=INTEGER}");
        }

        if (record.getSupplierNumber() != null) {
            SET("supplier_number = #{record.supplierNumber,jdbcType=INTEGER}");
        }

        if (record.getSupplierFullName() != null) {
            SET("supplier_full_name = #{record.supplierFullName,jdbcType=VARCHAR}");
        }

        if (record.getSupplierFullNameEng() != null) {
            SET("supplier_full_name_eng = #{record.supplierFullNameEng,jdbcType=VARCHAR}");
        }

        if (record.getSuppliersupplierShortCode() != null) {
            SET("suppliersupplier_short_code = #{record.suppliersupplierShortCode,jdbcType=VARCHAR}");
        }

        if (record.getSupplierShortName() != null) {
            SET("supplier_short_name = #{record.supplierShortName,jdbcType=VARCHAR}");
        }

        if (record.getSupplierShortNameEng() != null) {
            SET("supplier_short_name_eng = #{record.supplierShortNameEng,jdbcType=VARCHAR}");
        }

        if (record.getCreditCode() != null) {
            SET("credit_code = #{record.creditCode,jdbcType=VARCHAR}");
        }

        if (record.getBankOfDeposit() != null) {
            SET("bank_of_deposit = #{record.bankOfDeposit,jdbcType=VARCHAR}");
        }

        if (record.getBankAccount() != null) {
            SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        }

        if (record.getAccountType() != null) {
            SET("account_type = #{record.accountType,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }

        if (record.getAddressEng() != null) {
            SET("address_eng = #{record.addressEng,jdbcType=VARCHAR}");
        }

        if (record.getTelPhone() != null) {
            SET("tel_phone = #{record.telPhone,jdbcType=VARCHAR}");
        }

        if (record.getStatusId() != null) {
            SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        }

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("basic_purchase_supplier");

        SET("supplier_id = #{record.supplierId,jdbcType=INTEGER}");
        SET("supplier_number = #{record.supplierNumber,jdbcType=INTEGER}");
        SET("supplier_full_name = #{record.supplierFullName,jdbcType=VARCHAR}");
        SET("supplier_full_name_eng = #{record.supplierFullNameEng,jdbcType=VARCHAR}");
        SET("suppliersupplier_short_code = #{record.suppliersupplierShortCode,jdbcType=VARCHAR}");
        SET("supplier_short_name = #{record.supplierShortName,jdbcType=VARCHAR}");
        SET("supplier_short_name_eng = #{record.supplierShortNameEng,jdbcType=VARCHAR}");
        SET("credit_code = #{record.creditCode,jdbcType=VARCHAR}");
        SET("bank_of_deposit = #{record.bankOfDeposit,jdbcType=VARCHAR}");
        SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        SET("account_type = #{record.accountType,jdbcType=VARCHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("address_eng = #{record.addressEng,jdbcType=VARCHAR}");
        SET("tel_phone = #{record.telPhone,jdbcType=VARCHAR}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");


        return SQL();
    }
}
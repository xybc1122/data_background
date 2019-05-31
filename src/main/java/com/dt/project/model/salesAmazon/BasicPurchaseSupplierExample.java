package com.dt.project.model.salesAmazon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("`basic_purchase_supplier`")
public class BasicPurchaseSupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public BasicPurchaseSupplierExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Integer value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Integer value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Integer value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Integer value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Integer> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Integer> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberIsNull() {
            addCriterion("supplier_number is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberIsNotNull() {
            addCriterion("supplier_number is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberEqualTo(Integer value) {
            addCriterion("supplier_number =", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotEqualTo(Integer value) {
            addCriterion("supplier_number <>", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberGreaterThan(Integer value) {
            addCriterion("supplier_number >", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplier_number >=", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberLessThan(Integer value) {
            addCriterion("supplier_number <", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberLessThanOrEqualTo(Integer value) {
            addCriterion("supplier_number <=", value, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberIn(List<Integer> values) {
            addCriterion("supplier_number in", values, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotIn(List<Integer> values) {
            addCriterion("supplier_number not in", values, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberBetween(Integer value1, Integer value2) {
            addCriterion("supplier_number between", value1, value2, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("supplier_number not between", value1, value2, "supplierNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameIsNull() {
            addCriterion("supplier_full_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameIsNotNull() {
            addCriterion("supplier_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEqualTo(String value) {
            addCriterion("supplier_full_name =", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameNotEqualTo(String value) {
            addCriterion("supplier_full_name <>", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameGreaterThan(String value) {
            addCriterion("supplier_full_name >", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_full_name >=", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameLessThan(String value) {
            addCriterion("supplier_full_name <", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_full_name <=", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameLike(String value) {
            addCriterion("supplier_full_name like", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameNotLike(String value) {
            addCriterion("supplier_full_name not like", value, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameIn(List<String> values) {
            addCriterion("supplier_full_name in", values, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameNotIn(List<String> values) {
            addCriterion("supplier_full_name not in", values, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameBetween(String value1, String value2) {
            addCriterion("supplier_full_name between", value1, value2, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameNotBetween(String value1, String value2) {
            addCriterion("supplier_full_name not between", value1, value2, "supplierFullName");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngIsNull() {
            addCriterion("supplier_full_name_eng is null");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngIsNotNull() {
            addCriterion("supplier_full_name_eng is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngEqualTo(String value) {
            addCriterion("supplier_full_name_eng =", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngNotEqualTo(String value) {
            addCriterion("supplier_full_name_eng <>", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngGreaterThan(String value) {
            addCriterion("supplier_full_name_eng >", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_full_name_eng >=", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngLessThan(String value) {
            addCriterion("supplier_full_name_eng <", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngLessThanOrEqualTo(String value) {
            addCriterion("supplier_full_name_eng <=", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngLike(String value) {
            addCriterion("supplier_full_name_eng like", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngNotLike(String value) {
            addCriterion("supplier_full_name_eng not like", value, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngIn(List<String> values) {
            addCriterion("supplier_full_name_eng in", values, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngNotIn(List<String> values) {
            addCriterion("supplier_full_name_eng not in", values, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngBetween(String value1, String value2) {
            addCriterion("supplier_full_name_eng between", value1, value2, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierFullNameEngNotBetween(String value1, String value2) {
            addCriterion("supplier_full_name_eng not between", value1, value2, "supplierFullNameEng");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeIsNull() {
            addCriterion("suppliersupplier_short_code is null");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeIsNotNull() {
            addCriterion("suppliersupplier_short_code is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeEqualTo(String value) {
            addCriterion("suppliersupplier_short_code =", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeNotEqualTo(String value) {
            addCriterion("suppliersupplier_short_code <>", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeGreaterThan(String value) {
            addCriterion("suppliersupplier_short_code >", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeGreaterThanOrEqualTo(String value) {
            addCriterion("suppliersupplier_short_code >=", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeLessThan(String value) {
            addCriterion("suppliersupplier_short_code <", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeLessThanOrEqualTo(String value) {
            addCriterion("suppliersupplier_short_code <=", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeLike(String value) {
            addCriterion("suppliersupplier_short_code like", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeNotLike(String value) {
            addCriterion("suppliersupplier_short_code not like", value, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeIn(List<String> values) {
            addCriterion("suppliersupplier_short_code in", values, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeNotIn(List<String> values) {
            addCriterion("suppliersupplier_short_code not in", values, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeBetween(String value1, String value2) {
            addCriterion("suppliersupplier_short_code between", value1, value2, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSuppliersupplierShortCodeNotBetween(String value1, String value2) {
            addCriterion("suppliersupplier_short_code not between", value1, value2, "suppliersupplierShortCode");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameIsNull() {
            addCriterion("supplier_short_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameIsNotNull() {
            addCriterion("supplier_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEqualTo(String value) {
            addCriterion("supplier_short_name =", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotEqualTo(String value) {
            addCriterion("supplier_short_name <>", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameGreaterThan(String value) {
            addCriterion("supplier_short_name >", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_short_name >=", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameLessThan(String value) {
            addCriterion("supplier_short_name <", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_short_name <=", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameLike(String value) {
            addCriterion("supplier_short_name like", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotLike(String value) {
            addCriterion("supplier_short_name not like", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameIn(List<String> values) {
            addCriterion("supplier_short_name in", values, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotIn(List<String> values) {
            addCriterion("supplier_short_name not in", values, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameBetween(String value1, String value2) {
            addCriterion("supplier_short_name between", value1, value2, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotBetween(String value1, String value2) {
            addCriterion("supplier_short_name not between", value1, value2, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngIsNull() {
            addCriterion("supplier_short_name_eng is null");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngIsNotNull() {
            addCriterion("supplier_short_name_eng is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngEqualTo(String value) {
            addCriterion("supplier_short_name_eng =", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngNotEqualTo(String value) {
            addCriterion("supplier_short_name_eng <>", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngGreaterThan(String value) {
            addCriterion("supplier_short_name_eng >", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_short_name_eng >=", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngLessThan(String value) {
            addCriterion("supplier_short_name_eng <", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngLessThanOrEqualTo(String value) {
            addCriterion("supplier_short_name_eng <=", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngLike(String value) {
            addCriterion("supplier_short_name_eng like", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngNotLike(String value) {
            addCriterion("supplier_short_name_eng not like", value, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngIn(List<String> values) {
            addCriterion("supplier_short_name_eng in", values, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngNotIn(List<String> values) {
            addCriterion("supplier_short_name_eng not in", values, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngBetween(String value1, String value2) {
            addCriterion("supplier_short_name_eng between", value1, value2, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEngNotBetween(String value1, String value2) {
            addCriterion("supplier_short_name_eng not between", value1, value2, "supplierShortNameEng");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNull() {
            addCriterion("bank_of_deposit is null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIsNotNull() {
            addCriterion("bank_of_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositEqualTo(String value) {
            addCriterion("bank_of_deposit =", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotEqualTo(String value) {
            addCriterion("bank_of_deposit <>", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThan(String value) {
            addCriterion("bank_of_deposit >", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositGreaterThanOrEqualTo(String value) {
            addCriterion("bank_of_deposit >=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThan(String value) {
            addCriterion("bank_of_deposit <", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLessThanOrEqualTo(String value) {
            addCriterion("bank_of_deposit <=", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositLike(String value) {
            addCriterion("bank_of_deposit like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotLike(String value) {
            addCriterion("bank_of_deposit not like", value, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositIn(List<String> values) {
            addCriterion("bank_of_deposit in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotIn(List<String> values) {
            addCriterion("bank_of_deposit not in", values, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositBetween(String value1, String value2) {
            addCriterion("bank_of_deposit between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankOfDepositNotBetween(String value1, String value2) {
            addCriterion("bank_of_deposit not between", value1, value2, "bankOfDeposit");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(String value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(String value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(String value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(String value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLike(String value) {
            addCriterion("account_type like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotLike(String value) {
            addCriterion("account_type not like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<String> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<String> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(String value1, String value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(String value1, String value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressEngIsNull() {
            addCriterion("address_eng is null");
            return (Criteria) this;
        }

        public Criteria andAddressEngIsNotNull() {
            addCriterion("address_eng is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEngEqualTo(String value) {
            addCriterion("address_eng =", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngNotEqualTo(String value) {
            addCriterion("address_eng <>", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngGreaterThan(String value) {
            addCriterion("address_eng >", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngGreaterThanOrEqualTo(String value) {
            addCriterion("address_eng >=", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngLessThan(String value) {
            addCriterion("address_eng <", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngLessThanOrEqualTo(String value) {
            addCriterion("address_eng <=", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngLike(String value) {
            addCriterion("address_eng like", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngNotLike(String value) {
            addCriterion("address_eng not like", value, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngIn(List<String> values) {
            addCriterion("address_eng in", values, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngNotIn(List<String> values) {
            addCriterion("address_eng not in", values, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngBetween(String value1, String value2) {
            addCriterion("address_eng between", value1, value2, "addressEng");
            return (Criteria) this;
        }

        public Criteria andAddressEngNotBetween(String value1, String value2) {
            addCriterion("address_eng not between", value1, value2, "addressEng");
            return (Criteria) this;
        }

        public Criteria andTelPhoneIsNull() {
            addCriterion("tel_phone is null");
            return (Criteria) this;
        }

        public Criteria andTelPhoneIsNotNull() {
            addCriterion("tel_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTelPhoneEqualTo(String value) {
            addCriterion("tel_phone =", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotEqualTo(String value) {
            addCriterion("tel_phone <>", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneGreaterThan(String value) {
            addCriterion("tel_phone >", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("tel_phone >=", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneLessThan(String value) {
            addCriterion("tel_phone <", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneLessThanOrEqualTo(String value) {
            addCriterion("tel_phone <=", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneLike(String value) {
            addCriterion("tel_phone like", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotLike(String value) {
            addCriterion("tel_phone not like", value, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneIn(List<String> values) {
            addCriterion("tel_phone in", values, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotIn(List<String> values) {
            addCriterion("tel_phone not in", values, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneBetween(String value1, String value2) {
            addCriterion("tel_phone between", value1, value2, "telPhone");
            return (Criteria) this;
        }

        public Criteria andTelPhoneNotBetween(String value1, String value2) {
            addCriterion("tel_phone not between", value1, value2, "telPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNull() {
            addCriterion("status_id is null");
            return (Criteria) this;
        }

        public Criteria andStatusIdIsNotNull() {
            addCriterion("status_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatusIdEqualTo(Long value) {
            addCriterion("status_id =", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotEqualTo(Long value) {
            addCriterion("status_id <>", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThan(Long value) {
            addCriterion("status_id >", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("status_id >=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThan(Long value) {
            addCriterion("status_id <", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdLessThanOrEqualTo(Long value) {
            addCriterion("status_id <=", value, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdIn(List<Long> values) {
            addCriterion("status_id in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotIn(List<Long> values) {
            addCriterion("status_id not in", values, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdBetween(Long value1, Long value2) {
            addCriterion("status_id between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andStatusIdNotBetween(Long value1, Long value2) {
            addCriterion("status_id not between", value1, value2, "statusId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdIsNull() {
            addCriterion("recording_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordingIdIsNotNull() {
            addCriterion("recording_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordingIdEqualTo(Long value) {
            addCriterion("recording_id =", value, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdNotEqualTo(Long value) {
            addCriterion("recording_id <>", value, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdGreaterThan(Long value) {
            addCriterion("recording_id >", value, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recording_id >=", value, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdLessThan(Long value) {
            addCriterion("recording_id <", value, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdLessThanOrEqualTo(Long value) {
            addCriterion("recording_id <=", value, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdIn(List<Long> values) {
            addCriterion("recording_id in", values, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdNotIn(List<Long> values) {
            addCriterion("recording_id not in", values, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdBetween(Long value1, Long value2) {
            addCriterion("recording_id between", value1, value2, "recordingId");
            return (Criteria) this;
        }

        public Criteria andRecordingIdNotBetween(Long value1, Long value2) {
            addCriterion("recording_id not between", value1, value2, "recordingId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDelOrNotIsNull() {
            addCriterion("del_or_not is null");
            return (Criteria) this;
        }

        public Criteria andDelOrNotIsNotNull() {
            addCriterion("del_or_not is not null");
            return (Criteria) this;
        }

        public Criteria andDelOrNotEqualTo(Boolean value) {
            addCriterion("del_or_not =", value, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotNotEqualTo(Boolean value) {
            addCriterion("del_or_not <>", value, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotGreaterThan(Boolean value) {
            addCriterion("del_or_not >", value, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del_or_not >=", value, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotLessThan(Boolean value) {
            addCriterion("del_or_not <", value, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotLessThanOrEqualTo(Boolean value) {
            addCriterion("del_or_not <=", value, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotIn(List<Boolean> values) {
            addCriterion("del_or_not in", values, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotNotIn(List<Boolean> values) {
            addCriterion("del_or_not not in", values, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del_or_not between", value1, value2, "delOrNot");
            return (Criteria) this;
        }

        public Criteria andDelOrNotNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del_or_not not between", value1, value2, "delOrNot");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package com.dt.project.model.salesAmazon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("`purchase_po_order_entry`")
public class PurchasePoOrderEntryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PurchasePoOrderEntryExample() {
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

        public Criteria andPoeIdIsNull() {
            addCriterion("poe_id is null");
            return (Criteria) this;
        }

        public Criteria andPoeIdIsNotNull() {
            addCriterion("poe_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoeIdEqualTo(Long value) {
            addCriterion("poe_id =", value, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdNotEqualTo(Long value) {
            addCriterion("poe_id <>", value, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdGreaterThan(Long value) {
            addCriterion("poe_id >", value, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("poe_id >=", value, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdLessThan(Long value) {
            addCriterion("poe_id <", value, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdLessThanOrEqualTo(Long value) {
            addCriterion("poe_id <=", value, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdIn(List<Long> values) {
            addCriterion("poe_id in", values, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdNotIn(List<Long> values) {
            addCriterion("poe_id not in", values, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdBetween(Long value1, Long value2) {
            addCriterion("poe_id between", value1, value2, "poeId");
            return (Criteria) this;
        }

        public Criteria andPoeIdNotBetween(Long value1, Long value2) {
            addCriterion("poe_id not between", value1, value2, "poeId");
            return (Criteria) this;
        }

        public Criteria andEntryIdIsNull() {
            addCriterion("entry_id is null");
            return (Criteria) this;
        }

        public Criteria andEntryIdIsNotNull() {
            addCriterion("entry_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntryIdEqualTo(Integer value) {
            addCriterion("entry_id =", value, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdNotEqualTo(Integer value) {
            addCriterion("entry_id <>", value, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdGreaterThan(Integer value) {
            addCriterion("entry_id >", value, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("entry_id >=", value, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdLessThan(Integer value) {
            addCriterion("entry_id <", value, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdLessThanOrEqualTo(Integer value) {
            addCriterion("entry_id <=", value, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdIn(List<Integer> values) {
            addCriterion("entry_id in", values, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdNotIn(List<Integer> values) {
            addCriterion("entry_id not in", values, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdBetween(Integer value1, Integer value2) {
            addCriterion("entry_id between", value1, value2, "entryId");
            return (Criteria) this;
        }

        public Criteria andEntryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("entry_id not between", value1, value2, "entryId");
            return (Criteria) this;
        }

        public Criteria andPoIdIsNull() {
            addCriterion("po_id is null");
            return (Criteria) this;
        }

        public Criteria andPoIdIsNotNull() {
            addCriterion("po_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoIdEqualTo(Long value) {
            addCriterion("po_id =", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotEqualTo(Long value) {
            addCriterion("po_id <>", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdGreaterThan(Long value) {
            addCriterion("po_id >", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("po_id >=", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdLessThan(Long value) {
            addCriterion("po_id <", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdLessThanOrEqualTo(Long value) {
            addCriterion("po_id <=", value, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdIn(List<Long> values) {
            addCriterion("po_id in", values, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotIn(List<Long> values) {
            addCriterion("po_id not in", values, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdBetween(Long value1, Long value2) {
            addCriterion("po_id between", value1, value2, "poId");
            return (Criteria) this;
        }

        public Criteria andPoIdNotBetween(Long value1, Long value2) {
            addCriterion("po_id not between", value1, value2, "poId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(BigDecimal value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(BigDecimal value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(BigDecimal value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(BigDecimal value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<BigDecimal> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<BigDecimal> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceTaxIsNull() {
            addCriterion("price_tax is null");
            return (Criteria) this;
        }

        public Criteria andPriceTaxIsNotNull() {
            addCriterion("price_tax is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTaxEqualTo(BigDecimal value) {
            addCriterion("price_tax =", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxNotEqualTo(BigDecimal value) {
            addCriterion("price_tax <>", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxGreaterThan(BigDecimal value) {
            addCriterion("price_tax >", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_tax >=", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxLessThan(BigDecimal value) {
            addCriterion("price_tax <", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_tax <=", value, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxIn(List<BigDecimal> values) {
            addCriterion("price_tax in", values, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxNotIn(List<BigDecimal> values) {
            addCriterion("price_tax not in", values, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_tax between", value1, value2, "priceTax");
            return (Criteria) this;
        }

        public Criteria andPriceTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_tax not between", value1, value2, "priceTax");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIsNull() {
            addCriterion("tax_amt is null");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIsNotNull() {
            addCriterion("tax_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAmtEqualTo(BigDecimal value) {
            addCriterion("tax_amt =", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotEqualTo(BigDecimal value) {
            addCriterion("tax_amt <>", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtGreaterThan(BigDecimal value) {
            addCriterion("tax_amt >", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_amt >=", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtLessThan(BigDecimal value) {
            addCriterion("tax_amt <", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_amt <=", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIn(List<BigDecimal> values) {
            addCriterion("tax_amt in", values, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotIn(List<BigDecimal> values) {
            addCriterion("tax_amt not in", values, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_amt between", value1, value2, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_amt not between", value1, value2, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountTaxIsNull() {
            addCriterion("amount_tax is null");
            return (Criteria) this;
        }

        public Criteria andAmountTaxIsNotNull() {
            addCriterion("amount_tax is not null");
            return (Criteria) this;
        }

        public Criteria andAmountTaxEqualTo(BigDecimal value) {
            addCriterion("amount_tax =", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxNotEqualTo(BigDecimal value) {
            addCriterion("amount_tax <>", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxGreaterThan(BigDecimal value) {
            addCriterion("amount_tax >", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_tax >=", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxLessThan(BigDecimal value) {
            addCriterion("amount_tax <", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_tax <=", value, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxIn(List<BigDecimal> values) {
            addCriterion("amount_tax in", values, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxNotIn(List<BigDecimal> values) {
            addCriterion("amount_tax not in", values, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_tax between", value1, value2, "amountTax");
            return (Criteria) this;
        }

        public Criteria andAmountTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_tax not between", value1, value2, "amountTax");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdIsNull() {
            addCriterion("poe_source_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdIsNotNull() {
            addCriterion("poe_source_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdEqualTo(Long value) {
            addCriterion("poe_source_type_id =", value, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdNotEqualTo(Long value) {
            addCriterion("poe_source_type_id <>", value, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdGreaterThan(Long value) {
            addCriterion("poe_source_type_id >", value, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("poe_source_type_id >=", value, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdLessThan(Long value) {
            addCriterion("poe_source_type_id <", value, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("poe_source_type_id <=", value, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdIn(List<Long> values) {
            addCriterion("poe_source_type_id in", values, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdNotIn(List<Long> values) {
            addCriterion("poe_source_type_id not in", values, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdBetween(Long value1, Long value2) {
            addCriterion("poe_source_type_id between", value1, value2, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("poe_source_type_id not between", value1, value2, "poeSourceTypeId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdIsNull() {
            addCriterion("poe_source_id is null");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdIsNotNull() {
            addCriterion("poe_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdEqualTo(String value) {
            addCriterion("poe_source_id =", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdNotEqualTo(String value) {
            addCriterion("poe_source_id <>", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdGreaterThan(String value) {
            addCriterion("poe_source_id >", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("poe_source_id >=", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdLessThan(String value) {
            addCriterion("poe_source_id <", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdLessThanOrEqualTo(String value) {
            addCriterion("poe_source_id <=", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdLike(String value) {
            addCriterion("poe_source_id like", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdNotLike(String value) {
            addCriterion("poe_source_id not like", value, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdIn(List<String> values) {
            addCriterion("poe_source_id in", values, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdNotIn(List<String> values) {
            addCriterion("poe_source_id not in", values, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdBetween(String value1, String value2) {
            addCriterion("poe_source_id between", value1, value2, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andPoeSourceIdNotBetween(String value1, String value2) {
            addCriterion("poe_source_id not between", value1, value2, "poeSourceId");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Long value) {
            addCriterion("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Long value) {
            addCriterion("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Long value) {
            addCriterion("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Long value) {
            addCriterion("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Long value) {
            addCriterion("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Long value) {
            addCriterion("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Long> values) {
            addCriterion("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Long> values) {
            addCriterion("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Long value1, Long value2) {
            addCriterion("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Long value1, Long value2) {
            addCriterion("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdIsNull() {
            addCriterion("invoice_entry_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdIsNotNull() {
            addCriterion("invoice_entry_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdEqualTo(Long value) {
            addCriterion("invoice_entry_id =", value, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdNotEqualTo(Long value) {
            addCriterion("invoice_entry_id <>", value, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdGreaterThan(Long value) {
            addCriterion("invoice_entry_id >", value, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invoice_entry_id >=", value, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdLessThan(Long value) {
            addCriterion("invoice_entry_id <", value, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdLessThanOrEqualTo(Long value) {
            addCriterion("invoice_entry_id <=", value, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdIn(List<Long> values) {
            addCriterion("invoice_entry_id in", values, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdNotIn(List<Long> values) {
            addCriterion("invoice_entry_id not in", values, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdBetween(Long value1, Long value2) {
            addCriterion("invoice_entry_id between", value1, value2, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andInvoiceEntryIdNotBetween(Long value1, Long value2) {
            addCriterion("invoice_entry_id not between", value1, value2, "invoiceEntryId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdIsNull() {
            addCriterion("recive_warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdIsNotNull() {
            addCriterion("recive_warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdEqualTo(Long value) {
            addCriterion("recive_warehouse_id =", value, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdNotEqualTo(Long value) {
            addCriterion("recive_warehouse_id <>", value, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdGreaterThan(Long value) {
            addCriterion("recive_warehouse_id >", value, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recive_warehouse_id >=", value, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdLessThan(Long value) {
            addCriterion("recive_warehouse_id <", value, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdLessThanOrEqualTo(Long value) {
            addCriterion("recive_warehouse_id <=", value, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdIn(List<Long> values) {
            addCriterion("recive_warehouse_id in", values, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdNotIn(List<Long> values) {
            addCriterion("recive_warehouse_id not in", values, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdBetween(Long value1, Long value2) {
            addCriterion("recive_warehouse_id between", value1, value2, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andReciveWarehouseIdNotBetween(Long value1, Long value2) {
            addCriterion("recive_warehouse_id not between", value1, value2, "reciveWarehouseId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdIsNull() {
            addCriterion("recive_position_id is null");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdIsNotNull() {
            addCriterion("recive_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdEqualTo(Long value) {
            addCriterion("recive_position_id =", value, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdNotEqualTo(Long value) {
            addCriterion("recive_position_id <>", value, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdGreaterThan(Long value) {
            addCriterion("recive_position_id >", value, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recive_position_id >=", value, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdLessThan(Long value) {
            addCriterion("recive_position_id <", value, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdLessThanOrEqualTo(Long value) {
            addCriterion("recive_position_id <=", value, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdIn(List<Long> values) {
            addCriterion("recive_position_id in", values, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdNotIn(List<Long> values) {
            addCriterion("recive_position_id not in", values, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdBetween(Long value1, Long value2) {
            addCriterion("recive_position_id between", value1, value2, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andRecivePositionIdNotBetween(Long value1, Long value2) {
            addCriterion("recive_position_id not between", value1, value2, "recivePositionId");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyIsNull() {
            addCriterion("poe_qu_qty is null");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyIsNotNull() {
            addCriterion("poe_qu_qty is not null");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyEqualTo(BigDecimal value) {
            addCriterion("poe_qu_qty =", value, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyNotEqualTo(BigDecimal value) {
            addCriterion("poe_qu_qty <>", value, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyGreaterThan(BigDecimal value) {
            addCriterion("poe_qu_qty >", value, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("poe_qu_qty >=", value, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyLessThan(BigDecimal value) {
            addCriterion("poe_qu_qty <", value, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("poe_qu_qty <=", value, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyIn(List<BigDecimal> values) {
            addCriterion("poe_qu_qty in", values, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyNotIn(List<BigDecimal> values) {
            addCriterion("poe_qu_qty not in", values, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poe_qu_qty between", value1, value2, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeQuQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poe_qu_qty not between", value1, value2, "poeQuQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyIsNull() {
            addCriterion("poe_fa_qty is null");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyIsNotNull() {
            addCriterion("poe_fa_qty is not null");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyEqualTo(BigDecimal value) {
            addCriterion("poe_fa_qty =", value, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyNotEqualTo(BigDecimal value) {
            addCriterion("poe_fa_qty <>", value, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyGreaterThan(BigDecimal value) {
            addCriterion("poe_fa_qty >", value, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("poe_fa_qty >=", value, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyLessThan(BigDecimal value) {
            addCriterion("poe_fa_qty <", value, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("poe_fa_qty <=", value, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyIn(List<BigDecimal> values) {
            addCriterion("poe_fa_qty in", values, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyNotIn(List<BigDecimal> values) {
            addCriterion("poe_fa_qty not in", values, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poe_fa_qty between", value1, value2, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andPoeFaQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poe_fa_qty not between", value1, value2, "poeFaQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyIsNull() {
            addCriterion("inbound_qty is null");
            return (Criteria) this;
        }

        public Criteria andInboundQtyIsNotNull() {
            addCriterion("inbound_qty is not null");
            return (Criteria) this;
        }

        public Criteria andInboundQtyEqualTo(BigDecimal value) {
            addCriterion("inbound_qty =", value, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyNotEqualTo(BigDecimal value) {
            addCriterion("inbound_qty <>", value, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyGreaterThan(BigDecimal value) {
            addCriterion("inbound_qty >", value, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("inbound_qty >=", value, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyLessThan(BigDecimal value) {
            addCriterion("inbound_qty <", value, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("inbound_qty <=", value, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyIn(List<BigDecimal> values) {
            addCriterion("inbound_qty in", values, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyNotIn(List<BigDecimal> values) {
            addCriterion("inbound_qty not in", values, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inbound_qty between", value1, value2, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andInboundQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("inbound_qty not between", value1, value2, "inboundQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyIsNull() {
            addCriterion("poe_return_qty is null");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyIsNotNull() {
            addCriterion("poe_return_qty is not null");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyEqualTo(BigDecimal value) {
            addCriterion("poe_return_qty =", value, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyNotEqualTo(BigDecimal value) {
            addCriterion("poe_return_qty <>", value, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyGreaterThan(BigDecimal value) {
            addCriterion("poe_return_qty >", value, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("poe_return_qty >=", value, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyLessThan(BigDecimal value) {
            addCriterion("poe_return_qty <", value, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("poe_return_qty <=", value, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyIn(List<BigDecimal> values) {
            addCriterion("poe_return_qty in", values, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyNotIn(List<BigDecimal> values) {
            addCriterion("poe_return_qty not in", values, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poe_return_qty between", value1, value2, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andPoeReturnQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poe_return_qty not between", value1, value2, "poeReturnQty");
            return (Criteria) this;
        }

        public Criteria andERemarkIsNull() {
            addCriterion("e_remark is null");
            return (Criteria) this;
        }

        public Criteria andERemarkIsNotNull() {
            addCriterion("e_remark is not null");
            return (Criteria) this;
        }

        public Criteria andERemarkEqualTo(String value) {
            addCriterion("e_remark =", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotEqualTo(String value) {
            addCriterion("e_remark <>", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkGreaterThan(String value) {
            addCriterion("e_remark >", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkGreaterThanOrEqualTo(String value) {
            addCriterion("e_remark >=", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkLessThan(String value) {
            addCriterion("e_remark <", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkLessThanOrEqualTo(String value) {
            addCriterion("e_remark <=", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkLike(String value) {
            addCriterion("e_remark like", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotLike(String value) {
            addCriterion("e_remark not like", value, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkIn(List<String> values) {
            addCriterion("e_remark in", values, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotIn(List<String> values) {
            addCriterion("e_remark not in", values, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkBetween(String value1, String value2) {
            addCriterion("e_remark between", value1, value2, "eRemark");
            return (Criteria) this;
        }

        public Criteria andERemarkNotBetween(String value1, String value2) {
            addCriterion("e_remark not between", value1, value2, "eRemark");
            return (Criteria) this;
        }

        public Criteria andRowClosedIsNull() {
            addCriterion("row_closed is null");
            return (Criteria) this;
        }

        public Criteria andRowClosedIsNotNull() {
            addCriterion("row_closed is not null");
            return (Criteria) this;
        }

        public Criteria andRowClosedEqualTo(Integer value) {
            addCriterion("row_closed =", value, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedNotEqualTo(Integer value) {
            addCriterion("row_closed <>", value, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedGreaterThan(Integer value) {
            addCriterion("row_closed >", value, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedGreaterThanOrEqualTo(Integer value) {
            addCriterion("row_closed >=", value, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedLessThan(Integer value) {
            addCriterion("row_closed <", value, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedLessThanOrEqualTo(Integer value) {
            addCriterion("row_closed <=", value, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedIn(List<Integer> values) {
            addCriterion("row_closed in", values, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedNotIn(List<Integer> values) {
            addCriterion("row_closed not in", values, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedBetween(Integer value1, Integer value2) {
            addCriterion("row_closed between", value1, value2, "rowClosed");
            return (Criteria) this;
        }

        public Criteria andRowClosedNotBetween(Integer value1, Integer value2) {
            addCriterion("row_closed not between", value1, value2, "rowClosed");
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
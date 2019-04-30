package com.dt.user.mapper.FinancialImportMapper;

import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.provider.FinancialSalesBalanceProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FinancialSalesBalanceMapper {
    /**
     * 插入财务数据
     *
     * @return
     */
    @InsertProvider(type = FinancialSalesBalanceProvider.class, method = "addInfo")
    int addInfo(@Param("fsbList") List<FinancialSalesBalance> fsbList, @Param("tbId") Integer menuId);
//    /**
//     *  单条sql 拼接查询财务
//     */
//    @Select(" SELECT\n" +
//            "  `balance_id`,\n" +
//            "  `years`,\n" +
//            "  `pediod`,\n" +
//            "  `date`,\n" +
//            "  `shop_id`,\n" +
//            "  `site_id`,\n" +
//            "  `settlement_id`,\n" +
//            "  `payment_type_id`,\n" +
//            "  `type`,\n" +
//            "  `order_id`,\n" +
//            "  `financial_sku`,\n" +
//            "  `sku_id`,\n" +
//            "  `description`,\n" +
//            "  `o_quantity`,\n" +
//            "  `quantity`,\n" +
//            "  `refund_quantity`,\n" +
//            "  `order_qty`,\n" +
//            "  `adjustment_qty`,\n" +
//            "  `marketplace`,\n" +
//            "  `fulfillment`,\n" +
//            "  `city`,\n" +
//            "  `state`,\n" +
//            "  `postal`,\n" +
//            "  `sales`,\n" +
//            "  `sale_price`,\n" +
//            "  `pre_sale_price`,\n" +
//            "  `std_sale_price`,\n" +
//            "  `new_shipping_credits`,\n" +
//            "  `shipping_credits`,\n" +
//            "  `giftwrap_credits`,\n" +
//            "  `promotional_rebates`,\n" +
//            "  `sales_tax`,\n" +
//            "  `marketplace_facilitator_tax`,\n" +
//            "  `low_value_goods`,\n" +
//            "  `point_fee`,\n" +
//            "  `selling_fees`,\n" +
//            "  `fba_fee`,\n" +
//            "  `other_transaction_fees`,\n" +
//            "  `other`,\n" +
//            "  `new_other`,\n" +
//            "  `total`,\n" +
//            "  `service_fee`,\n" +
//            "  `transfer`,\n" +
//            "  `adjustment`,\n" +
//            "  `new_promotional_rebates`,\n" +
//            "  `new_shipping_fba`,\n" +
//            "  `std_product_sales`,\n" +
//            "  `std_sales_original`,\n" +
//            "  `std_sales_add`,\n" +
//            "  `std_sales_minus`,\n" +
//            "  `std_fba`,\n" +
//            "  `std_fbas`,\n" +
//            "  `std_fba_original`,\n" +
//            "  `lightning_deal_fee`,\n" +
//            "  `fba_inventory_fee`,\n" +
//            "  `vat`,\n" +
//            "  `sales_for_tax`,\n" +
//            "  `service_fee_tax`,\n" +
//            "  `remark`,\n" +
//            "  `status`,\n" +
//            "  `create_date`,\n" +
//            "  `create_user`,\n" +
//            "  `modify_date`,\n" +
//            "  `modify_user`,\n" +
//            "  `audit_date`,\n" +
//            "  `audit_user`,\n" +
//            "  `recording_id`,\n" +
//            "  `version`,\n" +
//            "  `del_or_not`\n" +
//            "FROM `financial_sales_amazon_balance` LIMIT 0,10")
//    List<FinancialSalesBalance> s();

    /**
     * 查询财务 数据
     */
    @SelectProvider(type = FinancialSalesBalanceProvider.class, method = "getFbsInfo")
    List<FinancialSalesBalance> findByListFbs(FinancialSalesBalance fsb);

    /**
     * 自定义mybatis count
     *
     * @return
     */
    @Select("SELECT COUNT(0) FROM `financial_sales_amazon_balance`")
    Long findByListFbs_COUNT();


}

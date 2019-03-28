package com.dt.user.provider;


import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

public class FinancialSalesBalanceProvider {

    @SuppressWarnings("unchecked")
    public String addInfo(Map<String, Object> infoMap) {
        List<FinancialSalesBalance> fsbList = (List<FinancialSalesBalance>) infoMap.get("fsbList");
        Integer tbId = (Integer) infoMap.get("tbId");
        String db = "financial_sales_amazon_balance";
        if (tbId == Constants.FINANCE_ID_YY) {
            db = "sales_amazon_fba_balance";
        }
        // sql前缀
        String prefix = "insert into " + db +
                "(`date`,`shop_id`,`site_id`,`settlemen_id`," +
                "`payment_type_id`,`type`,`order_id`,`sku`," +
                "`sku_id`,`description`,`o_quantity`,`quantity`," +
                "`refund_quantity`,`order_qty`,`adjustment_qty`,`marketplace`," +
                "`fulfillment`,`city`,`state`,`postal`," +
                "`sales`,`sale_price`,`pre_sale_price`,`std_sale_price`," +
                "`new_shipping_credits`,`shipping_credits`,`giftwrap_credits`,`promotional_rebates`," +
                "`sales_tax`,`marketplace_facilitator_tax`,`selling_fees`,`fba_fee`," +
                "`other_transaction_fees`, `other`,`total`,`service_fee`," +
                "`transfer`,`adjustment`,`new_promotional_rebates`,`new_shipping_fba`," +
                "`std_product_sales`,`std_sales_original`,`std_sales_add`,`std_sales_minus`," +
                "`std_fba`,`std_fbas`,`std_fba_original`,`lightning_deal_fee`," +
                "`fba_inventory_fee`,`point_fee`,`low_value_goods`,`create_date`,`create_user`," +
                "`recording_id`)" +
                " values";
        // 保存sql后缀
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < fsbList.size(); i++) {
            FinancialSalesBalance fsb = fsbList.get(i);
            // 构建sql后缀
            sb.append("(").append(fsb.getDate()).append(",").append(fsb.getShopId()).append(",").append(fsb.getSiteId()).append(",");
            //#
            StrUtils.appBuider(sb, fsb.getSettlemenId());
            sb.append(",");
            sb.append(fsb.getPaymentTypeId());
            //#
            sb.append(",");
            StrUtils.appBuider(sb, fsb.getType());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getOrderId());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getSku());
            sb.append(",");
            sb.append(fsb.getSkuId());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getDescription());
            sb.append(",");
            sb.append(fsb.getoQuantity()).append(",").append(fsb.getQuantity()).append(",").append(fsb.getRefundQuantity()).append(",").append(fsb.getOrderQty()).append(",").append(fsb.getAdjustmentQty()).append(",");
            //#
            StrUtils.appBuider(sb, fsb.getMarketplace());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getFulfillment());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getCity());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getState());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getPostal());
            sb.append(",");
            sb.append(fsb.getSales()).append(",").append(fsb.getSalePrice()).
                    append(",").append(fsb.getPreSalePrice()).append(",").
                    append(fsb.getStdSalePrice()).append(",").
                    append(fsb.getNewShippingCredits()).append(",").
                    append(fsb.getShippingCredits()).append(",").
                    append(fsb.getGiftwrapCredits()).append(",").
                    append(fsb.getPromotionalRebates()).append(",").
                    append(fsb.getSalesTax()).append(",").append(fsb.getMarketplaceFacilitatorTax()).append(",").
                    append(fsb.getSellingFees()).append(",").append(fsb.getFbaFee()).append(",").append(fsb.getOtherTransactionFees()).
                    append(",").append(fsb.getOther()).append(",").append(fsb.getTotal()).append(",").append(fsb.getServiceFee()).append(",").
                    append(fsb.getTransfer()).append(",").append(fsb.getAdjustment()).append(",").append(fsb.getNewPromotionalRebates()).
                    append(",").append(fsb.getNewShippingFba()).append(",").append(fsb.getStdProductSales()).append(",").
                    append(fsb.getStdSalesOriginal()).append(",").append(fsb.getStdSalesAdd()).append(",").append(fsb.getStdSalesMinus()).
                    append(",").append(fsb.getStdFba()).append(",").append(fsb.getStdFbas()).append(",").append(fsb.getStdFbaOriginal()).
                    append(",").append(fsb.getLightningDealFee()).append(",").append(fsb.getFbaInventoryFee()).append(",");
            sb.append(+fsb.getPointFee()).append(",").append(fsb.getLowValueGoods());
            SpliceSqlStore.set(sb, fsb);
        }
        // 构建完整sql
        return sb.toString().substring(0, sb.length() - 1);
    }
}

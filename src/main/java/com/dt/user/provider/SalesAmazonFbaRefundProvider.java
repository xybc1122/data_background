package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaRefund;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaRefundProvider {


    @SuppressWarnings("unchecked")
    public String addRefund(Map<String, Object> mapStr) {
        List<SalesAmazonFbaRefund> refundList = (List<SalesAmazonFbaRefund>) mapStr.get("refundList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_refund`" +
                "(`date`,`purchase_date`,`shop_id`,`site_id`,`order_id`,`sku`,`s_asin`,\n" +
                "`fnsku`,`sku_id`,`p_name`,`quantity`,`fc`,`aw_id`,`detailed_disposition`,\n" +
                "`reason`,`refund_staus`,`license_plate_number`,`customer_remarks`," +
                "`create_date`,`create_user`,`recordingId`)values");
        for (SalesAmazonFbaRefund refund : refundList) {
            sb.append("(" + refund.getDate() + "," + refund.getPurchaseDate() + ","
                    + refund.getShopId() + "," + refund.getSiteId());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getOrderId());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getSku());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getsAsin());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getFnsku());
            sb.append(",").append(refund.getSkuId()).append(",");

            StrUtils.appBuider(sb, refund.getpName());

            sb.append(",").append(refund.getQuantity()).append(",");

            StrUtils.appBuider(sb, refund.getFc());

            sb.append(",").append(refund.getAwId()).append(",");
            StrUtils.appBuider(sb, refund.getDetailedDisposition());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getReason());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getRefundStaus());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getLicensePlateNumber());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getCustomerRemarks());
            sb.append(",");
            SpliceSqlStore.set(sb, refund);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}

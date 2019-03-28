package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaReceivestock;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaReceivestockProvider {


    @SuppressWarnings("unchecked")
    public String addReceives(Map<String, Object> mapStr) {
        List<SalesAmazonFbaReceivestock> receivesList = (List<SalesAmazonFbaReceivestock>) mapStr.get("receivesList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO`sales_amazon_fba_receivestock`\n" +
                "(`date`,`shop_id`,`site_id`,`fba_shipment_id`,`sku`,`fnsku`,\n" +
                "`sku_id`,`ProductName`,`quantity`,`fc`,`aw_id`,`create_date`,`create_user`,`recordingId`)values");
        for (SalesAmazonFbaReceivestock receives : receivesList) {
            sb.append("(").append(receives.getDate()).append(",").append(receives.getShopId()).append(",").append(receives.getSiteId()).append(",");
            StrUtils.appBuider(sb, receives.getFbaShipmentId());
            sb.append(",");
            StrUtils.appBuider(sb, receives.getSku());
            sb.append(",");
            StrUtils.appBuider(sb, receives.getFnsku());
            sb.append(",");
            sb.append(receives.getSkuId()).append(",");
            StrUtils.appBuider(sb, receives.getProductName());
            sb.append(",");
            sb.append(receives.getQuantity()).append(",");
            StrUtils.appBuider(sb, receives.getFc());
            sb.append(",");
            sb.append(receives.getAwId()).append(",");
            SpliceSqlStore.set(sb, receives);
        }
        String sql = sb.toString().substring(0, sb.length() - 1);
        return sql;
    }
}


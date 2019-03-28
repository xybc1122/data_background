package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaInventoryEnd;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaInventoryEndProvider {

    @SuppressWarnings("unchecked")
    public String addEndList(Map<String, Object> mapStr) {
        List<SalesAmazonFbaInventoryEnd> endList = (List<SalesAmazonFbaInventoryEnd>) mapStr.get("endList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_Inventory_End`\n" +
                "(`date`,`shop_id`,`site_id`,`sku`,`fnsku`,`sku_id`,\n" +
                "`ProductName`,`quantity`,`fc`,`aw_id`,`disposition`,`country`,\n" +
                "`create_date`,`create_user`,`recordingId`)values");
        for (SalesAmazonFbaInventoryEnd end : endList) {
            sb.append("(").append(end.getDate()).append(",").append(end.getShopId()).append(",").append(end.getSiteId()).append(",");
            StrUtils.appBuider(sb, end.getSku());
            sb.append(",");
            StrUtils.appBuider(sb, end.getFnsku());
            sb.append(",").append(end.getSkuId()).append(",");
            StrUtils.appBuider(sb, end.getProductName());
            sb.append(",").append(end.getQuantity()).append(",");
            StrUtils.appBuider(sb, end.getFc());
            sb.append(",").append(end.getAwId()).append(",");
            StrUtils.appBuider(sb, end.getDisposition());
            sb.append(",");
            StrUtils.appBuider(sb, end.getCountry());
            sb.append(",");
            SpliceSqlStore.set(sb, end);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}

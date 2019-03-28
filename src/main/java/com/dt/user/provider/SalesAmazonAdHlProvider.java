package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdHl;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

public class SalesAmazonAdHlProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdHl(Map<String, Object> mapHl) {
        List<SalesAmazonAdHl> hlList = (List<SalesAmazonAdHl>) mapHl.get("hlList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_ad_hl`\n" +
                "(`date`,`shop_id`,`site_id`,`campaign_name`,`impressions`,`clicks`,`ctr`,`cpc`,\n" +
                " `spend`,`acos`,`roas`,`total_sales`,`total_orders`,`total_units`,`conversion_rate`," +
                "`create_date`, `create_user`, `recording_id`) values");
        for (SalesAmazonAdHl hl : hlList) {
            sb.append("(").append(hl.getDate()).append(",").append(hl.getShopId()).append(",").append(hl.getSiteId());
            sb.append(",");
            StrUtils.appBuider(sb, hl.getCampaignName());
            sb.append(",").append(hl.getImpressions()).append(",").append(hl.getClicks()).append(",");
            sb.append(hl.getCtr()).append(",").append(hl.getCpc()).append(",").append(hl.getSpend()).append(",").append(hl.getAcos()).append(",").append(hl.getRoas()).append(",").append(hl.getTotalSales()).append(",").append(hl.getTotalOrders()).append(",").append(hl.getTotalUnits()).append(",").append(hl.getConversionRate()).append(",");
            //通用set 拼接
            SpliceSqlStore.set(sb, hl);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}

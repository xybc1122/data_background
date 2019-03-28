package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonFbaBusinessreport;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaBusinessreporProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdBus(Map<String, Object> mapStr) {
        List<SalesAmazonFbaBusinessreport> busList = (List<SalesAmazonFbaBusinessreport>) mapStr.get("busList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO`sales_amazon_fba_businessreport`\n" +
                "(`date`,`shop_id`,`site_id`,`sku`,`sku_id`, `f_asin`, `s_asin`, `p_name`, `sessions_visit`,\n" +
                "`sessions_per`,`page_views`,`buy_box_per`,`order`,`order_b2b`, `sales`,`sales_b2b`,`order_items`,`order_items_b2b`," +
                "``create_date`,`create_user`,`recording_id`)values");
        for (SalesAmazonFbaBusinessreport bus : busList) {
            sb.append("(").append(bus.getDate()).append(",").append(bus.getShopId()).append(",").append(bus.getSiteId()).append(",");
            StrUtils.appBuider(sb, bus.getSku());
            sb.append(",").append(bus.getSkuId()).append(",");
            StrUtils.appBuider(sb, bus.getfAsin());
            sb.append(",");
            StrUtils.appBuider(sb, bus.getsAsin());
            sb.append(",");
            StrUtils.appBuider(sb, bus.getpName());
            sb.append(",");
            sb.append(bus.getSessionsVisit()).append(",").append(bus.getSessionsPer()).append(",").append(bus.getPageViews()).append(",").append(bus.getBuyBoxPer()).append(",").append(bus.getOrder()).append(",").append(bus.getOrderB2B()).append(",").append(bus.getSales()).append(",").append(bus.getSalesB2B()).append(",").append(bus.getOrderItems()).append(",").append(bus.getOrderItemsB2B()).append(",");
            SpliceSqlStore.set(sb, bus);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}

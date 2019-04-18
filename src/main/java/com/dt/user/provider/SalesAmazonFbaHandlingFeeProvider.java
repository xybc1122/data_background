package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaHandlingFee;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SalesAmazonFbaHandlingFeeProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/18 9:46
 **/
public class SalesAmazonFbaHandlingFeeProvider {

    public String addAmazonHandLFee(Map<String, Object> mapStr) {
        List<SalesAmazonFbaHandlingFee> hLFeeList = (List<SalesAmazonFbaHandlingFee>) mapStr.get("hLFeeList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_handlingfee`\n" +
                "(`shop_id`,`site_id`,`sku_id`, `std_fba_hd_fee`,\n" +
                "`effective_date`,`create_date`,`create_user`,`recording_id`) values");
        for (SalesAmazonFbaHandlingFee hLF : hLFeeList) {
            sb.append("(").append(hLF.getShopId()).append(",").append(hLF.getSiteId()).append(",").
                    append(hLF.getSkuId()).append(",").append(hLF.getStdFbaHdFee()).append(",")
                    .append(hLF.getEffectiveDate()).append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, hLF);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}

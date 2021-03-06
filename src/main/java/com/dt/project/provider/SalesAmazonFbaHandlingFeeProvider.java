package com.dt.project.provider;

import com.alibaba.fastjson.JSONArray;
import com.dt.project.model.salesAmazon.SalesAmazonFbaHandlingFee;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

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

    public String selectByHFee(SalesAmazonFbaHandlingFee lFee) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "hlFee";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`hd_id`, `std_fba_hd_fee`,`effective_date`," +
                "" + ProviderSqlStore.statusV(alias) + "" +
                "FROM `sales_amazon_fba_handlingfee` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        ProviderSqlStore.joinTable(sql, alias);
        if (StringUtils.isNotBlank(lFee.getSku()))
            sql.WHERE("POSITION('" + lFee.getSku() + "' IN ps.`sku`)");
        if (lFee.getEffectiveDates() != null && (lFee.getEffectiveDates().size() > 0)) {
            sql.WHERE("date  " + lFee.getEffectiveDates().get(0) + " AND " + lFee.getEffectiveDates().get(1) + "");
        }
        FieldStore.query(lFee.getClass(), lFee.getJsonArr(), lFee, sql,alias);
//        FieldStore.query(lFee.getClass(), null, lFee, sql);


        ProviderSqlStore.selectUploadStatus(sql, lFee, alias);
        return sql.toString();
    }

}

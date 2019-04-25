package com.dt.user.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName BasicPublicShopProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/25 12:51
 **/
public class BasicPublicShopProvider {

    public String selectShopInfo(Map<String, String> sMap) {
        SQL sql = new SQL();
        sql.SELECT("`shop_id`,`shop_name`,`shop_short_code` from `basic_public_shop` AS s");
        String rid = sMap.get("rId");
        //如果不是空的
        if (StringUtils.isNotBlank(rid)) {
            sql.INNER_JOIN("`system_shop_role` AS pr ON pr.s_id= s.shop_id");
            sql.WHERE("r_id in (#{rId})");

        }
        return sql.toString();
    }
}

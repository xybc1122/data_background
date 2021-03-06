package com.dt.project.provider;

import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName BasicPublicAreaProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/26 9:24
 **/
public class BasicPublicAreaProvider {

    public String selectReg(Map<String, String> reMap) {
        String rids = reMap.get("rid");
        SQL sql = new SQL();
        String alias = "a";
        //如果是null 直接返回 这里是给admin用户查询的接口
        if (StringUtils.isBlank(rids)) {
            sql.SELECT(" `area_id`,`area_name`,`area_short_name_eng` from  basic_public_area AS " + alias + "");
            return sql.toString();
        }
        sql.SELECT(" GROUP_CONCAT(ar.`ar_id`) AS arIds,`area_id`,`area_name`,`area_short_name_eng` from  basic_public_area AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_area_role` AS ar ON ar.`a_id` = a.`area_id`");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "ar.`r_id`") + " GROUP BY "+alias+".area_id";
    }


    public String selectAreaAndSite(Map<String, String> reMap) {
        String rids = reMap.get("rid");
        SQL sql = new SQL();
        String alias = "a";
        sql.SELECT(" a.area_id,a.area_name,cs.`site_id`,cs.`site_name` FROM `basic_public_area` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_area_role` AS ar ON ar.a_id = a.area_id");
        sql.LEFT_OUTER_JOIN("`basic_public_area_role_site` AS ars ON ars.`ar_id` = ar.ar_id");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = ars.`se_id`");
        return sql.toString() + " WHERE " + StrUtils.in(rids, "ar.r_id") + " GROUP BY ar.a_id";
    }
}

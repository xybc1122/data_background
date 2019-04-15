package com.dt.user.store;

import com.dt.user.model.ParentUploadInfo;
import com.dt.user.toos.Constant;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName AppendSqlStore 拼接sql 商店
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/27 8:57
 **/
public class AppendSqlStore {


    /**
     * 通用拼接set
     *
     * @param sb
     * @param p
     */
    public static void set(StringBuilder sb, ParentUploadInfo p) {
        sb.append(p.getCreateDate()).append(",");
        StrUtils.appBuider(sb, p.getCreateUser());
        sb.append(",");
        sb.append(p.getRecordingId()).append("),");
    }

    /**
     * 封装 where IN查询条件
     *
     * @param k   实体的字段
     * @param v   数据库的字段
     * @param sql
     */
    public static void sqlWhere(Object k, String v, SQL sql, String status) {
        if (k != null) {
            if (status.equals(Constants.SELECT)) {
                if (k instanceof String) {
                    sql.WHERE("POSITION('" + k + "' IN " + v + ")");
                } else {
                    sql.WHERE(v + "=" + k);
                }
            } else if (status.equals(Constants.UP)) {
                if (k instanceof String) {
                    sql.SET(v + "=" + "'" + k + "'");
                } else {
                    sql.SET(v + "=" + k);
                }
            }
        }
    }


    /**
     * 设置sql 对应的表头
     *
     * @param p
     * @param v1
     * @param v2
     * @return
     */
    public static String setSqlTable(ParentUploadInfo p, String v1, String v2) {
        String sqlTable = v1;
        if (p.getSqlMode() != null && p.getSqlMode() == 1) {
            sqlTable = v2;
        }
        return sqlTable;
    }
}
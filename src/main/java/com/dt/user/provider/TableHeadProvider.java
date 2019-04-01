package com.dt.user.provider;

import com.dt.user.exception.LsException;
import com.dt.user.model.TableHead;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TableHeadProvider {


    @SuppressWarnings("unchecked")
    public String showTableHead(Map<String, Object> mapHead) {
        List<Integer> ids = (List<Integer>) mapHead.get("menuIds");
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT GROUP_CONCAT(DISTINCT t.head_name)as headName," +
                "GROUP_CONCAT(DISTINCT t.id)as ids," +
                "GROUP_CONCAT(DISTINCT m.`menu_id`)AS menuId,m.`m_name` \n" +
                "FROM `system_user_menu` AS m \n" +
                "LEFT JOIN `system_user_menu_field` AS tf ON tf.m_id=m.menu_id \n" +
                "LEFT JOIN `system_user_table_head` AS t ON t.id=tf.field_id  \n" +
                "WHERE m.`menu_id` in (");
        for (Integer id : ids) {
            if (ids.indexOf(id) > 0)
                sql.append(",");
            sql.append("'").append(id).append("'");
        }
        sql.append(")\n");
        sql.append("GROUP BY m.`menu_id`");
        return sql.toString();
    }

    /**
     * 新增字段
     *
     * @return
     */
    public String insertHead(TableHead tableHead) {
        return new SQL() {{
            INSERT_INTO("`system_user_table_head`");
            if (StringUtils.isBlank(tableHead.getHeadName())) {
                throw new LsException("headName参数不能为空");
            }
            if (StringUtils.isBlank(tableHead.getTopType())) {
                throw new LsException("TopType参数不能为空");
            }
            if (StringUtils.isBlank(tableHead.getMenuId())) {
                throw new LsException("menuId参数不能为空");
            }
            VALUES("`head_name`,`menu_id`,`top_type`,`top_order`,`is_fixed`,`input_type`," +
                    "`is_reference`", "#{headName},#{menuId},#{topType},#{topOrder},#{isFixed},#{inputType},#{isReference}");
        }}.toString();
    }

    /**
     * 更新/修改head字段信息
     *
     * @return
     */
    public String upHeadInfo(TableHead tableHead) {
        return new SQL() {{
            UPDATE("`system_user_table_head`");
            if (StringUtils.isNotBlank(tableHead.getHeadName())) {
                SET("head_name=#{headName}");
            }
            if (StringUtils.isNotBlank(tableHead.getMenuId())) {
                SET("menu_id=#{menuId}");
            }
            if (StringUtils.isNotBlank(tableHead.getTopType())) {
                SET("top_type=#{topType}");
            }
            if (StringUtils.isNotBlank(tableHead.getTopOrder())) {
                SET("top_order=#{topOrder}");
            }
            if (tableHead.getFixed() != null) {
                SET("is_fixed=#{isFixed}");
            }
            if (tableHead.getInputType() != null) {
                SET("input_type=#{inputType}");
            }
            if (tableHead.getReference() != null) {
                SET("is_reference=#{isReference}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }

    /**
     * 更新排序
     *
     * @return
     */
    public String upHeadSort(Map<String, Object> mapHead) {
        return new SQL() {{
            String[] strTop = (String[]) mapHead.get("newTopOrder");
            Long id = (Long) mapHead.get("id");
            UPDATE("`system_user_table_head`");
            //说明只有一个
            if (strTop.length == 1) {
                SET("top_order=" + strTop[0]);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < strTop.length; i++) {
                    if (strTop[i] == null) {
                        sb.append(" ");
                    } else {
                        sb.append(strTop[i]);
                    }
                    sb.append(",");
                }
                SET("top_order=" + "'" + sb.toString().substring(0, sb.length() - 1) + "'");
            }
            WHERE("id=" + id);
        }}.toString();

    }
}

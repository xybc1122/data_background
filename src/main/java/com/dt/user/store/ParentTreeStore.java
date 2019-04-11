package com.dt.user.store;

import com.dt.user.model.ParentTree;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName ParentTreeStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 13:51
 **/
public class ParentTreeStore {

    public static void setTree(ParentTree t, SQL sql) {
        //名称
        if (StringUtils.isNotBlank(t.getTreeName())) {
            sql.SET("warehouse_name=#{treeName}");
        }
        //父ID
        if (t.getParentId() != null) {
            sql.SET("parent_id=#{parentId}");
        }
        //编号
        if (t.getNumber() != null) {
            sql.SET("number=#{number}");
        }
        //路径
        if (StringUtils.isNotBlank(t.getPath())) {
            sql.SET("path=#{path}");
        }
        //是否是父节点
        if (t.getParentNodeIs() != null) {
            sql.SET("parent_node_is=#{parentNodeIs}");
        }
        if (t.getStatusId() != null) {
            sql.SET("status_id=#{statusId}");
        }
        Integer version = t.getVersion();
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
    }
}

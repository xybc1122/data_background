package com.dt.project.store;

import com.dt.project.model.parent.ParentTree;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName ParentTreeStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 13:51
 **/
public class ParentTreeStore {

    public static void setTree(ParentTree t, SQL sql) {
        //父ID
        AppendSqlStore.sqlWhere(t.getParentId(), "parent_id", sql, Constants.UP,null);
        //编号
        AppendSqlStore.sqlWhere(t.getNumber(), "number", sql, Constants.UP,null);
        //路径
        AppendSqlStore.sqlWhere(t.getPath(), "path", sql, Constants.UP,null);
        //是否是父节点
        AppendSqlStore.sqlWhere(t.getParentNodeIs(), "parent_node_is", sql, Constants.UP,null);
        //状态ID
        AppendSqlStore.sqlWhere(t.getStatusId(), "status_id", sql, Constants.UP,null);
        Integer version = t.getVersion();
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
    }
}

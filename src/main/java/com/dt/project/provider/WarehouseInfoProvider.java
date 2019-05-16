package com.dt.project.provider;

import com.dt.project.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ParentTreeStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName WarehouseInfoProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 9:33
 **/
public class WarehouseInfoProvider {


    public String upWarehousePro(BasicPublicWarehouse warehouse) {
        SQL sql = new SQL();
        sql.UPDATE("`basic_public_warehouse`");
        //仓库地址
        AppendSqlStore.sqlWhere(warehouse.getWarehouseAddress(), "warehouse_address", sql, Constants.UP);
        //名称
        AppendSqlStore.sqlWhere(warehouse.getTreeName(), "warehouse_name", sql, Constants.UP);

        ParentTreeStore.setTree(warehouse, sql);
        sql.WHERE("warehouse_id=#{treeId}");
        return sql.toString();
    }

    public String delWarehousePro(Map<String, Object> mapDel) {
        String thisIds = mapDel.get("thisIds").toString();
        return StrUtils.updateSql(thisIds,
                "UPDATE `basic_public_warehouse`\n" + "SET `del_or_not` = ", "1", null, "warehouse_id");
    }
}

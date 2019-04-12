package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.ParentTree;
import com.dt.user.store.ParentTreeStore;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isNotBlank(warehouse.getWarehouseAddress())) {
            sql.SET("warehouse_address=#{warehouseAddress}");
        }
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

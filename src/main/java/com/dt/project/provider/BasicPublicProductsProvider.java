package com.dt.project.provider;

import com.dt.project.model.basePublic.BasicPublicProducts;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ParentTreeStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName BasicPublicProductsProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/16 9:33
 **/
public class BasicPublicProductsProvider {


    public String upProductsPro(BasicPublicProducts products) {

        SQL sql = new SQL();
        sql.UPDATE("`basic_public_products`");
        //类目名称
        AppendSqlStore.sqlWhere(products.getTreeName(), "products_name", sql, Constants.UP);
        ParentTreeStore.setTree(products, sql);
        sql.WHERE("products_id=#{treeId}");
        return sql.toString();
    }


    public String delProductsPro(Map<String, Object> mapDel) {
        String thisIds = mapDel.get("thisIds").toString();
        return StrUtils.updateSql(thisIds,
                "UPDATE `basic_public_products`\n" + "SET `del_or_not` = ", "1", null, "products_id");
    }
}

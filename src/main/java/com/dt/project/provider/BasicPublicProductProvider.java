package com.dt.project.provider;

import com.dt.project.model.dto.ProductDto;
import com.dt.project.model.basePublic.BasicPublicProduct;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicProductProvider {


    public String findProduct(ProductDto productDto) {
        SQL sql = new SQL();
        String alias = "p";
        sql.SELECT("p.version,p.`product_id`,p.`product_code`,p.`product_name`,p.`model`,\n" +
                " p.`qty_per_box`,p.`product_sku`,p.`products_id`,\n" +
                " p.`length_cm`,p.`width_cm`,p.`height_cm`,\n" +
                " p.`gw_kg`,p.`nw_kg`,p.`volume_m3`,p.`length_in`,\n" +
                " p.`width_in`,p.`height_in`,p.`volume_cuft`,p.`made_in`,\n" +
                " p.`hs_code_id`,p.`status_id`,ia.item_attribute_name,it.item_typ_name,ps.products_name,hc.hs_code, u.unit_name\n" +
                "FROM `basic_public_product` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_unit` AS u ON u.unit_id=p.`unit_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_item_attribute` AS ia ON ia.item_attribute_id = p.`item_attribute_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_item_type` AS it ON it.`item_typ_id` = p.`item_typ_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_products` AS ps ON ps.`products_id`=p.`products_id`");
        sql.LEFT_OUTER_JOIN("`basic_export_hs_code` AS hc ON hc.`hs_code_id`=p.`hs_code_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(productDto.getSystemLogStatus(), alias, sql);
        //产品代码
        AppendSqlStore.sqlWhere(productDto.getProductCode(), alias + ".product_code", sql, Constants.SELECT,alias);

        //产品名称
        AppendSqlStore.sqlWhere(productDto.getProductName(), alias + ".product_name", sql, Constants.SELECT,alias);
        //规格型号
        AppendSqlStore.sqlWhere(productDto.getModel(), alias + ".model", sql, Constants.SELECT,alias);
        //每箱数量
        AppendSqlStore.sqlWhere(productDto.getQtyPerBox(), alias + ".qty_per_box", sql, Constants.SELECT,alias);
        //产品SKU
        AppendSqlStore.sqlWhere(productDto.getProductSku(), "product_sku", sql, Constants.SELECT,alias);

        //长度CM
        AppendSqlStore.sqlWhere(productDto.getLengthCm(), alias + ".length_cm", sql, Constants.SELECT,alias);
        //宽度CM
        AppendSqlStore.sqlWhere(productDto.getWidthCm(), alias + ".width_cm", sql, Constants.SELECT,alias);
        //高度CM
        AppendSqlStore.sqlWhere(productDto.getHeightCm(), alias + ".height_cm", sql, Constants.SELECT,alias);
        //毛重KG
        AppendSqlStore.sqlWhere(productDto.getGwKg(), alias + ".gw_kg", sql, Constants.SELECT,alias);
        //净重
        AppendSqlStore.sqlWhere(productDto.getNwKg(), alias + ".nw_kg", sql, Constants.SELECT,alias);
        //体积m
        AppendSqlStore.sqlWhere(productDto.getVolumeM3(), alias + ".volume_m3", sql, Constants.SELECT,alias);
        //长度英寸
        AppendSqlStore.sqlWhere(productDto.getLengthIn(), alias + ".length_in", sql, Constants.SELECT,alias);
        //宽度英寸
        AppendSqlStore.sqlWhere(productDto.getQtyPerBox(), alias + ".width_in", sql, Constants.SELECT,alias);
        //高度英寸
        AppendSqlStore.sqlWhere(productDto.getHeightIn(), alias + ".height_in", sql, Constants.SELECT,alias);
        //体积立方英尺
        AppendSqlStore.sqlWhere(productDto.getVolumeCuft(), alias + ".volume_cuft", sql, Constants.SELECT,alias);
        //产地
        AppendSqlStore.sqlWhere(productDto.getMadeIn(), "p.made_in", sql, Constants.SELECT,alias);

        //计量 单位名称
        AppendSqlStore.sqlWhere(productDto.getUnitName(), "u.unit_name", sql, Constants.SELECT,alias);

        //物料类型 名称
        AppendSqlStore.sqlWhere(productDto.getItemTypName(), "it.item_typ_name", sql, Constants.SELECT,alias);
        // 物料属性名称
        AppendSqlStore.sqlWhere(productDto.getItemAttributeName(), "ia.item_attribute_name", sql, Constants.SELECT,alias);
        // 类目名称
        AppendSqlStore.sqlWhere(productDto.getProductsName(), "ps.products_name", sql, Constants.SELECT,alias);
        //  HS Code
        AppendSqlStore.sqlWhere(productDto.getHsCode(), "hc.hs_code", sql, Constants.SELECT,alias);
        return sql.toString();
    }


    public String upProductPro(BasicPublicProduct product) {
        SQL sql = new SQL();
        sql.UPDATE("`basic_public_product`");
        //产品代码
        AppendSqlStore.sqlWhere(product.getProductCode(), "product_code", sql, Constants.UP,null);
        //产品名称
        AppendSqlStore.sqlWhere(product.getProductName(), "product_name", sql, Constants.UP,null);
        //规格型号
        AppendSqlStore.sqlWhere(product.getModel(), "model", sql, Constants.UP,null);
        //每箱数量
        AppendSqlStore.sqlWhere(product.getQtyPerBox(), "qty_per_box", sql, Constants.UP,null);
        //物料类型ID
        AppendSqlStore.sqlWhere(product.getItemTypId(), "item_typ_id", sql, Constants.UP,null);
        //物料属性ID
        AppendSqlStore.sqlWhere(product.getItemAttributeId(), "item_attribute_id", sql, Constants.UP,null);
        //产品SKU
        AppendSqlStore.sqlWhere(product.getProductSku(), "product_sku", sql, Constants.UP,null);
        //类目ID
        AppendSqlStore.sqlWhere(product.getProductsId(), "products_id", sql, Constants.UP,null);
        //长度CM
        AppendSqlStore.sqlWhere(product.getLengthCm(), "length_cm", sql, Constants.UP,null);
        //宽度CM
        AppendSqlStore.sqlWhere(product.getWidthCm(), "width_cm", sql, Constants.UP,null);
        //高度CM
        AppendSqlStore.sqlWhere(product.getHeightCm(), "height_cm", sql, Constants.UP,null);
        //毛重KG
        AppendSqlStore.sqlWhere(product.getGwKg(), "gw_kg", sql, Constants.UP,null);
        //净重
        AppendSqlStore.sqlWhere(product.getNwKg(), "nw_kg", sql, Constants.UP,null);
        //体积m
        AppendSqlStore.sqlWhere(product.getVolumeM3(), "volume_m3", sql, Constants.UP,null);
        //长度英寸
        AppendSqlStore.sqlWhere(product.getLengthIn(), "length_in", sql, Constants.UP,null);
        //宽度英寸
        AppendSqlStore.sqlWhere(product.getQtyPerBox(), "width_in", sql, Constants.UP,null);
        //高度英寸
        AppendSqlStore.sqlWhere(product.getHeightIn(), "height_in", sql, Constants.UP,null);
        //体积立方英尺
        AppendSqlStore.sqlWhere(product.getVolumeCuft(), "volume_cuft", sql, Constants.UP,null);
        //产地
        AppendSqlStore.sqlWhere(product.getMadeIn(), "made_in", sql, Constants.UP,null);
        //  HS Code
        AppendSqlStore.sqlWhere(product.getHsCodeId(), "hs_code_id", sql, Constants.UP,null);
        Integer version = product.getVersion();
        sql.SET("`version`=" + version + "+1");
        sql.WHERE("`version`=" + version);
        sql.WHERE("product_id=#{productId}");
        return sql.toString();
    }

    public String delProductPro(Map<String, Object> mapDel) {
        String thisIds = mapDel.get("thisIds").toString();
        return StrUtils.updateSql(thisIds,
                "UPDATE `basic_public_product`\n" + "SET `del_or_not` = ", "1", null, "product_id");
    }

}

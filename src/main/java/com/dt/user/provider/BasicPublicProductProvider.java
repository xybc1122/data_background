package com.dt.user.provider;

import com.dt.user.dto.ProductDto;
import com.dt.user.model.BasePublicModel.BasicPublicProduct;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicProductProvider {


    public String findProduct(ProductDto productDto) {
        SQL sql = new SQL();
        String Alias = "p";
        sql.SELECT("p.version,p.`product_id`,p.`product_code`,p.`product_name`,p.`model`,\n" +
                " p.`qty_per_box`,p.`product_sku`,p.`products_id`,\n" +
                " p.`length_cm`,p.`width_cm`,p.`height_cm`,\n" +
                " p.`gw_kg`,p.`nw_kg`,p.`volume_m3`,p.`length_in`,\n" +
                " p.`width_in`,p.`height_in`,p.`volume_cuft`,p.`made_in`,\n" +
                " p.`hs_code_id`,p.`status_id`,ia.item_attribute_name,it.item_typ_name,ps.products_name,hc.hs_code, u.unit_name\n" +
                "FROM `basic_public_product` AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_unit` AS u ON u.unit_id=p.`unit_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_item_attribute` AS ia ON ia.item_attribute_id = p.`item_attribute_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_item_type` AS it ON it.`item_typ_id` = p.`item_typ_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_products` AS ps ON ps.`products_id`=p.`products_id`");
        sql.LEFT_OUTER_JOIN("`basic_export_hs_code` AS hc ON hc.`hs_code_id`=p.`hs_code_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(productDto.getSystemLogStatus(), Alias, sql);
        //产品代码
        AppendSqlStore.sqlWhere(productDto.getProductCode(), Alias + ".product_code", sql, Constants.SELECT);

        //产品名称
        AppendSqlStore.sqlWhere(productDto.getProductName(), Alias + ".product_name", sql, Constants.SELECT);
        //规格型号
        AppendSqlStore.sqlWhere(productDto.getModel(), Alias + ".model", sql, Constants.SELECT);
        //每箱数量
        AppendSqlStore.sqlWhere(productDto.getQtyPerBox(), Alias + ".qty_per_box", sql, Constants.SELECT);
        //产品SKU
        AppendSqlStore.sqlWhere(productDto.getProductSku(), "product_sku", sql, Constants.SELECT);

        //长度CM
        AppendSqlStore.sqlWhere(productDto.getLengthCm(), Alias + ".length_cm", sql, Constants.SELECT);
        //宽度CM
        AppendSqlStore.sqlWhere(productDto.getWidthCm(), Alias + ".width_cm", sql, Constants.SELECT);
        //高度CM
        AppendSqlStore.sqlWhere(productDto.getHeightCm(), Alias + ".height_cm", sql, Constants.SELECT);
        //毛重KG
        AppendSqlStore.sqlWhere(productDto.getGwKg(), Alias + ".gw_kg", sql, Constants.SELECT);
        //净重
        AppendSqlStore.sqlWhere(productDto.getNwKg(), Alias + ".nw_kg", sql, Constants.SELECT);
        //体积m
        AppendSqlStore.sqlWhere(productDto.getVolumeM3(), Alias + ".volume_m3", sql, Constants.SELECT);
        //长度英寸
        AppendSqlStore.sqlWhere(productDto.getLengthIn(), Alias + ".length_in", sql, Constants.SELECT);
        //宽度英寸
        AppendSqlStore.sqlWhere(productDto.getQtyPerBox(), Alias + ".width_in", sql, Constants.SELECT);
        //高度英寸
        AppendSqlStore.sqlWhere(productDto.getHeightIn(), Alias + ".height_in", sql, Constants.SELECT);
        //体积立方英尺
        AppendSqlStore.sqlWhere(productDto.getVolumeCuft(), Alias + ".volume_cuft", sql, Constants.SELECT);
        //产地
        AppendSqlStore.sqlWhere(productDto.getMadeIn(), "p.made_in", sql, Constants.SELECT);

        //计量 单位名称
        AppendSqlStore.sqlWhere(productDto.getUnitName(), "u.unit_name", sql, Constants.SELECT);

        //物料类型 名称
        AppendSqlStore.sqlWhere(productDto.getItemTypName(), "it.item_typ_name", sql, Constants.SELECT);
        // 物料属性名称
        AppendSqlStore.sqlWhere(productDto.getItemAttributeName(), "ia.item_attribute_name", sql, Constants.SELECT);
        // 类目名称
        AppendSqlStore.sqlWhere(productDto.getProductName(), "ps.products_name", sql, Constants.SELECT);
        //  HS Code
        AppendSqlStore.sqlWhere(productDto.getHsCode(), "hc.hs_code", sql, Constants.SELECT);
        sql.WHERE(Alias + ".del_or_not=0");
        return sql.toString();
    }


    public String upProductPro(BasicPublicProduct product) {
        SQL sql = new SQL();
        sql.UPDATE("`basic_public_product`");
        //产品代码
        AppendSqlStore.sqlWhere(product.getProductCode(), "product_code", sql, Constants.UP);
        //产品名称
        AppendSqlStore.sqlWhere(product.getProductName(), "product_name", sql, Constants.UP);
        //规格型号
        AppendSqlStore.sqlWhere(product.getModel(), "model", sql, Constants.UP);
        //每箱数量
        AppendSqlStore.sqlWhere(product.getQtyPerBox(), "qty_per_box", sql, Constants.UP);
        //物料类型ID
        AppendSqlStore.sqlWhere(product.getItemTypId(), "item_typ_id", sql, Constants.UP);
        //物料属性ID
        AppendSqlStore.sqlWhere(product.getItemAttributeId(), "item_attribute_id", sql, Constants.UP);
        //产品SKU
        AppendSqlStore.sqlWhere(product.getProductSku(), "product_sku", sql, Constants.UP);
        //类目ID
        AppendSqlStore.sqlWhere(product.getProductsId(), "products_id", sql, Constants.UP);
        //长度CM
        AppendSqlStore.sqlWhere(product.getLengthCm(), "length_cm", sql, Constants.UP);
        //宽度CM
        AppendSqlStore.sqlWhere(product.getWidthCm(), "width_cm", sql, Constants.UP);
        //高度CM
        AppendSqlStore.sqlWhere(product.getHeightCm(), "height_cm", sql, Constants.UP);
        //毛重KG
        AppendSqlStore.sqlWhere(product.getGwKg(), "gw_kg", sql, Constants.UP);
        //净重
        AppendSqlStore.sqlWhere(product.getNwKg(), "nw_kg", sql, Constants.UP);
        //体积m
        AppendSqlStore.sqlWhere(product.getVolumeM3(), "volume_m3", sql, Constants.UP);
        //长度英寸
        AppendSqlStore.sqlWhere(product.getLengthIn(), "length_in", sql, Constants.UP);
        //宽度英寸
        AppendSqlStore.sqlWhere(product.getQtyPerBox(), "width_in", sql, Constants.UP);
        //高度英寸
        AppendSqlStore.sqlWhere(product.getHeightIn(), "height_in", sql, Constants.UP);
        //体积立方英尺
        AppendSqlStore.sqlWhere(product.getVolumeCuft(), "volume_cuft", sql, Constants.UP);
        //产地
        AppendSqlStore.sqlWhere(product.getMadeIn(), "made_in", sql, Constants.UP);
        //  HS Code
        AppendSqlStore.sqlWhere(product.getHsCodeId(), "hs_code_id", sql, Constants.UP);
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

package com.dt.user.provider;

import com.dt.user.dto.ProductDto;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class BasicPublicProductProvider {


    public String findProduct(ProductDto productDto) {
        SQL sql = new SQL();
        String Alias = "p";
        sql.SELECT("p.`product_id`,p.`product_code`,p.`product_name`,p.`model`,\n" +
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
        if (StringUtils.isNotBlank(productDto.getProductCode())) {
            sql.WHERE(Alias + ".product_code=#{productCode}");
        }
        //产品名称
        if (StringUtils.isNotBlank(productDto.getProductName())) {
            sql.WHERE(Alias + ".product_name=#{productName}");
        }
        //规格型号
        if (StringUtils.isNotBlank(productDto.getModel())) {
            sql.WHERE(Alias + ".model=#{model}");
        }
        //每箱数量
        if (productDto.getQtyPerBox() != null) {
            sql.WHERE(Alias + ".qty_per_box=#{qtyPerBox}");
        }
        //产品SKU
        if (StringUtils.isNotBlank(productDto.getProductSku())) {
            sql.WHERE(Alias + ".product_sku=#{productSku}");
        }
        //长度CM
        if (productDto.getLengthCm() != null) {
            sql.WHERE(Alias + ".length_cm=#{lengthCm}");
        }
        //宽度CM
        if (productDto.getWidthCm() != null) {
            sql.WHERE(Alias + ".width_cm=#{widthCm}");
        }
        //高度CM
        if (productDto.getHeightCm() != null) {
            sql.WHERE(Alias + ".height_cm=#{heightCm}");
        }
        //毛重KG
        if (productDto.getGwKg() != null) {
            sql.WHERE(Alias + ".gw_kg=#{gwKg}");
        }
        //净重
        if (productDto.getNwKg() != null) {
            sql.WHERE(Alias + ".nw_kg=#{nwKg}");
        }
        //体积m
        if (productDto.getVolumeM3() != null) {
            sql.WHERE(Alias + ".volume_m3=#{volumeM3}");
        }
        //长度英寸
        if (productDto.getLengthIn() != null) {
            sql.WHERE(Alias + ".length_in=#{lengthIn}");
        }
        //宽度英寸
        if (productDto.getQtyPerBox() != null) {
            sql.WHERE(Alias + ".width_in=#{widthIn}");
        }
        //高度英寸
        if (productDto.getHeightIn() != null) {
            sql.WHERE(Alias + ".height_in=#{heightIn}");
        }
        //体积立方英尺
        if (productDto.getVolumeCuft() != null) {
            sql.WHERE(Alias + ".volume_cuft=#{volumeCuft}");
        }

        //产地
        if (StringUtils.isNotBlank(productDto.getMadeIn())) {
            sql.WHERE(Alias + ".made_in=#{madeIn}");
        }
        //计量 单位名称
        if (StringUtils.isNotBlank(productDto.getUnitName())) {
            sql.WHERE("u.unit_name=#{unitName}");
        }
        //物料类型 名称
        if (StringUtils.isNotBlank(productDto.getItemTypName())) {
            sql.WHERE("it.item_typ_name=#{itemTypName}");
        }
        // 物料属性名称
        if (StringUtils.isNotBlank(productDto.getItemAttributeName())) {
            sql.WHERE("ia.item_attribute_name=#{itemAttributeName}");
        }
        // 类目名称
        if (StringUtils.isNotBlank(productDto.getProductName())) {
            sql.WHERE("ps.products_name=#{productsName}");
        }
        //  HS Code
        if (StringUtils.isNotBlank(productDto.getHsCode())) {
            sql.WHERE("hc.hs_code=#{hsCode}");
        }
        return sql.toString();
    }
}

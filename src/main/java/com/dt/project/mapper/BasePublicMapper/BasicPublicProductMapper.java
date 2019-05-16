package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.dto.ProductDto;
import com.dt.project.model.BasePublicModel.BasicPublicProduct;
import com.dt.project.provider.BasicPublicProductProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicProductMapper {


    /**
     * 查询产品物料信息
     */
    @SelectProvider(type = BasicPublicProductProvider.class, method = "findProduct")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<ProductDto> findProductInfo(ProductDto productDto);


    /**
     * 更新产品信息 信息
     */
    @UpdateProvider(type = BasicPublicProductProvider.class, method = "upProductPro")
    int upProduct(BasicPublicProduct product);

    /**
     * 批量删除数据/更新
     */
    @UpdateProvider(type = BasicPublicProductProvider.class, method = "delProductPro")
    int delProduct(@Param("thisIds") String thisIds);

    /**
     * 新增产品信息
     *
     * @param product
     * @return
     */
    @Insert("INSERT INTO `basic_public_product`" +
            "(`product_code`, `product_name`, `model`,\n" +
            "`unit_id`,`qty_per_box`, `item_typ_id`,`item_attribute_id`,\n" +
            "`product_sku`,`products_id`,`length_cm`, `width_cm`, `height_cm`,\n" +
            "`gw_kg`,`nw_kg`,`volume_m3`, `length_in`, `width_in`,\n" +
            "`height_in`, `volume_cuft`, `made_in`, `hs_code_id`,`status_id`)" +
            "VALUES (#{productCode},#{productName},#{model},\n" +
            "#{unitId},#{qtyPerBox},#{itemTypId},\n" +
            "#{itemAttributeId},#{productSku},#{productsId},\n" +
            "#{lengthCm},#{widthCm},#{heightCm},#{gwKg},\n" +
            "#{nwKg},#{volumeM3},#{lengthIn},#{widthIn},\n" +
            "#{heightIn},#{volumeCuft},#{madeIn},\n" +
            "#{hsCodeId},#{statusId});")
    int saveProduct(BasicPublicProduct product);
}

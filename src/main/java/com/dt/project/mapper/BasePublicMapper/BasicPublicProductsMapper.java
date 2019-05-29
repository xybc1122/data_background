package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicPublicProducts;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.provider.BasicPublicProductsProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BasicPublicProductsMapper {

    /**
     * 查询类目信息
     *
     * @return
     */
    @Select("SELECT `products_id`,`products_name`,`path`,`parent_id`,\n" +
            "`path`,`parent_node_is`\n" +
            "FROM `basic_public_products` where del_or_not=0")
    @Results({
            @Result(column = "products_id", property = "treeId"),
            @Result(column = "products_name", property = "treeName")
    })
    List<ParentTree> findByProductsInfo();


    /**
     * 修改产品类目信息
     */
    @UpdateProvider(type = BasicPublicProductsProvider.class, method = "upProductsPro")
    int upProducts(BasicPublicProducts products);


    /**
     * 删除产品类目信息
     */
    @UpdateProvider(type = BasicPublicProductsProvider.class, method = "delProductsPro")
    int delProducts(@Param("thisIds") String thisIds);


    /**
     * 新增产品类目信息
     */
    @Insert("INSERT INTO `basic_public_products`\n" +
            "(`number`,`products_name`,`parent_id`,`path`, `parent_node_is`,`status_id`)" +
            "VALUES (#{number}, #{treeName},#{parentId},\n" +
            "#{path},#{parentNodeIs},#{statusId});")
    int saveProducts(BasicPublicProducts products);
}

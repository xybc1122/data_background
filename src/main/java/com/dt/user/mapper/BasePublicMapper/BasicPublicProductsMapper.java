package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BasicPublicProductsMapper {

    /**
     * 查询类目信息
     *
     * @return
     */
    @Select("SELECT `products_id`,`products_name`,`path`,`parent_id`,\n" +
            "`path`,`is_parent`\n" +
            "FROM `basic_public_products`")
    @Results({
            @Result(column = "products_id", property = "treeId"),
            @Result(column = "products_name", property = "treeName"),
    })
    List<ParentTree> findByProductsInfo();
}

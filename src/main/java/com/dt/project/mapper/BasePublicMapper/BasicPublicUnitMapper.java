package com.dt.project.mapper.BasePublicMapper;
import com.dt.project.model.Parent.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BasicPublicUnitMapper {

    /**
     * 查询计量单位
     *
     * @return
     */
    @Select("SELECT\n" +
            "`unit_id`,`unit_name`,`path`,\n" +
            "`parent_id`,`parent_node_is`\n" +
            "FROM `basic_public_unit`")
    @Results({
            @Result(column = "unit_id", property = "treeId"),
            @Result(column = "unit_name", property = "treeName"),
    })
    List<ParentTree> findByListUnit();

}

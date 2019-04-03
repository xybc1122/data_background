package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationMethodMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:54
 **/
public interface BasicLogisticsmgtTransportValuationMethodMapper {

    /**
     * 查询计价类型
     */
    @Select("SELECT\n" +
            "`transport_valuation_method_id`,\n" +
            "`transport_valuation_method_name`,`parent_id`,\n" +
            "`path`,`is_parent`\n" +
            "FROM`basic_logisticsmgt_transport_valuation_method`")
    @Results({
            @Result(column = "transport_valuation_method_id", property = "treeId"),
            @Result(column = "transport_valuation_method_name", property = "treeName"),
    })
    List<ParentTree> findByValuationMethodInfo();
}

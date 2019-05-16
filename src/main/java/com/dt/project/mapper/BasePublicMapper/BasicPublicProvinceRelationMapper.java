package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicPublicProvinceRelation;
import com.dt.project.provider.BasicPublicProvinceRelationProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicProvinceRelationMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 10:50
 **/
public interface BasicPublicProvinceRelationMapper {


    /**
     * 查询省州关联数据
     */
    @SelectProvider(type = BasicPublicProvinceRelationProvider.class, method = "findRelation")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicProvinceRelation> findByRelationList(BasicPublicProvinceRelation relation);
}

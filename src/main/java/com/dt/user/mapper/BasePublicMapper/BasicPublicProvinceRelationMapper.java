package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.dto.SiteDto;
import com.dt.user.model.BasePublicModel.BasicPublicProvinceRelation;
import com.dt.user.provider.BasicPublicProvinceRelationProvider;
import com.dt.user.provider.BasicPublicSiteProvider;
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
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicProvinceRelation> findByRelationList(BasicPublicProvinceRelation relation);
}

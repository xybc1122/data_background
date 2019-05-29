package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.dto.AreaDto;
import com.dt.project.model.basePublicModel.BasicPublicArea;
import com.dt.project.provider.BasicPublicAreaProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicAreaMapper {

    /**
     * 查询区域所有相关信息
     *
     * @return
     */
    @Select("SELECT `area_id`,`number`,`area_name`,`area_name_eng`,area_short_name_eng,status_id \n" +
            "FROM `basic_public_area`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<AreaDto> findByListArea();


    /**
     * 查询区域信息
     *
     * @return
     */
    @SelectProvider(type = BasicPublicAreaProvider.class, method = "selectReg")
    List<BasicPublicArea> selectRegion(@Param("rid") String rid);


}

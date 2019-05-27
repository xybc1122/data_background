package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicExportHsCode;
import com.dt.project.provider.BasicExportHsCodeProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportHsCodeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 11:07
 **/
public interface BasicExportHsCodeMapper {


    /**
     * 查询出口管理-HS Code
     * @return
     */
    @SelectProvider(type = BasicExportHsCodeProvider.class, method = "findHsCode")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportHsCode> findByListHsCode(BasicExportHsCode hsCode);
}

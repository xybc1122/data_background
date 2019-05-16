package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicExportElement;
import com.dt.project.provider.BasicExportElementProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportElementMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:00
 **/
public interface BasicExportElementMapper {


    /**
     * 查询出口管理-HS Code
     *
     * @return
     */
    @SelectProvider(type = BasicExportElementProvider.class, method = "findElement")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportElement> findByListElement(BasicExportElement element);
}

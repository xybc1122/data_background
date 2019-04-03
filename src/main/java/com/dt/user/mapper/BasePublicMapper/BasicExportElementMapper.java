package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicExportElement;
import com.dt.user.provider.BasicExportElementProvider;
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
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportElement> findByListElement(BasicExportElement element);
}

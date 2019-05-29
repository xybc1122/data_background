package com.dt.project.mapper;

import com.dt.project.provider.GeneralPurposeProvider;
import com.dt.project.provider.SalesShipNoticeSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 通用表
 */
public interface GeneralPurposeMapper {


    /**
     * 批量删除出货通知单 /只做了字段更新
     *
     * @param ids
     * @return
     */
    @UpdateProvider(type = GeneralPurposeProvider.class, method = "deleteByGeneral")
    int deleteByGeneral(@Param("ids") List ids,@Param("table")String table,
                        @Param("thisId")String thisId);


}

package com.dt.project.mapper;

import com.dt.project.provider.GeneralPurposeProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 通用表
 */
public interface GeneralPurposeMapper {


    /**
     * 通用 批量删除 /只做了字段更新
     *
     * @param ids
     * @return
     */
    @UpdateProvider(type = GeneralPurposeProvider.class, method = "deleteByGeneral")
    int deleteByGeneral(@Param("ids") List ids, @Param("table") String table,
                        @Param("thisId") String thisId);

    /**
     * 用父ID查询子ID下面是否还有节点
     *
     * @return
     */
    @SelectProvider(type = GeneralPurposeProvider.class, method = "selIsNull")
    List<Integer> selIsNull(@Param("ids") List ids, @Param("table") String table,
                            @Param("thisId") String thisId);
}

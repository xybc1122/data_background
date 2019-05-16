package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonAdHl;
import com.dt.project.provider.SalesAmazonAdHlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SalesAmazonAHlMapper {
    /**
     * 存入广告Hl数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonAdHlProvider.class, method = "addAmazonAdHl")
    int setSalesAmazonAdHlList(@Param("hlList") List<SalesAmazonAdHl> hlList);

    /**
     * 查询Hl 数据
     */
    @SelectProvider(type = SalesAmazonAdHlProvider.class, method = "getHlInfo")
    List<SalesAmazonAdHl> findByListHl(SalesAmazonAdHl hl);
}

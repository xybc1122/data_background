package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.user.provider.BasicSalesAmazonCsvTxtXslHeaderProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicSalesAmazonCsvTxtXslHeaderMapper {
    /**
     * 通过seId获取 header信息
     *
     * @param seId
     * @return
     */
    @SelectProvider(type = BasicSalesAmazonCsvTxtXslHeaderProvider.class, method = "findHeadInfo")
    List<String> headerList(@Param("seId") Integer seId, @Param("tbId") Integer tbId, @Param("areaId") Integer areaId, @Param("shopId") Integer shopId);

    /**
     * 获得对象
     *
     * @param seId
     * @param tbId
     * @param areaId
     * @return
     */
    @SelectProvider(type = BasicSalesAmazonCsvTxtXslHeaderProvider.class, method = "getHead")
    List<BasicSalesAmazonCsvTxtXslHeader> sqlHead(@Param("seId") Integer seId, @Param("tbId") Integer tbId,
                                                  @Param("areaId") Integer areaId, @Param("shopId") Integer shopId);

    /**
     * 查询获得导入模板
     */
    @SelectProvider(type = BasicSalesAmazonCsvTxtXslHeaderProvider.class, method = "getTemplate")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonCsvTxtXslHeader> getImportTemplate(BasicSalesAmazonCsvTxtXslHeader csvTxtXslHeader);
}

package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonDescription;
import com.dt.user.provider.BasicSalesAmazonDescriptionProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonDescriptionMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:44
 **/
public interface BasicSalesAmazonDescriptionMapper {


    /**
     * 查询获得亚马逊描述
     */
    @SelectProvider(type = BasicSalesAmazonDescriptionProvider.class, method = "getDescription")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonDescription> getDescription(BasicSalesAmazonDescription description);


}

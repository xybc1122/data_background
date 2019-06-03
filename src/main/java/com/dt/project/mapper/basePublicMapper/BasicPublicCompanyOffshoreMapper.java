package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicPublicCompanyOffshore;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicCompanyOffshoreMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 14:06
 **/
public interface BasicPublicCompanyOffshoreMapper {

    /**
     * 查看离岸公司
     *
     * @return
     */
    @Select("SELECT\n" +
            "`company_id`,\n" +
            "`number`,`company_full_name`, `company_full_name_eng`,\n" +
            "`company_short_name`,`company_short_name_eng`,\n" +
            "`credit_code`,`bank_of_deposit`,`bank_account`, `account_type`,\n" +
            "`address`, `address_eng`,`tel_phone`, `ein_no`,\n" +
            "`eori_no`, `vat_no`,`status_id`\n" +
            "FROM `basic_public_company_offshore`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicCompanyOffshore> findByListOffshore();

}

package com.dt.project.mapper;

import com.dt.project.model.AccountStatusOptions;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountStatusOptionsMapper {

    /**
     * 查询状态信息
     * @param hd
     * @return
     */
    @Select("SELECT `id`,`name`,select_id FROM `account_status_options` WHERE h_id=#{id}")
    List<AccountStatusOptions> getAccountStatusOptionsInfo(@Param("id") Integer hd);

}

package com.dt.project.mapper.systemMapper;

import com.dt.project.model.system.SystemUserConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @ClassName SystemUserConfigMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/20 10:04
 **/
public interface SystemUserConfigMapper {


    /**
     * 新增一个用户配置信息
     */
    @Insert("INSERT INTO `system_user_config`(`mid`, `create_date`, `create_user`) " +
            "VALUES (#{mid},#{createDate},#{createUser})")
    @Options(useGeneratedKeys = true, keyProperty = "configId", keyColumn = "config_id")
    int saveUserConfig(SystemUserConfig userConfig);


}

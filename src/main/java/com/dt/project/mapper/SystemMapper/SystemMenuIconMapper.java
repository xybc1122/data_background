package com.dt.project.mapper.systemMapper;

import com.dt.project.model.SystemMenuIcon;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName SystemMenuIconMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/4 14:32
 **/
public interface SystemMenuIconMapper {
    /**
     * 获得所有icon
     *
     * @return
     */
    @Select("SELECT `i_id`,`icon` FROM `system_menu_icon`")
    List<SystemMenuIcon> getIconList();
}

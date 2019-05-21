package com.dt.project.mapper;


import com.dt.project.model.TbHeadMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface HeadMenuMapper {

    /**
     * 新增菜单关联数据
     */
    @Insert("INSERT INTO `system_user_menu_field`(`m_id`,`field_id`)\n" +
            "VALUES (#{mid},#{thId})")
    int addHeadMenu(TbHeadMenu tbHeadMenu);

    /**
     * 删除菜单关联
     */
    @Delete("DELETE FROM `system_user_menu_field`\n" +
            "WHERE `field_id` = #{thId} AND m_id=#{mid};\n")
    int delHeadMenu(TbHeadMenu tbHeadMenu);
}

package com.dt.user.mapper;

import com.dt.user.model.UserUpload;
import com.dt.user.provider.UserUploadProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserUploadMapper {

    /**
     * 更新用户信息
     */
    @UpdateProvider(type = UserUploadProvider.class, method = "upInfo")
    int upUploadInfo(UserUpload userUpload);

    /**
     * 用户上传记录表
     *
     * @param userUpload
     * @return
     */
    @Insert("INSERT INTO`system_user_upload`" +
            "(`uid`,`name`,`create_date`,`closing_date`," +
            "`del_date`,`del_date_id`,`remark`,`file_path`,`write_file_path`,`status`,`shop_id`,`site_id`,`m_id`,`area_id`,`businessTime`,uuid_name,pay_id)" +
            "VALUES (#{uid},#{name},#{createDate},#{closingDate},#{delDate},#{delDateId},#{remark},#{filePath},#{writeFilePath},#{status},#{shopId}," +
            "#{siteId},#{mid},#{areaId},#{businessTime},#{uuidName},#{payId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addUserUploadInfo(UserUpload userUpload);

    /**
     * 查询用户上传记录
     */
    @SelectProvider(type = UserUploadProvider.class, method = "findUpInfo")
    List<UserUpload> getUserUploadInfo(UserUpload upload);

    /**
     * 删除 上传记录 更新标示符
     */
    @Update("UPDATE `system_user_upload`\n" +
            "SET \n" +
            "`del_mark` = 1\n" +
            "WHERE `id` = #{id};")
    int delUploadInfo(@Param("id") Long id);
}

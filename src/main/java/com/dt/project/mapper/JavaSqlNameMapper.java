package com.dt.project.mapper;

import com.dt.project.model.JavaSqlName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName JavaSqlNameMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/19 14:40
 **/
public interface JavaSqlNameMapper {


    @Insert("INSERT INTO`java_sql_name`(`sql_name`, `j_name`,`model`)" +
            "VALUES (#{sqlName},#{jName},#{model})")
    int set(JavaSqlName javaSqlName);

    /**
     * 动态查询前端需要查询的字段
     *
     * @param model
     * @return
     */
    @Select("SELECT`js_id`,`sql_name`,`j_name`,`model`,`sign`\n" +
            "FROM `java_sql_name` WHERE model =#{model} AND `sign` =1")
    List<JavaSqlName> selectSqlName(@Param("model") String model);

}

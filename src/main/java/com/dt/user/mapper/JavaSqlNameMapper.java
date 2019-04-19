package com.dt.user.mapper;

import com.dt.user.model.JavaSqlName;
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


    @Insert("INSERT INTO`java_sql_name`(`sqlName`, `jName`,`model`)" +
            "VALUES (#{sqlName},#{jName},#{model})")
    int set(JavaSqlName javaSqlName);

    /**
     * 动态查询前端需要查询的字段
     *
     * @param model
     * @return
     */
    @Select("SELECT`js_id`,`sqlName`,`jName`,`model`,`sign`\n" +
            "FROM `java_sql_name` WHERE model =#{model} AND `sign` =1")
    List<JavaSqlName> get(@Param("model") String model);

}

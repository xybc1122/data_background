package com.dt.project.mapper.SalesAmazonMapper;

import com.dt.project.model.SalesAmazon.SalesAmazonFbaFeedback;

import java.util.List;

import com.dt.project.provider.SalesAmazonFbaFeedbackSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface SalesAmazonFbaFeedbackMapper {
    /**
     * 删除
     *
     * @param feedback
     * @return
     */
    @DeleteProvider(type = SalesAmazonFbaFeedbackSqlProvider.class, method = "deleteByFeedback")
    int deleteByExample(SalesAmazonFbaFeedback feedback);

    /**
     * 新增数据
     *
     * @param feedback
     * @return
     */
    @Insert({
            "insert into sales_amazon_fba_feedback (`date`, `shop_id`, ",
            "`site_id`, `add`, `move`,",
            "`remark`,`create_date`,`create_user`,`status`)",
            "values (#{date,jdbcType=BIGINT}, #{shopId,jdbcType=INTEGER}, ",
            "#{siteId,jdbcType=INTEGER}, #{add,jdbcType=INTEGER}, #{move,jdbcType=INTEGER}, ",
            "#{remark,jdbcType=VARCHAR},#{createDate,jdbcType=BIGINT}, #{createUser,jdbcType=VARCHAR}," +
                    "#{status,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertFeedback(SalesAmazonFbaFeedback feedback);

    /**
     * 条件判断插入
     *
     * @param record
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaFeedbackSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertSelective(SalesAmazonFbaFeedback record);

    /**
     * 查找feedback
     *
     * @param record
     * @return
     */
    @SelectProvider(type = SalesAmazonFbaFeedbackSqlProvider.class, method = "selectByFeedback")
    List<SalesAmazonFbaFeedback> selectByFeedback(SalesAmazonFbaFeedback record);

    /**
     * 动态更新feedback
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = SalesAmazonFbaFeedbackSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesAmazonFbaFeedback record);

}
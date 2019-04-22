package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaFeedback;
import com.dt.user.model.SalesAmazon.Example.SalesAmazonFbaFeedbackExample;

import java.util.List;

import com.dt.user.provider.SalesAmazonFbaFeedbackSqlProvider;
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
     * 插入
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into sales_amazon_fba_feedback (date, shop_id, ",
            "site_id, add, move, ",
            "remark, status, ",
            "create_date, create_user, ",
            "modify_date, modify_user, ",
            "audit_date, audit_user, ",
            "recording_id, version, ",
            "del_or_not)",
            "values (#{date,jdbcType=BIGINT}, #{shopId,jdbcType=INTEGER}, ",
            "#{siteId,jdbcType=INTEGER}, #{add,jdbcType=INTEGER}, #{move,jdbcType=INTEGER}, ",
            "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
            "#{createDate,jdbcType=BIGINT}, #{createUser,jdbcType=VARCHAR}, ",
            "#{modifyDate,jdbcType=BIGINT}, #{modifyUser,jdbcType=VARCHAR}, ",
            "#{auditDate,jdbcType=BIGINT}, #{auditUser,jdbcType=VARCHAR}, ",
            "#{recordingId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insert(SalesAmazonFbaFeedback record);

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
     * 查找
     *
     * @param record
     * @return
     */
    @SelectProvider(type = SalesAmazonFbaFeedbackSqlProvider.class, method = "selectByFeedback")
    List<SalesAmazonFbaFeedback> selectByFeedback(SalesAmazonFbaFeedback record);

    /**
     * 动态更新
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = SalesAmazonFbaFeedbackSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesAmazonFbaFeedback record);

}
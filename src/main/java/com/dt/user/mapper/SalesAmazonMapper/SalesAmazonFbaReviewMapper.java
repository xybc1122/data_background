package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.dto.ReviewDto;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;

import java.util.List;

import com.dt.user.provider.SalesAmazonFbaReviewSqlProvider;
import org.apache.ibatis.annotations.*;

public interface SalesAmazonFbaReviewMapper {


    @SelectProvider(type = SalesAmazonFbaReviewSqlProvider.class, method = "countByExample")
    int countByExample(SalesAmazonFbaReview example);


    @DeleteProvider(type = SalesAmazonFbaReviewSqlProvider.class, method = "deleteByExample")
    int deleteByExample(SalesAmazonFbaReview example);

    /**
     * 新增 review
     *
     * @param review
     * @return
     */
    @Insert({
            "insert into sales_amazon_fba_review (`date`,",
            "`shop_id`, `site_id`, ",
            "`sku_id`, `star_level_id`, ",
            "`add`, `move`, `remark`, ",
            "`create_date`,`create_user`,`status`)",
            "values (#{date,jdbcType=BIGINT}, ",
            "#{shopId,jdbcType=INTEGER}, #{siteId,jdbcType=INTEGER}, ",
            "#{skuId,jdbcType=BIGINT}, #{starLevelId,jdbcType=INTEGER}, ",
            "#{add,jdbcType=INTEGER}, #{move,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR},",
            "#{createDate,jdbcType=BIGINT},",
            "#{createUser,jdbcType=VARCHAR},#{status,jdbcType=INTEGER})"
    })
    int insertReview(SalesAmazonFbaReview review);


    @InsertProvider(type = SalesAmazonFbaReviewSqlProvider.class, method = "insertSelective")
    int insertSelective(SalesAmazonFbaReview record);


    /**
     * 查询 review
     *
     * @return
     */
    @SelectProvider(type = SalesAmazonFbaReviewSqlProvider.class, method = "selectByReview")
    List<SalesAmazonFbaReview> selectByReview(ReviewDto reviewDto);

    /**
     * 修改Review
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = SalesAmazonFbaReviewSqlProvider.class, method = "updateByReview")
    int updateByReview(SalesAmazonFbaReview record);

    /**
     * 物理删除 更新数据
     *
     * @param reId
     * @return
     */
    @UpdateProvider(type = SalesAmazonFbaReviewSqlProvider.class, method = "updateDelByReview")
    int delByReview(@Param("reId") Long reId, @Param("version") Integer version);
}
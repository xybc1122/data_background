package com.dt.user.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.user.dto.ReviewDto;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;
import com.dt.user.store.FieldStore;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.Map;

public class SalesAmazonFbaReviewSqlProvider {

    public String countByExample(SalesAmazonFbaReview example) {
        SELECT("count(*)");
        FROM("sales_amazon_fba_review");
        return SQL();
    }

    public String deleteByExample(SalesAmazonFbaReview example) {
        DELETE_FROM("sales_amazon_fba_review");
        return SQL();
    }

    public String insertSelective(SalesAmazonFbaReview record) {
        return SQL();
    }

    public String selectByReview(ReviewDto reviewDto) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "rev";
        sql.SELECT("`lev.star_level_name`,ps.`sku`,s.`shop_name`, cs.`site_name`," +
                "`re_id`, `date`,`add`,`move`," + ProviderSqlStore.statusV(alias) + "");
        sql.FROM("sales_amazon_fba_review AS " + alias);
        ProviderSqlStore.joinTable(sql,alias);
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        sql.LEFT_OUTER_JOIN("`basic_sales_public_starlevel` AS lev ON lev.`star_level_id` = " + alias + ".`star_level_id`");
        if (StringUtils.isNotBlank(reviewDto.getStarLevelName()))
            sql.WHERE("POSITION('" + reviewDto.getStarLevelName() + "' IN lev.`star_level_name`)");
        Field[] fields = SalesAmazonFbaReview.class.getDeclaredFields();
        FieldStore.query(fields, reviewDto.getNameList(), reviewDto, sql);
        ProviderSqlStore.selectUploadStatus(sql, reviewDto, alias);
        return sql.toString();
    }

    public String updateByExampleSelective(SalesAmazonFbaReview record) {


        UPDATE("sales_amazon_fba_review");

        if (record.getReId() != null) {
            SET("re_id = #{record.reId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }

        if (record.getShopId() != null) {
            SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
        }

        if (record.getSiteId() != null) {
            SET("site_id = #{record.siteId,jdbcType=INTEGER}");
        }

        if (record.getSkuId() != null) {
            SET("sku_id = #{record.skuId,jdbcType=BIGINT}");
        }

        if (record.getStarLevelId() != null) {
            SET("star_level_id = #{record.starLevelId,jdbcType=INTEGER}");
        }

        if (record.getAdd() != null) {
            SET("add = #{record.add,jdbcType=INTEGER}");
        }

        if (record.getMove() != null) {
            SET("move = #{record.move,jdbcType=INTEGER}");
        }

        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }

        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        }

        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sales_amazon_fba_review");

        SET("re_id = #{record.reId,jdbcType=BIGINT}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
        SET("site_id = #{record.siteId,jdbcType=INTEGER}");
        SET("sku_id = #{record.skuId,jdbcType=BIGINT}");
        SET("star_level_id = #{record.starLevelId,jdbcType=INTEGER}");
        SET("add = #{record.add,jdbcType=INTEGER}");
        SET("move = #{record.move,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("modify_date = #{record.modifyDate,jdbcType=BIGINT}");
        SET("modify_user = #{record.modifyUser,jdbcType=VARCHAR}");
        SET("audit_date = #{record.auditDate,jdbcType=BIGINT}");
        SET("audit_user = #{record.auditUser,jdbcType=VARCHAR}");
        SET("recording_id = #{record.recordingId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        return SQL();
    }
}
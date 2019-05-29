package com.dt.project.provider;

import com.dt.project.model.dto.ReviewDto;
import com.dt.project.model.salesAmazon.SalesAmazonFbaReview;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

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
        sql.SELECT("" + alias + ".`shop_id`," + alias + ".`site_id`," + alias + ".`sku_id`," + alias + ".`star_level_id`,lev.`star_level_name`,ps.`sku`,s.`shop_name`, cs.`site_name`," +
                "`re_id`, `date`,`add`,`move`," + ProviderSqlStore.statusV(alias) + "");
        sql.FROM("sales_amazon_fba_review AS " + alias);
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        sql.LEFT_OUTER_JOIN("`basic_sales_public_starlevel` AS lev ON lev.`star_level_id` = " + alias + ".`star_level_id`");
        ProviderSqlStore.joinTable(sql, alias);
        if (StringUtils.isNotBlank(reviewDto.getStarLevelName()))
            sql.WHERE("POSITION('" + reviewDto.getStarLevelName() + "' IN lev.`star_level_name`)");
        FieldStore.query(SalesAmazonFbaReview.class, reviewDto.getNameList(), reviewDto, sql);
        ProviderSqlStore.selectUploadStatus(sql, reviewDto, alias);
        return sql.toString();
    }

    public String isReview(SalesAmazonFbaReview review) {
        SQL sql = new SQL();
        String alias = "rev";
        sql.SELECT("re_id");
        sql.FROM("sales_amazon_fba_review AS " + alias);
        if (review.getDate() != null) {
            sql.WHERE("`date`=#{date}");
        }
        if (review.getShopId() != null) {
            sql.WHERE("shop_id=#{shopId}");
        }
        if (review.getSiteId() != null) {
            sql.WHERE("site_id=#{siteId}");
        }
        if (review.getSkuId() != null) {
            sql.WHERE("sku_id=#{skuId}");
        }
        if (review.getStarLevelId() != null) {
            sql.WHERE("star_level_id=#{starLevelId}");
        }
        if (review.getAdd() != null) {
            sql.WHERE("`add`=#{add}");
        }
        if (review.getMove() != null) {
            sql.WHERE("move=#{move}");
        }
        return sql.toString();
    }


    public String updateDelByReview(Map<String, Object> reMap) {
        Long reId = (Long) reMap.get("reId");
        Integer version = (Integer) reMap.get("version");
        SQL sql = new SQL();
        ProviderSqlStore.uploadDel(sql, "sales_amazon_fba_review", "re", version);
        sql.WHERE("re_id = " + reId);
        return sql.toString();
    }


    public String updateByReview(SalesAmazonFbaReview record) {
        SQL sql = new SQL();
        UPDATE("sales_amazon_fba_review");
        if (record.getDate() != null) {
            SET("date = #{date,jdbcType=BIGINT}");
        }

        if (record.getShopId() != null) {
            SET("shop_id = #{shopId,jdbcType=INTEGER}");
        }

        if (record.getSiteId() != null) {
            SET("site_id = #{siteId,jdbcType=INTEGER}");
        }
        if (record.getSkuId() != null) {
            SET("sku_id = #{skuId,jdbcType=BIGINT}");
        }

        if (record.getStarLevelId() != null) {
            SET("star_level_id = #{starLevelId,jdbcType=INTEGER}");
        }

        if (record.getAdd() != null) {
            SET("add = #{add,jdbcType=INTEGER}");
        }

        if (record.getMove() != null) {
            SET("move = #{move,jdbcType=INTEGER}");
        }

        ProviderSqlStore.setStatus(sql, record);

        WHERE("re_id = #{reId,jdbcType=BIGINT}");
        return sql.toString();
    }

}
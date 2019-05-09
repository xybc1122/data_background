package com.dt.user.provider;

import com.dt.user.dto.ReviewDto;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;
import com.dt.user.store.FieldStore;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
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
        Field[] fields = SalesAmazonFbaReview.class.getDeclaredFields();
        FieldStore.query(fields, reviewDto.getNameList(), reviewDto, sql);
        ProviderSqlStore.selectUploadStatus(sql, reviewDto, alias);
        return sql.toString();
    }


    public String updateDelByReview(Map<String, Object> reMap) {
        Long reId = (Long) reMap.get("reId");
        Integer version = (Integer) reMap.get("version");
        SQL sql = new SQL();
        ProviderSqlStore.upDel(sql, "sales_amazon_fba_review", "re", version);
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
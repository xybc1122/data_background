package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.provider.BasicPublicShopSiteSqlProvider;
import com.dt.user.model.BasePublicModel.BasicPublicShopSite;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BasicPublicShopSiteMapper {
    @SelectProvider(type = BasicPublicShopSiteSqlProvider.class, method = "countByExample")
    int countByExample(BasicPublicShopSite example);

    @DeleteProvider(type = BasicPublicShopSiteSqlProvider.class, method = "deleteByExample")
    int deleteByExample(BasicPublicShopSite example);

    /**
     * 新增 配置角色 站点
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into basic_public_shop_site (shop_id, site_id, ,r_id, status_id)",
            "values (#{shopId,jdbcType=BIGINT}, #{siteId,jdbcType=BIGINT}, ",
            "#{rId,jdbcType=INTEGER}, #{statusId,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertShopSite(BasicPublicShopSite record);

    @InsertProvider(type = BasicPublicShopSiteSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(BasicPublicShopSite record);


    @UpdateProvider(type = BasicPublicShopSiteSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPublicShopSite record, @Param("example") BasicPublicShopSite example);

    @UpdateProvider(type = BasicPublicShopSiteSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPublicShopSite record, @Param("example") BasicPublicShopSite example);
}
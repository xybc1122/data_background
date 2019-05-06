package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.dto.SiteDto;
import com.dt.user.model.BasePublicModel.BasicPublicSite;
import com.dt.user.provider.BasicPublicSiteProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicPublicSiteMapper {
    /**
     * 查询所有站点信息 //包含区域信息
     */
    @SelectProvider(type = BasicPublicSiteProvider.class, method = "findSite")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<SiteDto> findBySiteList(SiteDto siteDto);

    /**
     * 通过区域角色 id 查询 站点信息
     */
    @SelectProvider(type = BasicPublicSiteProvider.class, method = "selectSiteInfo")
    List<BasicPublicSite> selectSiteInfo(@Param("arId") Integer arId);

    /**
     * admin   配置 通过 aid 查询站点
     *
     * @param aid
     * @return
     */
    @Select("select se.`site_id`,se.`site_name`\n" +
            "FROM `basic_public_site` AS se where area_id = #{aid}")
    List<BasicPublicSite> selectAidSite(@Param("aid") Integer aid);

    /**
     * 通过url 去查询site ID
     *
     * @param url
     * @return
     */
    @Select("SELECT `site_id` FROM `basic_public_site`" +
            "WHERE url=#{url}")
    Integer getUrlSiteId(@Param("url") String url);

    /**
     * 通过arId 去查找站点ID 只取第一行
     *
     * @param aid
     * @return
     */
    @Select("select se.`site_id`\n" +
            "FROM `basic_public_site` AS se where area_id = #{aid} LIMIT 1")
    Integer selectAidAndSite(@Param("aid") Integer aid);

    /**
     * 通过币别 currency 去查询site ID
     *
     * @param currency
     * @return
     */
    @Select("SELECT `site_id` FROM `basic_public_site`" +
            "WHERE currency=#{currency} limit 0,1")
    Integer getCurrencySiteId(@Param("currency") String currency);

    /**
     * 通过country 国家名 去查询site ID
     *
     * @return
     */
    @SelectProvider(type = BasicPublicSiteProvider.class, method = "getSId")
    Integer getSId(@Param("country") String country, @Param("sName") String sName);

    /**
     * 查询站点 id 跟站点名
     *
     * @return
     */
    @Select("SELECT `site_id`,`site_name` FROM `basic_public_site`")
    List<BasicPublicSite> selectSite();

    /**
     * 通过角色表去查询 站点信息
     */
    @SelectProvider(type = BasicPublicSiteProvider.class, method = "selSiteRole")
    List<BasicPublicSite> selectSiteRole();


}

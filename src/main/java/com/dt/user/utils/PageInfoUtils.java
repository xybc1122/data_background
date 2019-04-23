package com.dt.user.utils;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.model.BasePublicModel.BasicHrEducation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageInfoUtils {
    /**
     * 封装分页
     *
     * @param pageInfo
     * @param currentPage
     * @return
     */
    public static Map<String, Object> getPage(PageInfo pageInfo, Integer currentPage) {
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", currentPage);//当前页
        data.put("dataList", pageInfo.getList());//数据
        return data;
    }

    /**
     /**
     * 设置分页
     *
     * @param pageSize
     * @param currentPage
     */
    public static void setPage(Integer pageSize, Integer currentPage) {
        if (pageSize == null || currentPage == null) {
            throw new LsException("分页无参数");
        }
        //set page
        PageHelper.startPage(currentPage, pageSize);
    }

    /**
     * 返回分页
     *
     * @param currentPage
     * @return
     */
    public static ResponseBase returnPage(List<?> obj, Integer currentPage) {
        PageInfo<?> pageInfo = new PageInfo<>(obj);
        return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo, currentPage));
    }
}

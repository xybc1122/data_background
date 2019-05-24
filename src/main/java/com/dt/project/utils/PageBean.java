package com.dt.project.utils;

import java.util.List;

/**
 * @ClassName PageBean
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/20 13:04
 **/
public class PageBean<T> {


    private List<T> dataList;
    private Integer currentPage;
    private Integer pageSize;
    private Long totalCount;
    private Long totalPage;

    public PageBean() {

    }

    public PageBean(List<T> dataList, Integer currentPage, Integer pageSize, Long totalCount, Long totalPage) {
        this.dataList = dataList;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }


    public PageBean(Integer currentPage, Integer pageSize, Long totalCount, Long totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    /**
     * 计算总页数  静态方法
     *
     * @param pageSize 每页的记录数
     * @param allRow   总记录数
     * @return 总页数
     */
    public static Long getPageCount(int pageSize, final Long allRow) {
        //这里为了不报错
        if (pageSize <= 0) {
            pageSize = 1;
        }
        return allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
    }

    public static int setPSize(final int pageSize) {

        return (pageSize <= 0 ? 1 : pageSize);
    }

    /**
     * 计算当前页开始的记录
     *
     * @param pageSize    每页记录数
     * @param currentPage 当前第几页
     * @return 当前页开始记录号
     */
    public static int countOffset(final int pageSize, final int currentPage) {

        return pageSize * (currentPage - 1);
    }

    /**
     * 计算当前页，若为0或者请求的URL中没有“?page = ”则用1代替
     *
     * @param page 传入的参数（可能为空，即0  则返回1）
     * @return
     */
    public static int currentPage(int page) {
        return (page <= 0 ? 1 : page);
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}

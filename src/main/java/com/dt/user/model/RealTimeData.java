package com.dt.user.model;


import com.dt.user.utils.FileUtils;

/**
 * 定时请求的对象表
 */
public class RealTimeData {
    private String fileName;
    //上传页面id
    private Long redId;

    /**
     * 总数
     */
    private Double totalNumber;

    /**
     * 状态
     */
    private String status;

    /**
     * 百分比
     */
    private Integer percentage;

    /**
     * 颜色
     */
    private String color;

    /**
     * msg
     */
    private String msg;

    public RealTimeData() {

    }

    /**
     * 设置总行数xls
     *
     * @param totalNumber
     */
    public RealTimeData(Double totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 设置文件总数
     *
     * @param filePath
     */
    public void setFileCount(String filePath) {
        //首先获得行数
        Double sumCount = FileUtils.readFile(filePath);
        if (sumCount != 0.0) {
            //获得总行数
            this.totalNumber = sumCount;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getRedId() {
        return redId;
    }

    public void setRedId(Long redId) {
        this.redId = redId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void Timing() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Double getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Double totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

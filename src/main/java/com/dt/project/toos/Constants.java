package com.dt.project.toos;

public interface Constants {

    /**
     * token
     */
    String TOKEN = "token";

    /**
     * 通过模型去条件查询 key
     */
    String MODEL = "model:";


    /**
     * 站点KEY
     */
    String SITE_INFO = "se_ino:";

    String STATUS_ID = "sId:";
    /**
     * 管理员reid key
     */
    String ADMIN = "admin:";
    /**
     * project key
     */
    String USER = "project:";
    /**
     * 图片上传存放地址
     */
    String SAVE_IMAGE_PATH = "E:/imagePath/";
    /**
     * 文件上传存放地址
     */
    String SAVE_FILE_PATH = "E:/filePath/";
    /**
     * 上传到ftp服务器上的地址
     */
    String UPLOAD_PATH = "/home/ftpuser/www/images";
//    /**
//     * Linux文件上传存放地址
//     */
//    String SAVE_FILE_PATH = "/usr/local/filter/filePath/";
    /**
     * 文件写入存放地址
     */
    String WRITE_SAVE_FILE_PATH = "E:/filePathSkuNo/";
//    /**
//     * Linux文件写入存放地址
//     */
//    String WRITE_SAVE_FILE_PATH = "/usr/local/filter/filePathSkuNo/";
    /**
     * 响应请求成功
     */
    String HTTP_RES_CODE_200_VALUE = "success";
    /**
     * 响应请求成功code
     */
    Integer HTTP_RES_CODE_200 = 200;
    /**
     * 系统错误
     */
    Integer HTTP_RES_CODE = -1;

    /**
     * 请求响应错误
     */
    Integer HTTP_RESP_CODE = -2;
    /**
     * 首次登陆返回状态码
     */
    Integer FIRST_CODE = -3;
    /**
     * 美国时间解析
     */
    String USA_TIME = "MMM d, yyyy HH:mm:ss a";
    /**
     * 加拿大时间解析
     */
    String CANADA_TIME = "yyyy-MM-dd HH:mm:ss a";
    /**
     * 澳大利亚时间转换
     */
    String AUSTRALIA_TIME = "dd/MM/yyyy HH:mm:ss a";

    /**
     * 英国时间转换
     */
    String UNITED_KINGDOM_TIME = "d MMM yyyy HH:mm:ss";

    /**
     * 德国日期转换
     */
    String GERMAN_TIME = "dd.MM.yyyy HH:mm:ss";
    /**
     * 法国日期转换
     */
    String FRANCE_TIME = "dd MM yyyy HH:mm:ss";

    /**
     * 意大利日期转换
     */
    String ITALY_TIME = "d/MM/yyyy HH.mm.ss";

    /**
     * 西班牙转换日期
     */
    String SPAIN_TIME = "dd/MM/yyyy HH:mm:ss";

    /**
     * 日本日期转换
     */
    String JAPAN_TIME = "yyyy/MM/dd HH:mm:ss";

    /**
     * 墨西哥日期转换
     */
    String MEXICO_TIME = "dd/MM/yyyy HH:mm:ss";

    /**
     * 订单/退货 / FBA遗弃 // 长期仓储费 //FBA遗弃 日期转换 通用日期
     */
    String GP_DATE = "yyyy-MM-dd'T'HH:mm:ss";
    /**
     * 月度报告时间转换
     */
    String MONTHLY_REPORT = "yyyy-MM";

    /**
     * 数据存入失败
     */
    String MSG_ERROR = "存入数据失败,请检查表头第一行是否正确/请检查上传的站点~";

    /**
     * 表头不一致
     */
    String HEADER_EXCEPTION = "表头信息不一致,请找管理员 *";

    /**
     * 财务导入ID
     */
    int FINANCE_ID = 85;

    /**
     * 运营财务导入ID
     */
    int FINANCE_ID_YY = 104;

    /**
     * 业务导入ID
     */
    int BUSINESS_ID = 108;

    String SAVE = "save";
    String UP = "up";
    String SELECT = "select";


}
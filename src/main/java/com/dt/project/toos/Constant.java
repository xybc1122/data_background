package com.dt.project.toos;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述: 全局常量
 * 1. USER_TOKEN 用户认证的键，用来匹配http session中的对应userId；
 * 2. webSocketServerHandShaker表，用channelId为键，存放握手实例。用来响应CloseWebSocketFrame的请求；
 * 3. onlineUser表，用userId为键，存放在线的客户端连接上下文；
 * 4. groupInfo表，用groupId为键，存放群信息；
 * 5. userInfo表，用username为键，存放用户信息。
 *
 * @author Kanarien
 * @version 1.0
 * @date 2018年5月18日 下午9:17:35
 */
public class Constant {
    /**
     * 保存webSocket连接对象 用户绑定
     */
    public static Map<Long, ChannelHandlerContext> onLineUserMap =
            new ConcurrentHashMap<Long, ChannelHandlerContext>();

    /**
     * 保存webSocket 握手对象
     */
    public static Map<String, WebSocketServerHandshaker> webSocketHandShakerMap =
            new ConcurrentHashMap<String, WebSocketServerHandshaker>();
//
//    /**
//     * 记录用户密码输错次数
//     */
//    public static ConcurrentHashMap<String, Integer> errorPwdMap = new ConcurrentHashMap<>();



//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://192.168.1.230:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
//            String project = "root";
//            String pass = "wawzj7788";
//            conn = DriverManager.getConnection(url, project, pass);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//    public static void main(String[] args) {
//        Connection conn = getConnection();
//        String sql = "select * from `java_sql_name`";
//        PreparedStatement stmt;
//        try {
//            stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery(sql);
//            ResultSetMetaData data = rs.getMetaData();
//            for (int i = 1; i <= data.getColumnCount(); i++) {
//// 获得所有列的数目及实际列数
//                int columnCount = data.getColumnCount();
//// 获得指定列的列名
//                String columnName = data.getColumnName(i);
//// 获得指定列的列值
//                int columnType = data.getColumnType(i);
//// 获得指定列的数据类型名
//                String columnTypeName = data.getColumnTypeName(i);
//// 所在的Catalog名字
//                String catalogName = data.getCatalogName(i);
//// 对应数据类型的类
//                String columnClassName = data.getColumnClassName(i);
//// 在数据库中类型的最大字符个数
//                int columnDisplaySize = data.getColumnDisplaySize(i);
//// 默认的列的标题
//                String columnLabel = data.getColumnLabel(i);
//// 获得列的模式
//                String schemaName = data.getSchemaName(i);
//// 某列类型的精确度(类型的长度)
//                int precision = data.getPrecision(i);
//// 小数点后的位数
//                int scale = data.getScale(i);
//// 获取某列对应的表名
//                String tableName = data.getTableName(i);
//// 是否自动递增
//                boolean isAutoInctement = data.isAutoIncrement(i);
//// 在数据库中是否为货币型
//                boolean isCurrency = data.isCurrency(i);
//// 是否为空
//                int isNullable = data.isNullable(i);
//// 是否为只读
//                boolean isReadOnly = data.isReadOnly(i);
//// 能否出现在where中
//                boolean isSearchable = data.isSearchable(i);
//                System.out.println(columnCount);
//                System.out.println("获得列" + i + "的字段名称:" + columnName);
////                System.out.println("获得列" + i + "的类型,返回SqlType中的编号:"+ columnType);
////                System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
////                System.out.println("获得列" + i + "所在的Catalog名字:"+ catalogName);
////                System.out.println("获得列" + i + "对应数据类型的类:"+ columnClassName);
////                System.out.println("获得列" + i + "在数据库中类型的最大字符个数:"+ columnDisplaySize);
////                System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
////                System.out.println("获得列" + i + "的模式:" + schemaName);
////                System.out.println("获得列" + i + "类型的精确度(类型的长度):" + precision);
////                System.out.println("获得列" + i + "小数点后的位数:" + scale);
////                System.out.println("获得列" + i + "对应的表名:" + tableName);
////                System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
////                System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
////                System.out.println("获得列" + i + "是否为空:" + isNullable);
////                System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
////                System.out.println("获得列" + i + "能否出现在where中:"+ isSearchable);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

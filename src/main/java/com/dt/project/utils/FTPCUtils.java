package com.dt.project.utils;

import com.dt.project.exception.LsException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName FTPCUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/9 15:37
 **/
public class FTPCUtils {

    /**
     * 连接文件服务器
     *
     * @param host     文件服务器地址
     * @param port     端口
     * @param username 用户名
     * @param password 密码
     * @throws Exception
     */
    public static FTPClient connect(String host, int port, String username, String password, String ftpPath) {
        System.out.println("【连接文件服务器】addr = " + host + " , port : " + port + " , username = " + username + " , password = "
                + password);

        FTPClient ftpClient = new FTPClient();
        try {
            // 连接
            ftpClient.connect(host, port);
            // 登录
            ftpClient.login(username, password);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                closeConnection(ftpClient);
                throw new LsException("connect failed...ftp服务器");
            }
            // 中文支持
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            //2）指定文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        } catch (Exception e) {
            throw new LsException("连接文件服务器失败");
        }
        return ftpClient;
    }

    /**
     * ftp上传
     *
     * @param fileName 保存ftp文件名称
     *                 要上传的文件
     */
    public static boolean upload(FTPClient ftpClient, String fileName, InputStream input, String ftpPath) {
        try {
            // 切换到上传目录
            if (!ftpClient.changeWorkingDirectory(ftpPath)) {
                // 如果目录不存在创建目录
                String[] dirs = ftpPath.split("/");
                String tempPath = "";
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftpClient.changeWorkingDirectory(tempPath)) {
                        ftpClient.makeDirectory(tempPath);
                        ftpClient.changeWorkingDirectory(tempPath);
                    }
                }
            }
           // system.out.println(ftpPath);
            System.out.println(ftpClient.printWorkingDirectory());
            // 上传文件
            boolean b = ftpClient.storeFile(fileName, input);
           // system.out.println(ftpClient.getReplyCode());
            return b;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 关闭连接，使用完连接之后，一定要关闭连接，否则服务器会抛出 Connection reset by peer的错误
     *
     * @throws IOException
     */
    public static void closeConnection(FTPClient ftpClient) throws IOException {
        ftpClient.logout();
        ftpClient.disconnect();
    }


}

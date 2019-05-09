package com.dt.user.utils;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.toos.Constant;
import com.dt.user.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Scanner;

public class FileUtils {

    /**
     * 上传文件
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        BufferedOutputStream out = null;
        File targetFile = new File(filePath);
        try {
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            out = new BufferedOutputStream(new FileOutputStream(filePath + fileName));
            out.write(file);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 封装获得编码格式 适用于TXT  CSV
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static InputStreamReader streamReader(String filePath) throws Exception {
        if (StringUtils.isEmpty(filePath)) {
            throw new Exception("处理文件路径不存在");
        }
        String fileEncode = EncodingDetect.getJavaEncode(filePath);
        try {
            return new InputStreamReader(new FileInputStream(filePath), fileEncode);
        } catch (UnsupportedEncodingException e) {
            throw new Exception("UnsupportedEncodingException-->文件转码出错");
        } catch (FileNotFoundException e) {
            throw new Exception("FileNotFoundException-->读取文件不存在");
        }
    }

    /**
     * 创建文件
     *
     * @param path
     */
    public static void mkdirFile(String path) {
        File pathFile = new File(path); // 相对路径，如果没有则要建立一个新的output.txt文件
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
    }

    /**
     * 读取文件总行数
     *
     * @param filePath
     * @return
     */
    public static Double readFile(String filePath) {
        Double count = 0.0;
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            return count;
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 下载文件
     */
    public static ResponseBase downloadFile(String path, HttpServletResponse response, HttpServletRequest request) {
        try (InputStream fis = new BufferedInputStream(new FileInputStream(path));
             OutputStream toClient = new BufferedOutputStream(response.getOutputStream())
        ) {
            File downloadFile = new File(path);
            if (!downloadFile.exists()) {
                return JsonData.setResultError("您要下载的资源已被删除");
            }
            // 取得文件名。
            String fileName = downloadFile.getName();
            String userAgent = request.getHeader("user-agent").toLowerCase();
            if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
                // win10 ie edge 浏览器 和其他系统的ie
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                // fe
                fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
            }
            long currentLen = 0;// 已读取文件大小
            long totleLen = downloadFile.length();// 总文件大小
            double percent = 0.0; //下载进度

            // 取得文件的后缀名。
//           String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            // 清空response
            response.reset();
            // 设置response的Header
            // System.out.println("Download DocFile's ORGIN----" + request.getHeader("Origin"));
            response.setHeader("Content-Length", "" + downloadFile.length());
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName + "");
            response.addHeader("Content-Length", "" + downloadFile.length());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
        } catch (IOException ex) {
            throw new LsException("文件下载传出异常");
        }
        return null;
    }
}

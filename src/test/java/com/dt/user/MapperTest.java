package com.dt.user;


import com.dt.user.mapper.BasePublicMapper.BasicPublicShopMapper;
import com.dt.user.mapper.FinancialImportMapper.FinancialSalesBalanceMapper;
import com.dt.user.mapper.SystemMapper.SystemFinalProcessingMapper;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;
import com.dt.user.service.JavaSqlNameService;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private JavaSqlNameService service;
    @Autowired
    private SystemFinalProcessingMapper pMapper;
    @Autowired
    private FinancialSalesBalanceMapper fsbMapper;
    @Autowired
    private BasicPublicShopMapper shopMapper;

    @Test
    public void add() {
        //设置动态查询
        SalesAmazonFbaReview f = new SalesAmazonFbaReview();
        Field[] field = f.getClass().getDeclaredFields();
        for (Field s : field) {
            s.setAccessible(true);
            JavaSqlName b = new JavaSqlName();
            b.setjName(s.getName());
            b.setModel("review");
            service.serviceSet(b);
        }
    }


    @Test
    public void fsbService() throws IOException {
        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.1.230", 21);
        //2、登录ftp服务器
        ftpClient.login("dt", "wawzj7788");
        ftpClient.setControlEncoding("UTF-8");
        int reply = ftpClient.getReplyCode();
        System.out.println(reply);
        if (!FTPReply.isPositiveCompletion(reply)) {
            System.out.println("connect failed...ftp服务器");
            return;
        }
        System.out.println("connect successfu...ftp服务器");
        //3、读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("E:/10197997_003647426000_2.jpg"));
        //4、上传文件
        //1）指定上传目录
        ftpClient.changeWorkingDirectory("/home/dt/images");
        //2）指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        //第一个参数：文件在远程服务器的名称
        //第二个参数：文件流
        ftpClient.storeFile("hello.jpg", inputStream);
        //5、退出登录
        ftpClient.logout();
    }
}


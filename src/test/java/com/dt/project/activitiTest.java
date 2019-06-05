package com.dt.project;

import com.dt.project.mapper.basePublicMapper.BasicPublicShopMapper;
import com.dt.project.mapper.financialImportMapper.FinancialSalesBalanceMapper;
import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticeMapper;
import com.dt.project.mapper.systemMapper.SystemFinalProcessingMapper;
import com.dt.project.model.JavaSqlName;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.model.warehouse.WarehouseIncArriveConfirm;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.utils.DatabaseUtil;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntityImpl;
import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
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
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName activitiTest
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/5 15:31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class activitiTest {
    @Autowired
    private JavaSqlNameService service;
    @Autowired
    private SystemFinalProcessingMapper pMapper;
    @Autowired
    private FinancialSalesBalanceMapper fsbMapper;
    @Autowired
    private BasicPublicShopMapper shopMapper;
    @Autowired
    private SalesShipNoticeMapper noticeMapper;
    @Autowired
    private IdentityService identityService;

    @Autowired
    private RepositoryService repositoryService;


    @Autowired
    private TaskService taskService;


    /**
     * 手动部署流程文档
     */
    @Test
    public void deploy() {
        String resource = "processes/proInspectionWareProcess.bpmn20.xml";
        String category = "测试分类2";
        Deployment deploy = repositoryService.createDeployment().name("采购检验入库流程").addClasspathResource(resource).category(category)
                .deploy();
        System.out.println(deploy);
    }

    /**
     * 设置流程组
     */
    @Test
    public void initGroup() {
        GroupEntityImpl groupEntityImpl = createGroup("产品部", "产品部");
        identityService.saveGroup(groupEntityImpl);
        GroupEntityImpl groupEntityImpl1 = createGroup("数据部", "数据部");
        identityService.saveGroup(groupEntityImpl1);
        GroupEntityImpl groupEntityImpl2 = createGroup("财务中心", "财务中心");
        identityService.saveGroup(groupEntityImpl2);
        GroupEntityImpl groupEntityImpl3 = createGroup("供应中心", "供应中心");
        identityService.saveGroup(groupEntityImpl3);
    }

    /**
     * 查看角色组的流程实例
     */
    @Test
    public void taskCandidateUser() {
        List<Group> groups = identityService.
                createGroupQuery().groupMember("eeee").list();
        System.out.println(groups);
        List<String> candidateGroups = new ArrayList<>();
        for (Group g : groups) {
            candidateGroups.add(g.getName());
        }
        List<Task> list = taskService
                .createTaskQuery()
                .taskCandidateGroupIn(candidateGroups)
                .list();
        for (Task task : list) {
            System.out.println(task);
        }
    }

    /**
     * 查看自己查询对应的数据
     */
    @Test
    public void taskAssignee() {
        String assignee = "eeee";
        List<Task> list = taskService
                .createTaskQuery()
                .taskAssignee(assignee)
                .list();
        for (Task task : list) {
            System.out.println(task.getId());
        }
    }

    @Test
    public void unclaim() {
        taskService.unclaim("32514");
    }

    /**
     * 完成流程
     */
    @Test
    public void complete() {
        Map<String, Object> objectMap = new HashMap<>();
       objectMap.put("anExamination", true);
        objectMap.put("quGoodWarGroup", "产品部");
        taskService.complete("60003", objectMap);
    }

    @Test
    public void initUser() {
        UserEntityImpl userEntityImpl = createUser("cc", "cc");
        identityService.saveUser(userEntityImpl);
//        UserEntityImpl userEntityImpl2 = createUser("tt", "tt");
//        identityService.saveUser(userEntityImpl2);
    }

    @Test
    public void createMembership() {
        identityService.createMembership("dd", "数据部");//建立组和用户关系
        // identityService.createMembership("tt", "供应中心");//建立组和用户关系
    }

//        @Test
//        public void generateDiagram() throws IOException {
//
//            System.out.println("processDiagramGenerator::::" + processDiagramGenerator);
//
//            String processDefinitionId = "purchaseOrder:2:27504";
//            List<String> highLightedActivities = new ArrayList<String>();
//            highLightedActivities.add("submitPurchaseOrder");
//
//            List<String> highLightedFlows = new ArrayList<String>();
//            highLightedFlows.add("flow1");
//            BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
//            InputStream inputStream = processDiagramGenerator.generateDiagram(bpmnModel, "PNG", highLightedActivities,
//                    highLightedFlows);
//            FileUtils.copyToFile(inputStream, new File("E:/" + "1.png"));
//        }

    private UserEntityImpl createUser(String id, String name) {
        UserEntityImpl userEntityImpl = new UserEntityImpl();
        userEntityImpl.setId(id);
        userEntityImpl.setFirstName(name);
        userEntityImpl.setRevision(0);
        return userEntityImpl;
    }

    private GroupEntityImpl createGroup(String id, String name) {
        GroupEntityImpl groupEntityImpl = new GroupEntityImpl();
        groupEntityImpl.setId(id);
        groupEntityImpl.setName(name);
        groupEntityImpl.setRevision(0);
        return groupEntityImpl;
    }


    @Test
    public void add() {
        List<String> tableNames = DatabaseUtil.getTableNames();
        List<String> c = null;
        System.out.println("tableNames:" + tableNames);
        for (String tableName : tableNames) {
            if (tableName.equals("warehouse_inc_arrive_confirm")) {
                c = DatabaseUtil.getColumnNames(tableName);
            }
        }
        //设置动态查询
        WarehouseIncArriveConfirm f = new WarehouseIncArriveConfirm();
        Field[] field = f.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            Field s = field[i];
            s.setAccessible(true);
            System.out.println(s.getName());
            JavaSqlName b = new JavaSqlName();
            b.setjName(s.getName());
            b.setModel("warIAConfirm");
            b.setSqlName(c.get(i));
            service.serviceSet(b);
        }

    }


    @Test
    public void fsbService() throws IOException {
        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.1.230", 21);
        //2、登录ftp服务器
        ftpClient.login("ftpuser", "wawzj7788");
        ftpClient.setControlEncoding("UTF-8");
        int reply = ftpClient.getReplyCode();
        System.out.println(reply);
        if (!FTPReply.isPositiveCompletion(reply)) {
            System.out.println("connect failed...ftp服务器");
            ftpClient.disconnect();
            return;
        }
        System.out.println("connect successfu...ftp服务器");
        //4、上传文件
        //1）指定上传目录
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //2）指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        //3、读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("E:/1.jpg"));
        //第一个参数：文件在远程服务器的名称
        //第二个参数：文件流
        ftpClient.storeFile("hello.jpg", inputStream);
        //5、退出登录
        ftpClient.logout();
    }

    @Test
    public void selectByNotice() {
        noticeMapper.selectByNotice(new SalesShipNotice());
    }
}

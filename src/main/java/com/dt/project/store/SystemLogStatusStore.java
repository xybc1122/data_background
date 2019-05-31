package com.dt.project.store;

import com.dt.project.model.SystemLogStatus;
import com.dt.project.utils.ReqUtils;
import com.dt.project.utils.StrUtils;

import java.util.Date;

/**
 * SystemLogStatus 表 通用设置
 *
 * @ClassName SystemLogStatusStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 10:31
 **/
public class SystemLogStatusStore {


    public static SystemLogStatus setModify(SystemLogStatus logStatus, String uName, Long statusId) {
        if (logStatus == null) {
            logStatus = new SystemLogStatus();
        }
        logStatus.setModifyDate(new Date().getTime());
        logStatus.setModifyUser(uName);
        logStatus.setStatusId(statusId);
        return logStatus;
    }


    public static String logStatusUpdate(String thisIds) {
        return StrUtils.updateSql(thisIds,
                "UPDATE `system_log_status`\n" + "SET `modify_user` = ",
                "'" + ReqUtils.getUserName() + "'", ",`modify_date`=", "status_id");
    }

}

package com.dt.user.store;

import com.dt.user.model.SystemLogStatus;
import com.dt.user.utils.ReqUtils;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @ClassName SystemLogStatusStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 10:31
 **/
public class SystemLogStatusStore {


    public static SystemLogStatus setModify(SystemLogStatus logStatus, String uName, Long statusId) {
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

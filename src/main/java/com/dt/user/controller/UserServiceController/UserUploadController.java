package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.UserInfo;
import com.dt.user.model.UserUpload;
import com.dt.user.service.UserUploadService;
import com.dt.user.utils.CookieUtil;
import com.dt.user.utils.PageInfoUtils;
import com.dt.user.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/upload")
public class UserUploadController {

    @Autowired
    private UserUploadService userUploadService;

    /**
     * 获取上传记录
     *
     * @return
     */
    @PostMapping("/getInfo")
    public ResponseBase getInfo(@RequestBody UserUpload upload) {
        PageInfoUtils.setPage(upload.getPageSize(), upload.getCurrentPage());
        upload.setUid(ReqUtils.getUid());
        return PageInfoUtils.returnPage(userUploadService.getUserUploadInfo(upload), upload.getCurrentPage());
    }

    /**
     * 删除上传记录信息
     *
     * @param id
     * @return
     */
    @GetMapping("/delInfo")
    public ResponseBase delInfo(@RequestParam("id") String id) {
        if (StringUtils.isEmpty(id) || id.equals("undefined")) {
            return JsonData.setResultError("删除ID错误~");
        }
        int count = userUploadService.delUploadInfo(Long.parseLong(id));
        if (count != 0) {
            return JsonData.setResultSuccess("删除成功~");
        }
        return JsonData.setResultError("上除失败~");
    }

}

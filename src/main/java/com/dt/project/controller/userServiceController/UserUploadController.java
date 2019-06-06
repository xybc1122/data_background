package com.dt.project.controller.userServiceController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.UserUpload;
import com.dt.project.service.UserUploadService;
import com.dt.project.utils.PageInfoUtils;
import com.dt.project.utils.ReqUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return PageInfoUtils.returnPage(userUploadService.getUserUploadInfo(upload));
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

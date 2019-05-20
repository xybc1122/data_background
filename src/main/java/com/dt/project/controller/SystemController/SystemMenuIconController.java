package com.dt.project.controller.SystemController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.SystemMenuIcon;
import com.dt.project.service.SystemMenuIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SystemMenuIconController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/4 14:36
 **/
@RestController
@RequestMapping("/api/v1/icon")
public class SystemMenuIconController {
    @Autowired
    private SystemMenuIconService iconService;

    /**
     * 获得所有图标列表
     *
     * @return
     */
    @GetMapping("/getIconInfo")
    public ResponseBase getIconInfo() {
        List<SystemMenuIcon> iconList = iconService.getIconList();
        return JsonData.setResultSuccess(iconList);
    }
}

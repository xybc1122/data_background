package com.dt.project.controller.UserServiceController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.TbHeadMenu;
import com.dt.project.service.HeadMenuService;
import com.dt.project.service.RedisService;
import com.dt.project.service.TableHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/hm")
@RestController
public class HeadMenuController {

    @Autowired
    private HeadMenuService headMenuService;

    /**
     * 新增菜单跟表头关联数据
     *
     * @param mhMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/saveHeadMenu")
    public ResponseBase saveHeadMenu(@RequestBody Map<String, Object> mhMap) {

        return headMenuService.addHeadMenu(mhMap);
    }

    /**
     * 删除菜单跟表头关联数据
     *
     * @param mhMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/delTbHeadMenu")
    public ResponseBase delTbHeadMenu(@RequestBody Map<String, Object> mhMap) {
        return headMenuService.delHeadMenu(mhMap);
    }


}

package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.TbHeadMenu;
import com.dt.user.service.HeadMenuMapperService;
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
    private HeadMenuMapperService headMenuMapperService;

    /**
     * 新增菜单跟表头关联数据
     * @param mhMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/saveHeadMenu")
    public ResponseBase saveHeadMenu(@RequestBody Map<String, Object> mhMap) {
        String mid = (String) mhMap.get("mid");
        List<Integer> thIds = (List<Integer>) mhMap.get("thIds");
        TbHeadMenu tbHeadMenu = new TbHeadMenu();
        for (int i = 0; i < thIds.size(); i++) {
            tbHeadMenu.setMid(Long.parseLong(mid));
            tbHeadMenu.setThId(thIds.get(i).longValue());
            headMenuMapperService.addHeadMenu(tbHeadMenu);
        }
        return JsonData.setResultSuccess("新增成功");
    }

    /**
     * 删除菜单跟表头关联数据
     * @param mhMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/delTbHeadMenu")
    public ResponseBase delTbHeadMenu(@RequestBody Map<String, Object> mhMap) {
        String mid = (String) mhMap.get("mid");
        List<Integer> thIds = (List<Integer>) mhMap.get("thIds");
        TbHeadMenu tbHeadMenu = new TbHeadMenu();
        for (Integer thId : thIds) {
            tbHeadMenu.setMid(Long.parseLong(mid));
            tbHeadMenu.setThId(thId.longValue());
            headMenuMapperService.delHeadMenu(tbHeadMenu);
        }
        return JsonData.setResultSuccess("删除成功");
    }
}

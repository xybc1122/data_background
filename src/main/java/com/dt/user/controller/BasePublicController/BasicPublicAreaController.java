package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.AreaDto;
import com.dt.user.service.BasePublicService.BasicPublicAreaService;
import com.dt.user.utils.PageInfoUtils;
import com.dt.user.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/reg")
public class BasicPublicAreaController {
    @Autowired
    private BasicPublicAreaService areaService;

    /**
     * 获得区域的信息
     *
     * @return
     */
    @PostMapping("/findByListRegion")
    public ResponseBase findByListRegion(@RequestBody AreaDto areaDto) {
        PageInfoUtils.setPage(areaDto.getPageSize(), areaDto.getCurrentPage());
        return PageInfoUtils.returnPage(areaService.findByListArea(), areaDto.getCurrentPage());
    }

    /**
     * 获得区域的信息
     *
     * @return
     */
    @GetMapping("/selectReg")
    public ResponseBase selectReg() {
        return JsonData.setResultSuccess(areaService.selectRegion(ReqUtils.getRoleId()));
    }
}

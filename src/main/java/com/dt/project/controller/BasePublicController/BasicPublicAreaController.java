package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.dto.AreaDto;
import com.dt.project.service.basePublicService.BasicPublicAreaService;
import com.dt.project.utils.PageInfoUtils;
import com.dt.project.utils.ReqUtils;
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

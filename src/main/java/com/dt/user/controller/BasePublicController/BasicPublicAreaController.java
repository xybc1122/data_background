package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.AreaDto;
import com.dt.user.service.BasePublicService.BasicPublicAreaService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/reg")
public class BasicPublicAreaController {
    @Autowired
    private BasicPublicAreaService basicPublicAreaService;

    /**
     * 获得区域的信息
     *
     * @return
     */
    @PostMapping("/findByListRegion")
    public ResponseBase findByListRegion(@RequestBody AreaDto areaDto) {
        List<AreaDto> basicPublicAreaList;
        if (areaDto.getCurrentPage() != null && areaDto.getPageSize() != null) {
            PageHelper.startPage(areaDto.getCurrentPage(), areaDto.getPageSize());
            basicPublicAreaList = basicPublicAreaService.findByListArea();
            PageInfo<AreaDto> pageInfo = new PageInfo<>(basicPublicAreaList);
            Integer currentPage = areaDto.getCurrentPage();
            return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo, currentPage));
        }
        basicPublicAreaList = basicPublicAreaService.findByListArea();
        return JsonData.setResultSuccess("分页无参数", basicPublicAreaList);
    }

}

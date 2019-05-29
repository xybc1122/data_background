package com.dt.project.service.basePublicService;

import com.dt.project.model.dto.AreaDto;
import com.dt.project.model.basePublicModel.BasicPublicArea;

import java.util.List;

public interface BasicPublicAreaService {

    /**
     * 查询区域所有相关信息
     *
     * @return
     */
    List<AreaDto> findByListArea();

    /**
     * 查询区域信息
     *
     * @return
     */
    List<BasicPublicArea> selectRegion(String rid);



}

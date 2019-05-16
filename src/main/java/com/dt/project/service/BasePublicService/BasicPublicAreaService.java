package com.dt.project.service.BasePublicService;

import com.dt.project.dto.AreaDto;
import com.dt.project.model.BasePublicModel.BasicPublicArea;

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

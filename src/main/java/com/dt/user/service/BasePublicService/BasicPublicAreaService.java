package com.dt.user.service.BasePublicService;

import com.dt.user.dto.AreaDto;

import java.util.List;

public interface BasicPublicAreaService {

    /**
     * 查询区域所有相关信息
     * @return
     */
    List<AreaDto> findByListArea();

}

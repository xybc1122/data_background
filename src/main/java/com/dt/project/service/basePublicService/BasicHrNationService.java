package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicHrNation;

import java.util.List;

/**
 * @ClassName BasicHrNationService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 13:54
 **/
public interface BasicHrNationService {




    /**
     * 查看名族
     *
     * @return
     */
    List<BasicHrNation> serviceFindByListHrNation();
}

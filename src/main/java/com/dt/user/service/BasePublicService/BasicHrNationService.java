package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicHrNation;

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

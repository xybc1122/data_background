package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicHrEducation;

import java.util.List;

/**
 * @ClassName BasicHrEducationService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:25
 **/
public interface BasicHrEducationService {

    /**
     * 查看学历
     */
    List<BasicHrEducation> serviceFindByListHrEdu();
}

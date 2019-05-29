package com.dt.project.controller.admin;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.customize.PermissionCheck;
import com.dt.project.model.dto.AreaRoleDto;
import com.dt.project.model.dto.RoleDto;
import com.dt.project.model.dto.UserDto;
import com.dt.project.model.basePublicModel.BasicPublicShop;
import com.dt.project.model.system.SystemInfoCompany;
import com.dt.project.model.UserInfo;
import com.dt.project.service.basePublicService.BasicPublicAreaRoleService;
import com.dt.project.service.basePublicService.BasicPublicAreaService;
import com.dt.project.service.basePublicService.BasicPublicShopService;
import com.dt.project.service.basePublicService.BasicPublicSiteService;
import com.dt.project.service.RoleMenuService;
import com.dt.project.service.RoleService;
import com.dt.project.service.systemService.SystemInfoCompanyService;
import com.dt.project.service.UserService;
import com.dt.project.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminConfig 超级管理员配置接口
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/25 10:35
 **/
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private BasicPublicShopService shopService;

    @Autowired
    private BasicPublicSiteService siteService;

    @Autowired
    private BasicPublicAreaService areaService;

    @Autowired
    private BasicPublicAreaRoleService areaRoleService;

    @Autowired
    private SystemInfoCompanyService cService;

    /**
     * @api {POST} /api/v1/admin/show 获取用户管理信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 获取用户管理信息
     * @apiParam {Integer} currentPage 当前页 :必填
     * @apiParam {Integer} pageSize 显示的页数 :必填
     * @apiParam {Long} [uid] 用户ID
     * @apiParam {String} [userName]  账号
     * @apiParam {String} [rName]  角色名称
     * @apiParam {String} [rid]  角色ID
     * @apiParam {String} [name] 昵称
     * @apiParam {Long} [landingTime] 登陆时间戳
     * @apiParam {String}[computerName] 计算机名
     * @apiParam {String}[remark] 备注
     * @apiParam {Long} [createDate] 创建时间
     * @apiParam {String}[createUser] 创建人
     * @apiParam {Long} [modifyDate] 修改日期
     * @apiParam {String}[modifyUser] 修改人
     * @apiParam {Long} [auditDate] 审核时间
     * @apiParam {String}[auditUser] 审核人
     * @apiParam {Integer}[version] 版本标识
     * @apiParam {Integer}[accountStatus] 账户状态，被锁定之类的，默认为0，表示正常
     * @apiParamExample {json} 请求样例：
     * {
     * "userName": "tt",
     * "accountStatus": 0,
     * "userExpirationDates": [1551283200000,1551283200000],
     * "pwdValidityPeriods": [1552060800000,1552060800000],
     * "rName": "超级管理员",
     * "landingTimes": [1558940570136,1558940570136],
     * "mobilePhone": "13515874497",
     * "computerName": "cccc",
     * "remark": null,
     * "createDates": [1558940570136,1558940570136],
     * "createUser": "1",
     * "modifyDates": [1558940570136,1558940570136],
     * "auditDates":  [1558940570136,1558940570136],
     * "modifyUser": "1",
     * "auditUser": "1",
     * "pwdAlways":false,
     * "uAlways":false
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"success","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/show")
    @PermissionCheck("show")
    public ResponseBase showUsers(@RequestBody UserDto pageDto) {
        PageInfoUtils.setPage(pageDto.getPageSize(), pageDto.getCurrentPage());
        return PageInfoUtils.returnPage(userService.findByUsers(pageDto), pageDto.getCurrentPage());
    }

    /**
     * @api {POST} /api/v1/admin/upUserInfo 更新用户信息
     * @apiHeaderExample {json} 请求头Header
     * {
     * "token":"用户令牌"
     * }
     * @apiGroup Admin
     * @apiVersion 0.0.1
     * @apiDescription 用于更新用户信息
     * @apiParam {String} userName 账号
     * @apiParam {Integer} version 更新用户版本
     * @apiParam {Integer} uid 更新用户ID
     * @apiParam {String} [mobilePhone] 手机号码
     * @apiParam {String} [name] 用户昵称
     * @apiParam {String} [pwd] 密码
     * @apiParam {Boolean} [pwdAlways] 如果勾选用户始终有效
     * @apiParam {Long} [userExpirationDate] 设置用户有效时间
     * @apiParam {Boolean} [uAlways] 如果勾选密码始终有效
     * @apiParam {Long} [pwdValidityPeriod] 设置密码有效时间
     * @apiParam {Boolean} [checkedUpPwd] 首次登陆修改密码
     * @apiParam {Integer} [accountStatus] 账户状态，被锁定之类的，默认为0，表示正常
     * @apiParamExample {json} 请求样例：
     * {
     * "userName": "tttt",
     * "version": 10,
     * "uid": 8,
     * "mobilePhone": "13515874497",
     * "name": "测试7",
     * "pwd":"86887075",
     * "pwdAlways": false,
     * "userExpirationDate": 1552009258000,
     * "uAlways": false,
     * "pwdValidityPeriod": 1572570379000,
     * "checkedUpPwd": true,
     * "accountStatus": 0
     * }
     * @apiSuccess (success) {Object} data 请求的数据
     * @apiSuccess (success) {String} msg 信息
     * @apiSuccess (success) {int} code -1 代表错误 200代表请求成功
     * @apiSuccessExample {json} 成功返回样列:
     * {"code":"200","msg":"更新成功","data":"{}"}
     * @apiErrorExample {json} 失败返回样例子:
     * {"code":"-1","msg":"error","data":"{}"}
     */
    @PostMapping("/upUserInfo")
    public ResponseBase userInfoUp(@RequestBody Map<String, Object> userMap) {
        return userService.updateUserInfo(userMap);
    }


    /**
     * 删除用户信息
     *
     * @return
     */
    @PostMapping("/delUserInfo")
    public ResponseBase userInfoDel(@RequestBody Map<String, Object> delMap) {
        int count = userService.delUserInfo(delMap.get("ids").toString());
        if (count > 0) {
            return JsonData.setResultSuccess(count);
        }
        return JsonData.setResultError("删除失败~");
    }


    /**
     * 恢复用户信息
     *
     * @return
     */
    @PostMapping("/reUserInfo")
    public ResponseBase userInfoRe(@RequestBody Map<String, Object> reMap) {
        int count = userService.reUserInfo(reMap.get("ids").toString());
        if (count > 0) {
            return JsonData.setResultSuccess(count);
        }
        return JsonData.setResultError("恢复失败~");
    }


    /**
     * 获得历史删除的用户信息
     *
     * @param pageDto 用户对象
     * @return JSON 对象
     */
    @PostMapping("/getDelUser")
    public ResponseBase getDelUser(@RequestBody UserDto pageDto) {
        PageHelper.startPage(pageDto.getCurrentPage(), pageDto.getPageSize());
        List<UserInfo> userDel = userService.findByDelUserInfo();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userDel);
        Integer currentPage = pageDto.getCurrentPage();
        return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo, currentPage));
    }


    /**
     * 新增用户
     *
     * @param userMap 前端传的数据
     * @return JSON 对象
     */
    @PostMapping("/saveUserInfo")
    public ResponseBase saveUserInfo(@RequestBody Map<String, Object> userMap) {
        return userService.saveUserInfo(userMap);
    }


    /**
     * 查询所有角色信息
     *
     * @return
     */
    @GetMapping("/findByListRoles")
    public ResponseBase findByListRoles() {
        return JsonData.setResultSuccess(roleService.getRoleList());
    }


    /**
     * 查询一个角色下的所有用户跟菜单
     *
     * @return
     */
    @PostMapping("/getRoles")
    public ResponseBase getRoles(@RequestBody RoleDto roleDto) {
        PageInfoUtils.setPage(roleDto.getPageSize(), roleDto.getCurrentPage());
        List<RoleDto> listRoles = roleService.findByRoleInfo(roleDto);
        return PageInfoUtils.returnPage(listRoles, roleDto.getCurrentPage());
    }

    /**
     * 角色管理修改页面 点击确定后请求此接口
     * 包含删除菜单，新增菜单
     *
     * @param menuMap
     * @return
     */
    @PostMapping("/upMenus")
    public ResponseBase getMenus(@RequestBody Map<String, Object> menuMap) {
        return roleMenuService.addAndDelMenu(menuMap);
    }


    /**
     * 获得所有的店铺名字
     *
     * @return
     */
    @GetMapping("/selectShopList")
    public ResponseBase selectShopList() {
        List<BasicPublicShop> nameList = shopService.getByListShopName(null);
        return JsonData.setResultSuccess(nameList);
    }


    /**
     * 获得区域的信息
     *
     * @return
     */
    @GetMapping("/selectReg")
    public ResponseBase selectReg() {
        return JsonData.setResultSuccess(areaService.selectRegion(null));
    }


    /**
     * 获得站点信息
     *
     * @return
     */
    @GetMapping("/selectSite")
    public ResponseBase selectSite(@RequestParam("aid") String aid) {
        return JsonData.setResultSuccess(siteService.selectAidSiteAdmin(Integer.parseInt(aid)));
    }


    /**
     * 配置区域 角色  站点 权限
     *
     * @return
     */
    @PostMapping("/setAreaRole")
    public ResponseBase setAreaRole(@RequestBody AreaRoleDto areaRoleDto) {
        return JsonData.setResultSuccess(areaRoleService.serviceInsertARole(areaRoleDto));
    }


    /**
     * admin 新增配置公司 信息 LOGO
     *
     * @return
     */
    @PostMapping("/saveInfoCompany")
    public ResponseBase saveInfoCompany(@RequestBody SystemInfoCompany company) {
        return JsonData.setResultSuccess(cService.serviceInsertCompany(company));
    }
}

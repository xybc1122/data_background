package com.dt.project.controller.Admin;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.customize.PermissionCheck;
import com.dt.project.dto.AreaRoleDto;
import com.dt.project.dto.RoleDto;
import com.dt.project.dto.UserDto;
import com.dt.project.model.BasePublicModel.BasicPublicShop;
import com.dt.project.model.Role;
import com.dt.project.model.System.SystemInfoCompany;
import com.dt.project.model.UserInfo;
import com.dt.project.service.BasePublicService.BasicPublicAreaRoleService;
import com.dt.project.service.BasePublicService.BasicPublicAreaService;
import com.dt.project.service.BasePublicService.BasicPublicShopService;
import com.dt.project.service.BasePublicService.BasicPublicSiteService;
import com.dt.project.service.RoleMenuService;
import com.dt.project.service.RoleService;
import com.dt.project.service.SystemService.SystemInfoCompanyService;
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
     * 获取用户管理信息的一些信息
     *
     * @param pageDto
     * @return
     * @PermissionCheck 自定义权限 需要show 才能查看
     */
    @PostMapping("/show")
    @PermissionCheck("show")
    public ResponseBase showUsers(@RequestBody UserDto pageDto) {
        PageInfoUtils.setPage(pageDto.getPageSize(), pageDto.getCurrentPage());
        List<UserInfo> listUser = userService.findByUsers(pageDto);
        return PageInfoUtils.returnPage(listUser, pageDto.getCurrentPage());
    }

    /**
     * 更新用户信息
     *
     * @return
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

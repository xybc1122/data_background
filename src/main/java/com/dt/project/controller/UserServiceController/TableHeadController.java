package com.dt.project.controller.userServiceController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.TableHeadDto;
import com.dt.project.model.TableHead;
import com.dt.project.service.TableHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TableHeadController {

    @Autowired
    private TableHeadService tableHeadService;

    /**
     * 引用表头
     *
     * @return
     */
    @PostMapping("/saveReference")
    public ResponseBase saveReferenceHead(@RequestBody TableHead tableHead) {
        return tableHeadService.ReHead(tableHead);
    }

    /**
     * 新增表头信息
     *
     * @return
     */
    @PostMapping("/saveHead")
    public ResponseBase saveHead(@RequestBody TableHead tableHead) {
        int count = tableHeadService.serviceSaveHead(tableHead);
        if (count != 0) {
            return JsonData.setResultSuccess("添加成功");
        }
        return JsonData.setResultError("添加失败");
    }

    /**
     * 查询可以引用的头字段
     *
     * @return
     */
    @GetMapping("/reference")
    public ResponseBase IsReference(@RequestParam("menuId") String menuId) {
        List<TableHead> headList = tableHeadService.getIsReference(menuId);
        return JsonData.setResultSuccess(headList);

    }

    /**
     * 通过菜单ID来查询 对应的表头信息
     *
     * @return
     */
    @GetMapping("/head")
    public ResponseBase findByHead(@RequestParam("menu_id") Long mId) {
        return JsonData.setResultSuccess(tableHeadService.findByMenuIdHeadList(mId));

    }

    /**
     * 通过一组menuId  in()查询一组菜单对应表头的数据
     *
     * @param mapHead
     * @return
     */
    @PostMapping("/getByHead")
    public ResponseBase getByHead(@RequestBody Map<String, Object> mapHead) {
        return JsonData.setResultSuccess(tableHeadService.getTableHeadList(mapHead));
    }

    /**
     * 通过一个菜单iD查询一个菜单对应表头的数据
     *
     * @param mid
     * @return
     */
    @GetMapping("/showByHead")
    public ResponseBase showByHead(@RequestParam("mId") Long mid) {
        return JsonData.setResultSuccess(tableHeadService.getTableHead(mid));
    }

    /**
     * 点击编辑 用菜单ID查询表头信息
     *
     * @return
     */
    @GetMapping("/findHeads")
    public ResponseBase findHeads(@RequestParam("mId") String mid) {
        return JsonData.setResultSuccess(tableHeadService.findByHeadList(Long.parseLong(mid)));
    }

    /**
     * 无条件查询所有表头
     */
    @GetMapping("/getHeadsList")
    public ResponseBase getHeadsList() {
        return JsonData.setResultSuccess(tableHeadService.findByHeadList(null));
    }

    /**
     * 引用接口获得head 信息
     */
    @GetMapping("/getReference")
    public ResponseBase getReference() {
        return JsonData.setResultSuccess(tableHeadService.findByHeadList(null));
    }

    /**
     * 更新菜单 下的头排序
     *
     * @return
     */
    @PostMapping("/upHeadSort")
    public ResponseBase upHeadSort(@RequestBody TableHeadDto headDto) {
        return tableHeadService.dataProcessing(headDto);
    }

    /**
     * 查看数据库是否有名字
     */
    @GetMapping("/isHeadName")
    public ResponseBase getIsHeadName(@RequestParam(name = "headName", required = false) String headName) {
        String result = tableHeadService.isHeadName(headName);
        if (result != null) {
            return JsonData.setResultError("已存在");
        }
        return JsonData.setResultSuccess("不存在");
    }

    /**
     * 查看数据库是否有topType
     */
    @GetMapping("/isTopType")
    public ResponseBase getIsTopType(@RequestParam(name = "topType", required = false) String topType) {
        String result = tableHeadService.isTopType(topType);
        if (result != null) {
            return JsonData.setResultError("已存在");
        }
        return JsonData.setResultSuccess("不存在");
    }

    /**
     * 更新表头信息
     *
     * @return
     */
    @PostMapping("/upHeadInfo")
    public ResponseBase upHeadInfo(@RequestBody TableHead tableHead) {
        int result = tableHeadService.serviceUpHead(tableHead);
        if (result > 0) {
            return JsonData.setResultSuccess("修改成功");
        }
        return JsonData.setResultError("修改失败");
    }
}

package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.TableHeadDto;
import com.dt.user.model.TableHead;
import com.dt.user.service.TableHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TableHeadController {

    @Autowired
    private TableHeadService tableHeadService;

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
    public ResponseBase IsReference() {
        List<TableHead> headList = tableHeadService.getIsReference();
        return JsonData.setResultSuccess(headList);

    }

    /**
     * 通过菜单ID来查询 对应的表头信息
     *
     * @return
     */
    @GetMapping("/head")
    public ResponseBase findByHead(@RequestParam("menu_id") Long mId) {
        List<TableHead> headList = tableHeadService.findByMenuIdHeadList(mId);
        return JsonData.setResultSuccess(headList);

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
    @Transactional
    public ResponseBase upHeadSort(@RequestBody TableHeadDto headDto) {
        return tableHeadService.dataProcessing(headDto);
    }
}

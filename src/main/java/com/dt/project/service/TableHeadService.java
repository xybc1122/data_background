package com.dt.project.service;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.TableHeadDto;
import com.dt.project.model.TableHead;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TableHeadService {
    /**
     * 处理引用头数据
     *
     * @param tableHead
     */
    ResponseBase ReHead(TableHead tableHead);


    /**
     * 更新head信息
     *
     * @param tableHead
     * @return
     */

    int serviceUpHead(TableHead tableHead);

    /**
     * 新增头字段
     *
     * @param tableHead
     * @return
     */
    int serviceSaveHead(TableHead tableHead);

    /**
     * 查询引用表头信息
     */
    List<TableHead> getIsReference(String menuIds);

    List<TableHead> findByMenuIdHeadList(Long menuId);

    /**
     * 根据菜单id查询对应显示的表头
     */
    List<TableHead> getTableHeadList(Map<String, Object> mapHead);


    /**
     * 通过mid查询一个数据
     *
     * @param mid
     * @return
     */
    TableHead getTableHead(@Param("mId") Long mid);

    /**
     * 查询所有表头信息
     */
    List<TableHead> findByHeadList(Long menuId);

    /**
     * 处理标题数组的下标
     */
    ResponseBase dataProcessing(TableHeadDto headDto);

    /**
     * 更新菜单下的头 排序
     *
     * @return
     */
    int upHeadSort(String[] newTopOrder, Long id, Integer version);

    /**
     * 检查表中名字是否一致
     */
    String isHeadName(String headName);

    /**
     * 检查表中topType是否一致
     */
    String isTopType(String topType);

    /**
     * 通过id in查询List数据
     */
    List<TableHead> serviceGetListTableHead(List<Integer> hidList);
}

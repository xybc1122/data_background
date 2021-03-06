package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.TableHeadDto;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.TableHeadMapper;
import com.dt.project.model.TableHead;
import com.dt.project.service.TableHeadService;
import com.dt.project.utils.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class TableHeadImpl implements TableHeadService {

    @Autowired
    private TableHeadMapper tableHeadMapper;


    @Override
    @Transactional
    public ResponseBase ReHead(TableHead tableHead) {

        if (tableHead.getHeadList() != null && tableHead.getHeadList().size() > 0) {
            int count = 0;
            for (TableHead t : tableHead.getHeadList()) {
                count += serviceUpHead(t);
            }
            if (count == tableHead.getHeadList().size()) {
                return JsonData.setResultSuccess("引用成功");
            }
            throw new LsException("引用失败");
        }
        return JsonData.setResultError("参数无效");
    }

    @Override
    public int serviceUpHead(TableHead tableHead) {
        return tableHeadMapper.upHead(tableHead);
    }

    @Override
    public int serviceSaveHead(TableHead tableHead) {
        return tableHeadMapper.insertHead(tableHead);
    }

    @Override
    public List<TableHead> getIsReference(String menuId) {
        //数据库
        List<TableHead> hList = tableHeadMapper.getIsReference();
        for (int j = 0; j < hList.size(); j++) {
            String hMId = hList.get(j).getMenuId();
            //判断是否有, 如果有 进行切割
            int index = hMId.indexOf(",");
            //如果不是-1 说明有 进行切割
            if (index != -1) {
                String[] hMIdArr = hMId.split(",");
                for (String strMid : hMIdArr) {
                    if (strMid.equals(menuId)) {
                        hList.remove(j);
                        //这里是为了删除一个元素后 下标又重新下降一位
                        --j;
                        break;
                    }
                }
            } else {
                if (hMId.equals(menuId)) {
                    hList.remove(j);
                    --j;
                    break;
                }
            }
        }
        return hList;
    }

    @Override
    public List<TableHead> findByMenuIdHeadList(Long menuId) {
        List<TableHead> head = tableHeadMapper.findByHeader(menuId);
        for (TableHead h : head) {
            int orderIndex = -1;
            int menuIdIndex = h.getMenuId().indexOf(",");
            if (StringUtils.isNotBlank(h.getTopOrder())) {
                orderIndex = h.getTopOrder().indexOf(",");
            }
            //如果有,号的说明是有顺序的
            if (orderIndex != -1 && menuIdIndex != -1) {
                String[] strOrder = h.getTopOrder().split(",");
                String[] strMenuId = h.getMenuId().split(",");
                //获得菜单ID 数组
                for (int i = 0; i < strMenuId.length; i++) {
                    //如果这两个相等 找到下标
                    if (menuId == Long.parseLong(strMenuId[i])) {
                        //获得下标位置
                        for (int j = 0; j < strOrder.length; j++) {
                            //如果i =0 说明只有一个位置
                            if (i == 0) {
                                //如果得到的值是 " " 或者null
                                if (StringUtils.isBlank(strOrder[j])) {
                                    h.setIndex(0);
                                } else {
                                    h.setIndex(Integer.parseInt(strOrder[j]));
                                }
                                break;
                            } else if (j == i) {
                                //如果得到的值是 " " 或者null
                                if (StringUtils.isBlank(strOrder[j])) {
                                    h.setIndex(0);
                                } else {
                                    h.setIndex(Integer.parseInt(strOrder[j]));
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            } else {
                //来到这里 getTopOrder 基本就只有一个字符串 或者没有
                if (StringUtils.isBlank(h.getTopOrder())) {
                    h.setIndex(0);
                } else {
                    try {
                        h.setIndex(Integer.parseInt(h.getTopOrder()));
                    } catch (Exception e) {
                        throw new LsException("menuId长度跟 topOrder不一致 请检查");
                    }
                }
            }
        }
        //接收数据库传来的对象
        return head;
    }

    @Override
    public List<TableHead> getTableHeadList(Map<String, Object> mapHead) {
        return tableHeadMapper.getTableHeadList(mapHead);
    }

    @Override
    public TableHead getTableHead(Long mid) {
        return tableHeadMapper.getTableHead(mid);
    }

    @Override
    public List<TableHead> findByHeadList(Long menuId) {
        List<TableHead> tableHeads = tableHeadMapper.findByHeadList();
        if (menuId == null) {
            return tableHeads;
        }
        return headNewList(tableHeads, menuId);

    }

    @Override
    @Transactional
    public ResponseBase dataProcessing(TableHeadDto headDto) {
        for (TableHead sort : headDto.getSort()) {
            //切割 TopOrder获得一个数组
            String[] strTopOrder;
            String[] strNewTopOrder;
            String[] topOrderArr;
            int indexTopOrder = -1;
            //查看对象中的menuId 是否有 ,
            int indexMid = sort.getMenuId().indexOf(",");
            if (indexMid != -1) {
                String[] strMid = sort.getMenuId().split(",");
                //循环 查找要替换的下标
                for (int i = 0; i < strMid.length; i++) {
                    if (headDto.getmId().equals(Integer.parseInt(strMid[i]))) {
                        //这里 判断不是null  或者 " " 的情况下
                        if (StringUtils.isNotBlank(sort.getTopOrder())) {
                            indexTopOrder = sort.getTopOrder().indexOf(",");
                        }
                        //如果是-1 说明里面的值是null 或者 是单个元素
                        if (indexTopOrder == -1) {
                            //设置新的top OrderArr 长度
                            topOrderArr = new String[i + 1];
                            //把他sort.getTopOrder
                            topOrderArr[i] = sort.getIndex().toString();
                            //更新数据
                            upHeadSort(topOrderArr, sort.getId(), sort.getVersion());
                            break;
                        } else {
                            //如果不是-1 说明里面有长度
                            strTopOrder = sort.getTopOrder().split(",");
                            //看看两个长度如果一样
                            if (strTopOrder.length == strMid.length) {
                                //记录索引  数组替换
                                Arrays.fill(strTopOrder, i, i + 1, sort.getIndex().toString());
                                //更新数据
                                upHeadSort(strTopOrder, sort.getId(), sort.getVersion());
                                break;
                            } else {
                                //如果不一样
                                //创建一个新的数组
                                strNewTopOrder = ListUtils.getArr(strMid, strTopOrder, i, sort);
                                //更新数据
                                upHeadSort(strNewTopOrder, sort.getId(), sort.getVersion());
                                break;
                            }
                        }
                    }
                }
                //如果菜单 indexMid ID 是一个的话
            } else {
                if (StringUtils.isNotBlank(sort.getTopOrder())) {
                    //而且这个必须是-1 说明只有一个值
                    indexTopOrder = sort.getTopOrder().indexOf(",");
                    if (indexTopOrder == -1) {
                        topOrderArr = new String[1];
                        topOrderArr[0] = sort.getIndex().toString();
                        //更新数据
                        upHeadSort(topOrderArr, sort.getId(), sort.getVersion());
                    }
                } else {
                    //如果是null  直接赋值
                    topOrderArr = new String[1];
                    topOrderArr[0] = sort.getIndex().toString();
                    //更新数据
                    upHeadSort(topOrderArr, sort.getId(), sort.getVersion());
                }
            }
        }
        return JsonData.setResultSuccess("更新数据成功");
    }

    @Override
    public int upHeadSort(String[] newTopOrder, Long id, Integer version) {
        int result = tableHeadMapper.upHeadSort(newTopOrder, id, version);
        if (result == 0) {
            throw new LsException("更新失败");
        }
        return result;
    }

    @Override
    public String isHeadName(String headName) {
        return tableHeadMapper.isHeadName(headName);
    }

    @Override
    public String isTopType(String topType) {
        return tableHeadMapper.isTopType(topType);
    }

    @Override
    public List<TableHead> serviceGetListTableHead(List<Integer> hidList) {
        return tableHeadMapper.getListTableHead(hidList);
    }


    /**
     * 遍历查找对应的menuId
     *
     * @param headList
     * @param mId
     * @return
     */
    public List<TableHead> headNewList(List<TableHead> headList, Long mId) {
        //创建一个新的数组
        List<TableHead> headNew = new ArrayList<>();
        for (TableHead head : headList) {
            //判断不为空
            if (StringUtils.isNotBlank(head.getMenuId())) {
                //切割变成数组
                String[] menu_id = head.getMenuId().trim().split(",");
                for (int i = 0; i < menu_id.length; i++) {
                    if (StringUtils.isNotBlank(menu_id[i])) {
                        //这里会有问题 判断下 会出现 For input string: "(NULL)" 这是数据库menuId 没设置值
                        int menuId = Integer.parseInt(menu_id[i]);
                        if (mId == menuId) {
                            headNew.add(head);
                        }
                    }
                }
            }
        }
        return headNew;
    }
}

package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.TableHeadDto;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.TableHeadMapper;
import com.dt.user.model.TableHead;
import com.dt.user.service.TableHeadService;
import com.dt.user.utils.ArrUtils;
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
    public ResponseBase setHead(TableHead tableHead) {
        try {
            if (tableHead.getHeadList() != null && tableHead.getHeadList().size() > 0) {
                for (TableHead t : tableHead.getHeadList()) {
                    serviceUpHead(t);
                }
                return JsonData.setResultSuccess("引用成功");
            }
        } catch (Exception e) {
            throw new LsException("引用头异常" + e.getMessage());
        }
        return JsonData.setResultError("引用失败");
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
    public List<TableHead> getIsReference() {
        return tableHeadMapper.getIsReference();
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
                    h.setIndex(Integer.parseInt(h.getTopOrder()));
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
                            upHeadSort(topOrderArr, sort.getId());
                            break;
                        } else {
                            //如果不是-1 说明里面有长度
                            strTopOrder = sort.getTopOrder().split(",");
                            //看看两个长度如果一样
                            if (strTopOrder.length == strMid.length) {
                                //记录索引  数组替换
                                Arrays.fill(strTopOrder, i, i + 1, sort.getIndex().toString());
                                //更新数据
                                upHeadSort(strTopOrder, sort.getId());
                                break;
                            } else {
                                //如果不一样
                                //创建一个新的数组
                                strNewTopOrder = ArrUtils.getArr(strMid, strTopOrder, i, sort);
                                //更新数据
                                upHeadSort(strNewTopOrder, sort.getId());
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
                        upHeadSort(topOrderArr, sort.getId());
                    }
                } else {
                    //如果是null  直接赋值
                    topOrderArr = new String[1];
                    topOrderArr[0] = sort.getIndex().toString();
                    //更新数据
                    upHeadSort(topOrderArr, sort.getId());
                }
            }
        }
        return JsonData.setResultSuccess("更新数据成功");
    }

    @Override
    public int upHeadSort(String[] newTopOrder, Long id) {
        return tableHeadMapper.upHeadSort(newTopOrder, id);
    }

    @Override
    public String isHeadName(String headName) {
        return tableHeadMapper.isHeadName(headName);
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

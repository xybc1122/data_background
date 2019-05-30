package com.dt.project.utils;

import com.dt.project.model.TableHead;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ListUtils {
    /**
     * 引用 拼接新数据
     *
     * @param menuIds
     * @param mId
     * @return
     */
    public static String reference(String menuIds, String mId) {
        String mIds[] = menuIds.split(",");
        List<String> newMenuList = new ArrayList<>(Arrays.asList(mIds));
        newMenuList.add(mId);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newMenuList.size(); i++) {
            sb.append(newMenuList.get(i));
            sb.append(",");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * 两个List比较 顺序不一样也没事
     *
     * @param oneList
     * @param twoList
     * @return
     */
    public static boolean equalList(List<String> oneList, List twoList) {
        if (twoList == null) {
            return false;
        }
        if (oneList.size() != twoList.size()) {
            return false;
        } else {
            return oneList.containsAll(twoList);
        }
    }

    /**
     * 两个List比较 顺序也必须一样
     *
     * @return
     */
    public static boolean eqOrderList(List<String> sqlList, List<String> fileList) {
        if (fileList == null) {
            return false;
        }
        if (sqlList.size() != fileList.size()) {
            return false;
        }
        for (int i = 0; i < sqlList.size(); i++) {
            System.out.println(fileList.get(i).trim());
            if (!(sqlList.get(i).trim()).equals(StrUtils.specialUnicode(fileList.get(i).trim()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断 List是否为空 或者 size小于0
     */
    public static boolean isList(List<?> objList) {
        return objList != null && objList.size() > 0;
    }

    /**
     * 泛型List
     *
     * @param <T>
     * @return
     */
    public static <T> T listT(List<?> tList) {
        return (T) tList;
    }

    /**
     * 重新排序 获得数组
     *
     * @param strMid
     * @param strTopOrder 之前数据库查出来的数组
     * @param i
     * @param sort
     * @return
     */
    public static String[] getArr(String[] strMid, String[] strTopOrder, int i, TableHead sort) {
        String[] strNewTopOrder = new String[strMid.length];
        for (int j = 0; j < strNewTopOrder.length; j++) {
            //把 strTopOrder 赋值给strNewTopOrder
            //  system.out.println(strTopOrder.length);
            if (strTopOrder.length > j) {
                strNewTopOrder[j] = strTopOrder[j];
            } else {
                strNewTopOrder[j] = null;
            }
            if (j == i) {
                strNewTopOrder[j] = sort.getIndex().toString();
            }
        }
        return strNewTopOrder;
    }

    /**
     * 来比较一个List中是否有一样的值
     *
     * @param list
     * @return
     */
    public static boolean isRepeat(List<?> list) {
        return list.size() != new HashSet<>(list).size();
    }


    //比较两个list
    //取出存在oneList中，但存在twoList中的数据，差异数据放入differentList
    public static Map<String, List<Integer>> listCompare(List<Integer> oneList, List<Integer> twoList) {
        // 交集 一样的值
        List<Integer> intersection = oneList.stream().filter(twoList::contains).collect(toList());
        // 差集 (list1 - list2) 不一样的值
        List<Integer> reduce = oneList.stream().filter(item -> !twoList.contains(item)).collect(toList());

        Map<String, List<Integer>> listMap = new HashMap<>();
        //0代表下面的ID是不能删除的父菜单 1代表的值是可以删除的父级
        listMap.put("1", new ArrayList<>(reduce));
        listMap.put("0", new ArrayList<>(intersection));
        return listMap;
    }

}


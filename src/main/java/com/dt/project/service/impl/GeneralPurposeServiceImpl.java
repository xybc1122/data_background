package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.GeneralPurposeMapper;
import com.dt.project.service.GeneralPurposeService;
import com.dt.project.utils.JsonUtils;
import com.dt.project.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class GeneralPurposeServiceImpl implements GeneralPurposeService {
    @Autowired
    private GeneralPurposeMapper generalPurposeMapper;

    @Override
    public int serviceDeleteByGeneral(List ids, String table, String thisId) {
        return generalPurposeMapper.deleteByGeneral(ids, table, thisId);
    }

    @Override
    public List<Integer> serviceSelIsNull(List ids, String table, String thisId) {
        return generalPurposeMapper.selIsNull(ids, table, thisId);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public ResponseBase universalDelete(Map<String, Object> objectMap) {
        List<Integer> dleParentKey = (List<Integer>) objectMap.get("delParentKey");
        List<Integer> delChildKey = (List<Integer>) objectMap.get("delChildKey");
        //删除父表
        Map<String, List<Integer>> thisMap = delParent(dleParentKey, (String) objectMap.get("table"),
                (String) objectMap.get("thisId"), (String) objectMap.get("childTable"));
        if (delChildKey != null && delChildKey.size() > 0) {
            //删除子表
            serviceDeleteByGeneral(delChildKey, (String) objectMap.get("childTable"), (String) objectMap.get("childThisId"));
        }
        return JsonData.setResultSuccess("success", thisMap);
    }


    /**
     * 删除父级接口
     *
     * @param printList
     * @param table
     * @param thisId
     * @return
     */
    public Map<String, List<Integer>> delParent(List<Integer> printList, String table, String thisId, String childTable) {
        if (printList == null || printList.size() <= 0) {
            return null;
        }
        List<Integer> idList = serviceSelIsNull(printList, childTable, thisId);
        if (idList != null && idList.size() > 0) {
            //比较取出不一样的值
            Map<String, List<Integer>> listMap = ListUtils.listCompare(printList, idList);
            //删除不一样的值 如果里面不为 NULL
            List<Integer> integers = listMap.get("1");
            if (integers != null && integers.size() > 0) {
                int result = serviceDeleteByGeneral(listMap.get("1"), table,
                        thisId);
                JsonUtils.saveResult(result);
            }
            return listMap;
        } else {
            int result = serviceDeleteByGeneral(printList, table,
                    thisId);
            JsonUtils.saveResult(result);
            return null;
        }
    }


}

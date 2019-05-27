package com.dt.project.utils;

import com.dt.project.oa.model.Auditor;
import org.activiti.engine.history.HistoricVariableInstance;

import java.lang.reflect.Field;
import java.util.List;

/**
 * activiti中使用得到的工具方法
 *
 * @author Created by yawn on 2018-01-10 16:32
 */
public class ActivitiUtil {

    /**
     * 将历史参数列表设置到实体中去
     *
     * @param entity          实体
     * @param varInstanceList 历史参数列表
     */

    public static <T> Auditor setVars(T entity, List<HistoricVariableInstance> varInstanceList) {
        Object p1 = null;
        try {
            Class<?> tClass = entity.getClass();
            Class<?> aClass = Auditor.class;
            p1 = aClass.newInstance();
            for (HistoricVariableInstance varInstance : varInstanceList) {
                Field[] tFields = tClass.getDeclaredFields();
                String varName = varInstance.getVariableName();
                Object varV = varInstance.getValue();
                //先设置传进来的bean
                if (setObj(tFields, varName, varV, tClass, entity)) {
                    continue;
                }
                //然后在设置 对象 里面的对象的bean
                Field[] aFields = aClass.getDeclaredFields();
                setObj(aFields, varName, varV, aClass, p1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Auditor) p1;
    }

    private static <T> boolean setObj(Field[] fields, String varName, Object varV, Class<?> c, T entity) throws NoSuchFieldException, IllegalAccessException {
        for (Field t : fields) {
            if (t.getName().equals(varName)) {
                Field field = c.getDeclaredField(varName);
                field.setAccessible(true);
                //system.out.println(varV);
                field.set(entity, varV);
                return true;
            }
        }
        return false;
    }
}
package com.dt.user.config;

import com.dt.user.customize.PermissionCheck;
import com.dt.user.utils.PermUtils;
import com.dt.user.model.Permission;
import com.dt.user.exception.LsException;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PermissionAspect
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/15 10:16
 **/

@Aspect
@Component
public class PermissionAspect {

    //定义切点
    @Pointcut("@annotation(com.dt.user.customize.PermissionCheck)")
    public void doAspect() {
    }

    //前置通知（不需要获取输入参数）
    @Before("doAspect()")
    public void doBefore(JoinPoint joinPoint) {
        // System.out.println("doBefore");

    }

    //最终通知
    @After(value = "@annotation(permissionCheck)")
    public void doAfter(JoinPoint joinPoint, PermissionCheck permissionCheck) {
        String v = permissionCheck.value();
        if (StringUtils.isNotBlank(v)) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = requestAttributes.getRequest();
                //获取角色跟权限
                Permission per = PermUtils.doGetPerm(request);
                int strIndex = v.indexOf(",");
                //说明只有多个权限
                if (strIndex != -1) {
                    String[] perm = v.split(",");
                    //如果 接口的权限长度 比 用户长
                    if (perm.length > per.getPermissions().size()) {
                        throw new LsException("无权操作");
                    }
                    for (String strPerm : perm) {
                        boolean isTrue = false;
                        for (String strPer : per.getPermissions()) {
                            if (strPer.equals(strPerm)) {
                                isTrue = true;
                                break;
                            }
                        }
                        if (!isTrue) {
                            throw new LsException("无权操作");
                        }
                    }
                    //正常
                    return;
                }
                //说明只有一个权限
                for (String strPer : per.getPermissions()) {
                    //这里只要有个一个对上了 直接return 说明已经授权
                    if (v.equals(strPer)) {
                        //正常
                        return;
                    }
                }
            }
            throw new LsException("request is Null");
        }
        throw new LsException("权限参数 is Null");

    }

    //后置通知(不需要获取返回值)
    @AfterReturning("doAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {

        // System.out.println("AfterReturning......");
    }

    //例外通知(不需要异常信息)
    @AfterThrowing("doAspect()")
    public void doAfterThrowing() {

        // System.out.println("AfterThrowing......");
    }

    //环绕通知
    @Around("doAspect()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("环绕通知进入方法");
        Object object = pjp.proceed();
//        System.out.println("环绕通知退出方法");
        return object;
    }

}

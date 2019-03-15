package com.dt.user.exception;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理控制器
 */
@RestControllerAdvice
public class LsExceptionHandler {

    /**
     * 没有权限抛出异常
     *
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseBase Handler(Exception e) {
        if (e instanceof LsException) {
            //自定义异常
            LsException lsException = (LsException) e;
            return JsonData.setResultError(lsException.getMsg());
        }
        System.out.println(e.getMessage());
        return JsonData.setResultError("全局异常，未知错误");
    }
}

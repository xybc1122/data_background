package com.dt.user.exception;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

/**
 * 异常处理控制器
 */
@RestControllerAdvice
public class LsExceptionHandler {

    /**
     * 自定义异常拦截
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseBase Handler(Exception e) {
        if (e instanceof LsException) {
            //自定义异常
            LsException lsException = (LsException) e;
            return JsonData.setResultError(lsException.getMsg());
        } else if (e instanceof SQLException) {
            System.out.println(e.getMessage());
            return JsonData.setResultError("数据库存入异常,请联系管理员");
            //多线程 包装异常
        } else if (e instanceof ExecutionException) {
            return JsonData.setResultError("多线程数据处理中断" + e.getMessage());
        }
        System.out.println(e.getMessage());
        return JsonData.setResultError("全局异常，未知错误");
    }
}

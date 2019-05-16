package com.dt.project.exception;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        } else if (e instanceof BadSqlGrammarException) {
            System.out.println(e.getMessage());
            return JsonData.setResultError("SQL异常");
        } else if (e instanceof ExecutionException) {
            return JsonData.setResultError("多线程数据处理中断" + e.getMessage());
        } else if (e instanceof NullPointerException) {
            return JsonData.setResultError("空指针异常,请检查参数" + e.getMessage());
        }
        System.out.println(e.getMessage());
        return JsonData.setResultError("全局异常，未知错误");
    }
}

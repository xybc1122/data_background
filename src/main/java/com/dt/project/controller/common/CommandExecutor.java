package com.dt.project.controller.common;

/**
 * @ClassName CommandExecutor
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 15:15
 **/
public interface CommandExecutor {

    /**
     * 执行命令
     */
    <T> T execute(Command<T> command);
}

package com.dt.project.controller.common;

/**
 * @ClassName Command
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 15:02
 **/
public interface Command<T> {
    /**
     * 执行命令
     *
     * @return
     */
    T execute(CommandContext commandContext);

}

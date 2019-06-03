package com.dt.project.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName CommandContext
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 15:12
 **/
public class CommandContext {


    private static final Logger LOGGER = LoggerFactory.getLogger(CommandContext.class);

    protected Command<?> command; //命令

    public CommandContext(Command<?> command) {
        this.command = command;
    }
}

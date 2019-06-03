package com.dt.project.controller.common;

/**
 * @ClassName CRUD
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/3 16:47
 **/
public abstract class CRUD {

    /**
     * 增
     */
    public abstract void save(Command<?> command);

    /**
     * 删
     */
    public abstract void del(Command<?> command);

    /**
     * 改
     */
    public abstract void up(Command<?> command);


    /**
     * 查
     */
    public abstract void sel(Command<?> command);
}

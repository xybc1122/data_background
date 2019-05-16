package com.dt.project.netty;

public enum ChatType {
    /**
     * 寄存频道
     */
    REGISTER,
    /**
     * 踢出频道
     */
    KICK_OUT,
    /**
     * 进度条频道
     */
    PROGRESS_BAR;

    public static void main(String[] args) {
        System.out.println(ChatType.REGISTER);
    }
}

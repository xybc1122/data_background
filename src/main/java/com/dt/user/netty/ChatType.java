package com.dt.user.netty;

public enum ChatType {

    REGISTER, SINGLE_SENDING, GROUP_SENDING, FILE_MSG_SINGLE_SENDING, FILE_MSG_GROUP_SENDING, KICK_OUT,PROGRESS_BAR;

    public static void main(String[] args) {
        System.out.println(ChatType.REGISTER);
    }
}

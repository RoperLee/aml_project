package com.antimoney.boot.vo;

import com.antimoney.boot.model.User;

import java.util.List;

/**
 * Created by roper on 2017/6/9.
 */
public class RankListVo {
    private User self;
    private List<User> userList;

    public User getSelf() {
        return self;
    }

    public void setSelf(User self) {
        this.self = self;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

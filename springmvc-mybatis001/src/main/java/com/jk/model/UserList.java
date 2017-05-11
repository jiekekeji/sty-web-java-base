package com.jk.model;

import java.util.List;

/**
 * Created by Handsome on 2017/5/11.
 */
public class UserList {
    private String type;

    @Override
    public String toString() {
        return "UserList{" +
                "type='" + type + '\'' +
                ", users=" + users +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}

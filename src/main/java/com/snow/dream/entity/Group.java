package com.snow.dream.entity;

import java.util.List;

/**
 * Created by edward on 17/10/2.
 */
public class Group {
    String id;
    String name;
    List<String> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}

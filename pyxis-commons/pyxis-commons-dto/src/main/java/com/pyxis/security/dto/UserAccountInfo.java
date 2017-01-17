package com.pyxis.security.dto;

import com.pyxis.core.dto.BaseInfo;

public class UserAccountInfo extends BaseInfo {

    private String username;
    private String password;

    @Override
    public String getType() {
        return "useraccount";
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}

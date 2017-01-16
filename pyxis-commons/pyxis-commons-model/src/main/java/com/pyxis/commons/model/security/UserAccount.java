package com.pyxis.commons.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pyxis.commons.model.BaseEntity;

@Entity(name = "user_account")
public class UserAccount extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

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

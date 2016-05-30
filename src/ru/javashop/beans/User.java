package ru.javashop.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Created by Admin on 30.05.2016.
 */

@ManagedBean
@SessionScoped
public class User {
    private String username;

    public User () {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

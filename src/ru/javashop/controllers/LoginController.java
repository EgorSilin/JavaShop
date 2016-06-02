package ru.javashop.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Admin on 01.06.2016.
 */

@ManagedBean
@RequestScoped
public class LoginController {
    public LoginController (){

    }

    public String login () {
        return "login";
    }
}

package com.ixzus.xpro.entity;

/**
 * Created by metro on 2016/4/21.
 */
public class XBean {
    private String name;
    private String pwd;

    public XBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }


    public String getPwd() {
        return pwd;
    }

}

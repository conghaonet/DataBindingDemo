package com.app2m.modulea.bean;

import java.io.Serializable;

/**
 * Created by CongHao on 2017/2/24.
 * E-mail: hao.cong@app2m.com
 */

public class User implements Serializable {
    private String name;
    private int age;
    private boolean isMarried;
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + isMarried + "]";
    }
}

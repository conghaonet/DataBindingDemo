package com.app2m.modulea.binding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.Date;
import java.util.List;

/**
 * Created by CongHao on 2017/2/24.
 * E-mail: hao.cong@app2m.com
 */

public class User extends BaseObservable {
    private String name;
    private int age;
    private boolean married;
    private String avatar;
    private Date birthday;
    private List<String> cities;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Bindable
    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Bindable
    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

}

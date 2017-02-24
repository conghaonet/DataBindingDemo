package com.app2m.modulea.vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by CongHao on 2017/2/24.
 * E-mail: hao.cong@app2m.com
 */

public class UserVM extends BaseObservable {
    private String name;
    private int age;
    private boolean isMarried;
    private String avatar;

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
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

/*
    @BindingAdapter({"bind:avatar"})
    public void loadImage(ImageView view, String avatar) {
        Toast.makeText(view.getContext(), "aaaa", Toast.LENGTH_SHORT).show();
    }
*/
}

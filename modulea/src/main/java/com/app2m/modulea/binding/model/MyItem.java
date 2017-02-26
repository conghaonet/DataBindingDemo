package com.app2m.modulea.binding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by CongHao on 2017/2/26.
 * E-mail: hao.cong@app2m.com
 */

public class MyItem extends BaseObservable {

    private String imageUrl;
    private String imageName;
    private int index;

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Bindable
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

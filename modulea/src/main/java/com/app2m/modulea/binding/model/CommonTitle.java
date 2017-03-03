package com.app2m.modulea.binding.model;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import java.util.logging.Logger;

/**
 * Created by CongHao on 2017/2/28.
 * E-mail: hao.cong@app2m.com
 */

public class CommonTitle extends BaseObservable {
    @DrawableRes
    private int leftImageId = android.R.drawable.arrow_up_float;
    private Bitmap leftBitmap;

    @StringRes
    private int rightTextId;
    private String rightTextStr;

    @StringRes
    private int titleId;
    private String titleStr;

    public CommonTitle(Resources res, String title) {
        try {
            this.leftBitmap = BitmapFactory.decodeResource(res, leftImageId);
        } catch (Resources.NotFoundException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
        this.titleStr = title;
    }

    public int getLeftImageId() {
        return leftImageId;
    }

    public void setLeftImageId(Resources res, int leftImageId) {
        this.leftImageId = leftImageId;
        try {
            this.leftBitmap = BitmapFactory.decodeResource(res, this.leftImageId);
        } catch (Resources.NotFoundException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
    }

    @Bindable
    public Bitmap getLeftBitmap() {
        return leftBitmap;
    }

    public void setLeftBitmap(Bitmap leftBitmap) {
        this.leftBitmap = leftBitmap;
    }

    public int getRightTextId() {
        return rightTextId;
    }

    public void setRightTextId(Resources res, int rightTextId) {
        this.rightTextId = rightTextId;
        try {
            this.rightTextStr = res.getString(this.rightTextId);
        } catch (Resources.NotFoundException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
    }

    @Bindable
    public String getRightTextStr() {
        return rightTextStr;
    }

    public void setRightTextStr(String rightTextStr) {
        this.rightTextStr = rightTextStr;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(Resources res, @StringRes int titleId) {
        this.titleId = titleId;
        try {
            this.titleStr = res.getString(this.titleId);
        } catch (Resources.NotFoundException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
    }

    @Bindable
    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }
}

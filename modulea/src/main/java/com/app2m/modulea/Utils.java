package com.app2m.modulea;

import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CongHao on 2017/2/26.
 * E-mail: hao.cong@app2m.com
 */

public class Utils {
    private Utils() {
        throw new IllegalAccessError("Can not access the method.");
    }
    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(date);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

}

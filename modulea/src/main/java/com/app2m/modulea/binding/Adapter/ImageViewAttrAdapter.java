package com.app2m.modulea.binding.Adapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.app2m.modulea.binding.model.User;
import com.bumptech.glide.Glide;

/**
 * Created by CongHao on 2017/2/25.
 * E-mail: hao.cong@app2m.com
 */

public class ImageViewAttrAdapter {
    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter({"imageUrl", "placeHolder"})
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .into(imageView);
    }
    @BindingAdapter({"imageUrl", "placeHolder"})
    public static void loadImage(ImageView imageView, User user, Drawable holderDrawable) {
        Glide.with(imageView.getContext())
                .load(user.getAvatar())
                .placeholder(holderDrawable)
                .into(imageView);
    }

}

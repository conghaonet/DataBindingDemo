package com.app2m.modulea;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingAdapter;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.app2m.modulea.bean.User;
import com.app2m.modulea.databinding.ActivityModuleABinding;
import com.app2m.modulea.handler.UserHandler;
import com.app2m.modulea.vm.UserVM;
import com.bumptech.glide.Glide;

public class ModuleAActivity extends AppCompatActivity {

    private UserVM user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityModuleABinding binding = DataBindingUtil.setContentView(this, R.layout.activity_module_a);
        user = new UserVM();
        user.setName("张三");
        user.setAge(28);
        user.setMarried(true);
        user.setAvatar("http://cs.101.com/v0.1/static/sdp_nd/slp-student-android/app_ico/ico_pfs15hzc.png");
        binding.setUser(user);

        binding.setResImgId(R.drawable.btn_retry);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.btn_share);
        binding.setResBitmap(bitmap);

        UserHandler handler = new UserHandler();
        binding.setHandler(handler);
    }
    /*@BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }
    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }
    @BindingAdapter({"imageUrl", "placeHolder"})
    public static void loadImage(ImageView imageView, UserVM user, Drawable holderDrawable) {
        Glide.with(imageView.getContext())
                .load(user.getAvatar())
                .placeholder(holderDrawable)
                .into(imageView);
    }*/

}

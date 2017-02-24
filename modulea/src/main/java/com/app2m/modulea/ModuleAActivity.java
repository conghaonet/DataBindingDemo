package com.app2m.modulea;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingAdapter;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
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

        UserHandler handler = new UserHandler();
        binding.setHandler(handler);


    }

/*
    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(R.drawable.ic_launcher);
        view.setImageResource(resId);
    }
*/
/*
    @BindingAdapter({"bind:avatar"})
    public static void loadImage(ImageView view, String avatar) {
        Toast.makeText(view.getContext(), "aaaa", Toast.LENGTH_SHORT).show();
    }


    public class Presenter {
        public void onClick(View view) {
            Toast.makeText(ModuleAActivity.this, "点到了", Toast.LENGTH_SHORT).show();
        }
    }
*/
}

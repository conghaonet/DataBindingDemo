package com.app2m.modulea;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.databinding.ViewDataBinding;
import com.app2m.modulea.databinding.ActivityModuleABinding;
import com.app2m.modulea.handler.UserHandler;
import com.app2m.modulea.vm.UserVM;

import java.util.Arrays;

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
        user.setCities(Arrays.asList("北京", "天津", "上海", "重庆"));
        binding.setUser(user);
        binding.setResImgId(R.drawable.btn_retry);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.btn_share);
        binding.setResBitmap(bitmap);

        binding.mySwitch.setText("mySwitch");

        UserHandler handler = new UserHandler();
        binding.setHandler(handler);
    }
    public void close(View view) {
        Toast.makeText(view.getContext(), "关闭了", Toast.LENGTH_SHORT).show();
        finish();
    }
}

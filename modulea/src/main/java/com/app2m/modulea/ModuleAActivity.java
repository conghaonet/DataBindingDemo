package com.app2m.modulea;

import android.databinding.ViewDataBinding;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.app2m.modulea.binding.model.User;
import com.app2m.modulea.databinding.ActivityModuleABinding;
import com.app2m.modulea.handler.UserHandler;

import java.util.Arrays;
import java.util.Date;

public class ModuleAActivity extends AppCompatActivity {

    private final User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityModuleABinding binding = DataBindingUtil.setContentView(this, R.layout.activity_module_a);
        UserHandler handler = new UserHandler(this, user);
        binding.setHandler(handler);

        user.setAge(28);
        user.setMarried(true);
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setAvatar("http://cs.101.com/v0.1/static/sdp_nd/slp-student-android/app_ico/ico_pfs15hzc.png");
        user.setCities(Arrays.asList("北京", "天津", "上海", "重庆"));
        binding.setUser(user);

        binding.setResImgId(R.drawable.btn_retry);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.btn_share);
        binding.setResBitmap(bitmap);

        binding.mySwitch.setText("mySwitch");
        binding.mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(buttonView.getContext(), "mySwitch is "+ buttonView.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}

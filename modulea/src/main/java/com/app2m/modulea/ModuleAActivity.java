package com.app2m.modulea;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.app2m.modulea.binding.model.CommonTitle;
import com.app2m.modulea.binding.model.User;
import com.app2m.modulea.databinding.ActivityModuleABinding;
import com.app2m.modulea.handler.UserHandler;

import java.util.Arrays;
import java.util.Date;

public class ModuleAActivity extends BaseBindingActivity {

    private final User user = new User();
    private ActivityModuleABinding binding;
    private CommonTitle commonTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_module_a);
        UserHandler handler = new UserHandler(this, user);
        binding.setHandler(handler);
        binding.setActivity(this);
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

//        setCommonTitleView(binding.myViewStub, "ModuleAActivity");
        commonTitle = new CommonTitle(getResources(), "CommonTitle");
        commonTitle.setLeftImageId(getResources(), R.drawable.btn_retry);
        commonTitle.setRightTextId(getResources(), R.string.age_label);
        setCommonTitleView(binding.myViewStub, commonTitle);
    }

    @Override
    public void onClickTitleBack(View view) {
        commonTitle.setTitleStr("title changed!!");
        commonTitle.notifyChange();
        Toast.makeText(this, "Clicked back", Toast.LENGTH_SHORT).show();
    }

}

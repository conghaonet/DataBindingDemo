package com.app2m.modulea;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app2m.modulea.bean.User;
import com.app2m.modulea.databinding.ActivityModuleABinding;

public class ModuleAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityModuleABinding binding = DataBindingUtil.setContentView(this, R.layout.activity_module_a);
        User user =new User();
        user.setName("张三");
        user.setAge(28);
        user.setMarried(true);
        binding.setUser(user);
    }
}

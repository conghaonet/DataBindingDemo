package com.app2m.modulea.handler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.app2m.modulea.vm.UserVM;

/**
 * Created by CongHao on 2017/2/24.
 * E-mail: hao.cong@app2m.com
 */

public class UserHandler {

    public void addAge(View view, UserVM viewModel) {
        Toast.makeText(view.getContext(), "点击了", Toast.LENGTH_SHORT).show();
        viewModel.setAge(viewModel.getAge() + 10);
        viewModel.setAvatar("http://img.knowledge.csdn.net/upload/base/1452500783406_406.jpg");
        viewModel.notifyChange();
    }

}

package com.app2m.modulea.handler;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.app2m.modulea.R;
import com.app2m.modulea.binding.model.User;

import java.util.logging.Logger;

/**
 * Created by CongHao on 2017/2/24.
 * E-mail: hao.cong@app2m.com
 */
public class UserHandler {
    private Context mContext;
    private User mUser;
    public UserHandler(Context context, User user) {
        mContext = context;
        mUser = user;
    }

    public void addAge(View view) {
        Toast.makeText(view.getContext(), "点击了", Toast.LENGTH_SHORT).show();
        mUser.setAge(mUser.getAge() + 10);
        mUser.setAvatar("http://img.knowledge.csdn.net/upload/base/1452500783406_406.jpg");
        mUser.notifyChange();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position) {
        if(parent.getTag(R.id.tag_view_init) == null) {
            parent.setTag(R.id.tag_view_init, new Object());
        } else {
            Toast.makeText(view.getContext(), parent.getAdapter().getItem(position).toString(), Toast.LENGTH_LONG).show();
            mUser.notifyChange();
        }
    }

    public void userNameChanged(Editable s) {
        Logger.getAnonymousLogger().info(s.toString());
        mUser.notifyChange();
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getTag(R.id.tag_view_init) == null) {
            buttonView.setTag(R.id.tag_view_init, new Object());
        } else {
            mUser.notifyChange();

        }
    }

    public void closeSelf(View view) {
        Toast.makeText(mContext, "关闭了", Toast.LENGTH_SHORT).show();
        ((Activity)mContext).finish();
    }
}

package com.app2m.modulea.handler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.app2m.modulea.binding.model.MyItem;

/**
 * Created by CongHao on 2017/2/26.
 * E-mail: hao.cong@app2m.com
 */

public class MyItemHandler {
/*
    private Context mContext;
    public MyItemHandler(Context context) {
        mContext = context;
    }
*/

    public void onClickItem(View view) {
        Toast.makeText(view.getContext(), "click a item", Toast.LENGTH_SHORT).show();
    }
    public void onClickImageView(View view, MyItem item) {
        Toast.makeText(view.getContext(), item.getImageUrl()+"", Toast.LENGTH_SHORT).show();
    }
}

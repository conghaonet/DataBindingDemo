package com.app2m.modulea.handler;

import android.content.Context;
import android.widget.Toast;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

/**
 * Created by CongHao on 2017/2/26.
 * E-mail: hao.cong@app2m.com
 */

public class SwipyRefreshLayoutHandler {
    private Context mContext;
    public SwipyRefreshLayoutHandler(Context context) {
        mContext = context;
    }

    public void refreshing(SwipyRefreshLayoutDirection direction) {
        Toast.makeText(mContext, "direction = "+direction, Toast.LENGTH_SHORT).show();
    }

}

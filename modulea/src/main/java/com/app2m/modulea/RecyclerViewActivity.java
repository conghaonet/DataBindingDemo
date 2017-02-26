package com.app2m.modulea;

import android.databinding.ViewDataBinding;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.app2m.modulea.adapter.MyItemAdapter;
import com.app2m.modulea.binding.model.MyItem;
import com.app2m.modulea.databinding.ActivityRecyclerViewBinding;
import com.app2m.modulea.handler.SwipyRefreshLayoutHandler;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private final List<MyItem> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<String> images = Arrays.asList(MyConstants.IMAGES_URL);
        int index = 0;
        for (String imageUrl: images) {
            MyItem myItem = new MyItem();
            myItem.setImageUrl(imageUrl);
            myItem.setImageName(imageUrl.substring(imageUrl.lastIndexOf('/')+1));
            myItem.setIndex(index++);
            mData.add(myItem);
        }
        binding.myRecyclerView.addItemDecoration(new DividerGridItemDecoration(this, R.drawable.divider_knowledge_grid));
        binding.myRecyclerView.setAdapter(new MyItemAdapter(mData));
        binding.setHandler(new SwipyRefreshLayoutHandler(this));

        binding.swipyrefreshlayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {

            }
        });

    }
}

package com.app2m.modulea;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.app2m.modulea.adapter.MyItemAdapter;
import com.app2m.modulea.binding.model.MyItem;
import com.app2m.modulea.databinding.ActivityRecyclerViewBinding;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private final List<MyItem> mData = new ArrayList<>();
    private final static int ROWS_PER_LOADING = 20;
    private final static List<String> IMAGES = Arrays.asList(MyConstants.IMAGES_URL);
    private ActivityRecyclerViewBinding binding;
    private MyItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        binding.myRecyclerView.addItemDecoration(new DividerGridItemDecoration(this, R.drawable.divider_knowledge_grid));
        adapter = new MyItemAdapter(mData);
        binding.myRecyclerView.setAdapter(adapter);
        binding.setHandler(this);

        binding.swipyrefreshlayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
//                binding.loadingLayout.setVisibility(View.VISIBLE);
                if (direction == SwipyRefreshLayoutDirection.TOP) {
                    loadData(0);
                } else if(direction == SwipyRefreshLayoutDirection.BOTTOM) {
                    loadData(mData.size());
                }
            }
        });
        binding.loadingLayout.setVisibility(View.GONE);
        loadData(0);


    }
    public void loadData(final int startPosition) {
        if(startPosition < IMAGES.size()-1) {
            if(startPosition == 0) {
                mData.clear();
            }
            int lastPosition = startPosition + ROWS_PER_LOADING < IMAGES.size() ? startPosition + ROWS_PER_LOADING : IMAGES.size();
            for(int i=startPosition;i<lastPosition;i++) {
                MyItem myItem = new MyItem();
                myItem.setImageUrl(IMAGES.get(i));
                myItem.setImageName(IMAGES.get(i).substring(IMAGES.get(i).lastIndexOf('/')+1));
                myItem.setIndex(i);
                mData.add(myItem);
            }
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(RecyclerViewActivity.this, "No more data!", Toast.LENGTH_LONG).show();
        }
        binding.swipyrefreshlayout.setRefreshing(false);
//        binding.loadingLayout.setVisibility(View.GONE);
    }
}

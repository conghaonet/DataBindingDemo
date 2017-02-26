package com.app2m.modulea.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app2m.modulea.R;
import com.app2m.modulea.binding.model.MyItem;
import com.app2m.modulea.handler.MyItemHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CongHao on 2017/2/26.
 * E-mail: hao.cong@app2m.com
 */

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.ViewHolder> {
    private final List<MyItem> mData;

    public MyItemAdapter(List<MyItem> data) {
        mData=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), R.layout.my_item, parent, false);
        //添加监听器
        binding.setVariable(com.app2m.modulea.BR.handler, new MyItemHandler());
        ViewHolder holder = new ViewHolder(binding.getRoot());
        holder.setBinding(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setVariable(com.app2m.modulea.BR.item, mData.get(position));
        //refresh UI right know
//        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
        }
        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }
    }
}

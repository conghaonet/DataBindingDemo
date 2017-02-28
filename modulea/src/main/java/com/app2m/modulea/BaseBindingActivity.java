package com.app2m.modulea;

import android.databinding.DataBindingUtil;
import android.databinding.ViewStubProxy;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;

import com.app2m.modulea.binding.model.CommonTitle;
import com.app2m.modulea.databinding.CommonTitleBarBinding;

public class BaseBindingActivity extends AppCompatActivity {

    private ViewStubProxy mTitleStubProxy;
    private CommonTitle mCommonTitle;
    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setCommonTitleView(ViewStubProxy stubProxy, @StringRes final int title) {
        setCommonTitleView(stubProxy, getString(title));
    }
    public void setCommonTitleView(ViewStubProxy stubProxy, final String title) {
        if(mTitleStubProxy != null) {
            return;
        }
        mTitleStubProxy = stubProxy;
        mTitleStubProxy.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                CommonTitleBarBinding viewStubBinding = DataBindingUtil.bind(inflated);
                mCommonTitle = new CommonTitle(getResources(), title);
                viewStubBinding.setCommonTitle(mCommonTitle);
            }
        });
        inflate(mTitleStubProxy);
    }
    public void setCommonTitleView(ViewStubProxy stubProxy, final CommonTitle commonTitle) {
        if(mTitleStubProxy != null) {
            return;
        }
        this.mCommonTitle = commonTitle;
        mTitleStubProxy = stubProxy;
        mTitleStubProxy.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                CommonTitleBarBinding viewStubBinding = DataBindingUtil.bind(inflated);
                viewStubBinding.setCommonTitle(mCommonTitle);
            }
        });
        inflate(mTitleStubProxy);
    }
    private void inflate(ViewStubProxy stubProxy) {
        if (!stubProxy.isInflated()) {
            stubProxy.getViewStub().inflate();
        }
    }

    public void setCommonTitle(String title) {
        mCommonTitle.setTitleStr(title);
        mCommonTitle.notifyChange();
    }

    public void onClickTitle(View view) {
        Toast.makeText(this, "CommonTitleBar of BaseBindingActivity", Toast.LENGTH_SHORT).show();
    }
    public void onClickTitleBack(View view) {
        this.finish();
    }
}

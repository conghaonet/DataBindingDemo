package com.app2m.databindingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app2m.modulea.ModuleAActivity;
import com.app2m.modulea.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickModuleAActivity(View view) {
        startActivity(new Intent(this, ModuleAActivity.class));
    }

    public void onClickRecyclerViewActivity(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}

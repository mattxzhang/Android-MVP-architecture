package com.kai.android_mvp_architecture.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kai.android_mvp_architecture.view.BaseView;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

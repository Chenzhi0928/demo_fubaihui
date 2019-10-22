package com.cheng.fubaihui.frame;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    public Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initMvp();
        initData();
        initListener();
        return view;
    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initMvp() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutId();


    public void showLog(String msg){
        Log.d(getClass().getSimpleName(),msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

package com.cheng.fubaihui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cheng.fubaihui.activity.LoginActivity;
import com.cheng.fubaihui.frame.BaseMvpActivity;
import com.cheng.fubaihui.frame.ICommonModel;
import com.cheng.fubaihui.model.CommonModel;

import butterknife.BindView;
import butterknife.OnClick;

public class HomePage_activity extends BaseMvpActivity {

    private static final String TAG = "HomePage_activity";
    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected ICommonModel initModel() {
        return new CommonModel();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(int whichApi, Object[] successResult) {
        Log.i(TAG, "onSuccess: " + successResult.length);
    }

    @OnClick(R.id.tv)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv:
                startActivity(new Intent(HomePage_activity.this,LoginActivity.class));
                break;
        }
    }
}

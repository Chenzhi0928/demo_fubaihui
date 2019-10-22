package com.cheng.fubaihui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cheng.fubaihui.R;
import com.cheng.fubaihui.frame.BaseMvpActivity;
import com.cheng.fubaihui.frame.ICommonModel;
import com.cheng.fubaihui.model.CommonModel;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPawActivity extends BaseMvpActivity {

    @BindView(R.id.layout_black)
    LinearLayout mLayoutBlack;
    @BindView(R.id.register_toolbar)
    Toolbar mRegisterToolbar;
    @BindView(R.id.tv_tishi1)
    TextView mTvTishi1;
    @BindView(R.id.tv_tishi2)
    TextView mTvTishi2;
    @BindView(R.id.tv_tishi3)
    TextView mTvTishi3;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_yanzhengma)
    EditText mEtYanzhengma;
    @BindView(R.id.bt_sendcode)
    Button mBtSendcode;
    @BindView(R.id.et_paw)
    EditText mEtPaw;
    @BindView(R.id.img_visibility)
    ImageView mImgVisibility;
    @BindView(R.id.bt_submit)
    Button mBtSubmit;

    @Override
    protected ICommonModel initModel() {
        return new CommonModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_paw;
    }

    @Override
    public void onSuccess(int whichApi, Object[] successResult) {

    }

    @Override
    protected void initView() {
        mRegisterToolbar.setTitle("");
        setSupportActionBar(mRegisterToolbar);
    }

    /*
     * 左上角返回键
     * */
    private void black() {
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }



    @OnClick({R.id.layout_black, R.id.tv_tishi1, R.id.tv_tishi2, R.id.tv_tishi3, R.id.et_name, R.id.et_yanzhengma, R.id.bt_sendcode, R.id.et_paw, R.id.img_visibility, R.id.bt_submit})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.layout_black:
                black();
                break;
            case R.id.tv_tishi1:
                break;
            case R.id.tv_tishi2:
                break;
            case R.id.tv_tishi3:
                break;
            case R.id.et_name:
                break;
            case R.id.et_yanzhengma:
                break;
            case R.id.bt_sendcode:
                break;
            case R.id.et_paw:
                break;
            case R.id.img_visibility:
                break;
            case R.id.bt_submit:
                break;
        }
    }
}

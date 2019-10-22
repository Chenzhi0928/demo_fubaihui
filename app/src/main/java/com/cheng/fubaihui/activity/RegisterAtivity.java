package com.cheng.fubaihui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cheng.fubaihui.R;
import com.cheng.fubaihui.bean.RegisterBean;
import com.cheng.fubaihui.bean.SendsmsBean;
import com.cheng.fubaihui.frame.ApiConfig;
import com.cheng.fubaihui.frame.BaseMvpActivity;
import com.cheng.fubaihui.frame.ICommonModel;
import com.cheng.fubaihui.model.CommonModel;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterAtivity extends BaseMvpActivity {

    @BindView(R.id.register_toolbar)
    Toolbar mRegisterToolbar;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_yanzheng)
    EditText mEtYanzheng;
    @BindView(R.id.et_setpaw)
    EditText mEtSetpaw;
    @BindView(R.id.et_setyaoqingma)
    EditText mEtSetyaoqingma;
    @BindView(R.id.register_ck_select)
    CheckBox mRegisterCkSelect;
    @BindView(R.id.tv_xieyi)
    TextView mTvXieyi;
    @BindView(R.id.tv_go_login)
    TextView mTvGoLogin;
    @BindView(R.id.layout_black)
    LinearLayout mLayout_black;
    @BindView(R.id.bt_sendcode)
    Button mBt_sendcode;
    private Map<String, String> map = new HashMap<>();
    private Boolean isDigit;

    @Override
    protected ICommonModel initModel() {
        return new CommonModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_ativity;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mRegisterToolbar.setTitle("");
        setSupportActionBar(mRegisterToolbar);
        mTvGoLogin.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public void onSuccess(int whichApi, Object[] successResult) {
        switch (whichApi) {
            case ApiConfig.GET_USER_REGISTER_RESULT_TEST:
                RegisterBean registerBean = (RegisterBean) successResult[0];
                String msg = registerBean.getMsg();
                Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
                if (registerBean.getCode() == 200) {
                    Toast.makeText(this, "YES", Toast.LENGTH_SHORT).show();
                }
                break;
            case ApiConfig.GET_USER_PHONE_SMS_RESULT_TEST:
                SendsmsBean smsBean = (SendsmsBean) successResult[0];
                String smsContent = smsBean.getContent();
                if (smsBean.getCode() == 200) {
                    Toast.makeText(this, "短信已发送：" + smsContent, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @OnClick({ R.id.tv_xieyi, R.id.tv_go_login, R.id.layout_black, R.id.bt_register, R.id.bt_sendcode})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_sendcode:
                String mPhone = mEtName.getText().toString().trim();
                presenter.getData(ApiConfig.GET_USER_PHONE_SMS_RESULT_TEST, mPhone);
                mBt_sendcode.setEnabled(false);
                new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mBt_sendcode.setText("倒计时：" + millisUntilFinished / 1000);
                        mBt_sendcode.setTextColor(Resources.getSystem().getColor(R.color.grey_807));
                    }
                    @Override
                    public void onFinish() {
                        mBt_sendcode.setText("获取验证码");
                        mBt_sendcode.setTextColor(Resources.getSystem().getColor(R.color.colorAccent));
                        mBt_sendcode.setEnabled(true);
                    }
                }.start();
                break;
            case R.id.tv_xieyi:
                Toast.makeText(this, "尚未完善", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_go_login:
                startActivity(new Intent(RegisterAtivity.this,LoginActivity.class));
                break;
            case R.id.layout_black:
                black();
                break;
            case R.id.bt_register:
                initRegister();
                break;
        }
    }

    private void initRegister() {
        String mName = mEtName.getText().toString().trim();
        String mYanzheng = mEtYanzheng.getText().toString().trim();
        String mPaw = mEtSetpaw.getText().toString().trim();
        String mYaoqingma = mEtSetyaoqingma.getText().toString().trim();
        isDigit = false;
        //正则判断是否为手机号
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        //String pawRegex = "\"^(?![A-Z]+$)(?![a-z]+$)(?!\\\\d+$)(?![\\\\W_]+$)\\\\S{6,}$\"";
        if (mName.matches(telRegex)) {
            if (!mYanzheng.isEmpty()) {
                if (!mPaw.isEmpty() && mPaw.length() >= 6) {
                    for (int i = 0; i < mPaw.length(); i++) {
                        if (Character.isDigit(mPaw.charAt(i)) && Character.isUpperCase(mPaw.charAt(i)) || Character.isLowerCase(mPaw.charAt(i))) {
                            isDigit = true;
                        }
                    }
                    if (isDigit == true && !mYaoqingma.isEmpty()) {
                        if (mRegisterCkSelect.isChecked() == true) {
                            map.put("username", mName);
                            map.put("agree", "1");
                            map.put("password", mPaw);
                            map.put("yzm", mYanzheng);
                            map.put("recommend_code", mYaoqingma);
                            presenter.getData(ApiConfig.GET_USER_REGISTER_RESULT_TEST, map);
                        } else {
                            Toast.makeText(this, "请确认已阅读注册协议", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "邀请码不能为空", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "密码最少6位且包含数字和字母", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "验证码有误", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "号码有误", Toast.LENGTH_SHORT).show();
        }
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
}

package com.cheng.fubaihui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cheng.fubaihui.R;
import com.cheng.fubaihui.bean.LoginBean;
import com.cheng.fubaihui.frame.ApiConfig;
import com.cheng.fubaihui.frame.BaseMvpActivity;
import com.cheng.fubaihui.frame.ICommonModel;
import com.cheng.fubaihui.model.CommonModel;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity {

    @BindView(R.id.img_login)
    ImageView mImgLogin;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_paw)
    EditText mEtPaw;
    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.tv_register_now)
    TextView mTvRegisterNow;
    @BindView(R.id.tv_forget_paw)
    TextView mTvForgetPaw;
    @BindView(R.id.ck_select)
    CheckBox mCkSelect;

    @Override
    protected ICommonModel initModel() {
        return new CommonModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(int whichApi, Object[] successResult) {
        switch (whichApi) {
            case ApiConfig.GET_USER_LOGIN_RESULT_TEST:
                LoginBean loginBean = (LoginBean) successResult[0];
                String msg = loginBean.getMsg();
                Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
                if (loginBean.getCode() == 200) {
                    int uid = loginBean.getData().getUid();
                }
                break;
        }
    }

    @OnClick({R.id.bt_login, R.id.tv_register_now, R.id.tv_forget_paw})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_login:
                login();
                break;
            case R.id.tv_register_now:
                register();
                break;
            case R.id.tv_forget_paw:
                forgetPaw();
                break;
        }
    }

    /*
     * 忘记密码
     * */
    private void forgetPaw() {
        startActivity(new Intent(LoginActivity.this, ForgetPawActivity.class));
    }

    /*
     * 登陆
     * */
    private void login() {
        String mName = mEtName.getText().toString().trim();
        String mPaw = mEtPaw.getText().toString().trim();
        Map<String, String> loginMap = new HashMap<>();
        if (!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mPaw)) {
            if (mCkSelect.isChecked() == true) {
                loginMap.put("username", mName);
                loginMap.put("password", mPaw);
                presenter.getData(ApiConfig.GET_USER_LOGIN_RESULT_TEST, loginMap);
            } else {
                Toast.makeText(this, "请阅读并勾选用户协议", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     *注册
     * */
    private void register() {
        startActivity(new Intent(LoginActivity.this, RegisterAtivity.class));
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}

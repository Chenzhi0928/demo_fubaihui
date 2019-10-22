package com.cheng.fubaihui.model;

import com.cheng.fubaihui.bean.LoginBean;
import com.cheng.fubaihui.bean.RegisterBean;
import com.cheng.fubaihui.bean.SendsmsBean;
import com.cheng.fubaihui.frame.ApiConfig;
import com.cheng.fubaihui.frame.ICommonModel;
import com.cheng.fubaihui.frame.ICommonView;
import com.cheng.fubaihui.frame.NetManager;

import java.util.Map;

import io.reactivex.Observable;

public class CommonModel implements ICommonModel {

    @Override
    public void getData(final int whichApi, final ICommonView presenterCallBack, Object[] params) {
        NetManager manager = NetManager.getNetManager();
        switch (whichApi){
            case ApiConfig.GET_USER_REGISTER_RESULT_TEST:
                Observable<RegisterBean> registerObservable = manager.getNetService().getPersonRankInfo((Map<String, String>) params[0]);
                manager.method(registerObservable,presenterCallBack,whichApi);
                break;
            case ApiConfig.GET_USER_PHONE_SMS_RESULT_TEST:
                Observable<SendsmsBean> phoneSmsObservable = manager.getNetService().getPhoneSms((String) params[0]);
                manager.method(phoneSmsObservable,presenterCallBack,whichApi);
                break;
            case ApiConfig.GET_USER_LOGIN_RESULT_TEST:
                Observable<LoginBean> loginObservable = manager.getNetService().getLoginInfo((Map<String, String>) params[0]);
                manager.method(loginObservable,presenterCallBack,whichApi);
                break;
        }
    }
}

package com.cheng.fubaihui.frame;

import com.cheng.fubaihui.bean.LoginBean;
import com.cheng.fubaihui.bean.RegisterBean;
import com.cheng.fubaihui.bean.SendsmsBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//请求网络Observer
public interface INetService {
    //http://newwasj.zhangtongdongli.com/APP/user/register
    //注册
    @POST("APP/user/register")
    @FormUrlEncoded
    Observable<RegisterBean> getPersonRankInfo(@FieldMap Map<String,String> map);

    //http://newwasj.zhangtongdongli.com/APP/Public/sendsms?phone
    //发送短信
    @POST("APP/Public/sendsms")
    @FormUrlEncoded
    Observable<SendsmsBean> getPhoneSms(@Field("phone") String phone);

    //http://newwasj.zhangtongdongli.com/APP/user/login
    @POST("APP/user/login")
    @FormUrlEncoded
    Observable<LoginBean> getLoginInfo(@FieldMap Map<String,String> loginMap);
}


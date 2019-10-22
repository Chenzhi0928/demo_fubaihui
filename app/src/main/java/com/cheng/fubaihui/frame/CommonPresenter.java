package com.cheng.fubaihui.frame;

import android.util.Log;


public class CommonPresenter extends BasePresenter implements ICommonPresenter, ICommonView {


    @Override
    public void getData(int whichApi,Object... params) {
        if (getModel() != null){
            getModel().getData(whichApi, this, params);

        }
        else Log.e("found", " null when getModel in which api:" + whichApi + "-------");
    }

    @Override
    public void onSuccess(int whichApi,Object[] successResult) {
        if (getView() != null){
            getView().onSuccess(whichApi, successResult);

        }

        else Log.e("found", " null when getView in which api:" + whichApi + "-------");
    }

    @Override
    public void onFail(int whichApi,Throwable failResult) {
        if (getView() != null){
            getView().onFail(whichApi, failResult);

        }
        else
            Log.e("found", " null when getView in which api:" + whichApi + "-------" + failResult != null ? failResult.getMessage() : "network error");
    }
}

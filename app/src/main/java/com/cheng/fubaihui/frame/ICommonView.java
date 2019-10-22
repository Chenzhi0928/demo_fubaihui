package com.cheng.fubaihui.frame;

public interface ICommonView<S> {
    void onSuccess(int whichApi, S... successResult);
    void onFail(int whichApi, Throwable failResult);
}

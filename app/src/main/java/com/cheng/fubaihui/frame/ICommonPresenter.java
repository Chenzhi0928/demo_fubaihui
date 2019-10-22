package com.cheng.fubaihui.frame;

public interface ICommonPresenter<P> {
    void getData(int whichApi, P... params);
}

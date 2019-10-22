package com.cheng.fubaihui.frame;

public interface ICommonModel<P> {
    void getData(int whichApi, ICommonView presenterCallback, P... params);
}

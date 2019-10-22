package com.cheng.fubaihui.frame;

import android.widget.Toast;


public abstract class BaseMvpActivity<M extends ICommonModel> extends BaseActivity implements ICommonView{
    public CommonPresenter presenter;

    @Override
    protected void initMvp() {
        super.initMvp();
        presenter=new CommonPresenter();
        presenter.bind(this,initModel());
    }

    protected abstract M initModel();

    @Override
    public void onFail(int whichApi, Throwable failResult) {
        showLog("错误接口是："+whichApi+":"+failResult != null ? failResult.getMessage():"错误原因未知");
        Toast.makeText(BaseApp.getAppContext(),"请求失败，请稍后重试",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }
}

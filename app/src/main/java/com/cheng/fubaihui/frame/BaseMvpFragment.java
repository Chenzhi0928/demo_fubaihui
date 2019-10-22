package com.cheng.fubaihui.frame;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;

public abstract class BaseMvpFragment<M extends ICommonModel> extends BaseFragment implements ICommonView{
    public CommonPresenter presenter;
    private LinearLayoutManager mManager;

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
    public void initRecycleView(RecyclerView recyclerView, RefreshLayout refreshLayout) {
        mManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mManager);
        if (refreshLayout != null) {
            refreshLayout.setHeaderHeight(px2dp(120));
            refreshLayout.setFooterHeight(px2dp(100));
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refresh();
                }
            });
            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    loadMore();
                }
            });
        }
    }
    public void refresh() {
    }

    public void loadMore() {
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }
}

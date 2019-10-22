package com.cheng.fubaihui.frame;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    private Disposable d;
    @Override
    public void onSubscribe(Disposable d) {
        this.d=d;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        dispose();
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
        dispose();
    }

    @Override
    public void onComplete() {

    }
    public abstract void onSuccess(T t);
    public abstract void onFail(Throwable e);
    private void dispose(){
        if(d!=null){
            d.dispose();
        }
    }
}

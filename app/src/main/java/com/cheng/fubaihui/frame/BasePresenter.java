package com.cheng.fubaihui.frame;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends ICommonModel, V extends ICommonView> {
    private WeakReference<V> view;
    private WeakReference<M> model;

    public void bind(V view, M model) {
        this.view = new WeakReference<>(view);
        this.model = new WeakReference<>(model);
    }

    public void unbind() {
        if (view != null) {
            view.clear();
            view = null;
        }
        if (model != null) {
            model.clear();
            model = null;
        }
    }

    public M getModel() {
        return model != null ? model.get() : null;
    }

    public V getView() {
        return view != null ? view.get() : null;
    }
}

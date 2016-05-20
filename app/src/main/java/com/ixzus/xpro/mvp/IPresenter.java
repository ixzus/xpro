package com.ixzus.xpro.mvp;

public interface IPresenter<V> {

    void attachView(V view);

    void detachView();

}
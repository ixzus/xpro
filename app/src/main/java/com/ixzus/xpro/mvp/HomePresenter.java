package com.ixzus.xpro.mvp;

import android.app.Activity;

import com.ixzus.xpro.entity.HomeItem;
import com.ixzus.xpro.http.HttpMethods;
import com.ixzus.xpro.http.subscribers.ProgressSubscriber;
import com.ixzus.xpro.http.subscribers.SubscriberOnNextListener;

import java.util.List;

/**
 * Created by metro on 2016/5/20.
 * 描述:
 */
public class HomePresenter implements IPresenter<IHomeView> {
    private IHomeView homeView;

    @Override
    public void attachView(IHomeView view) {
        this.homeView = view;
    }

    @Override
    public void detachView() {
        this.homeView = null;
    }

    public void loadPageData(int curPage, int pageSize) {
        HttpMethods.getInstance().getHomeItem(new ProgressSubscriber(new SubscriberOnNextListener<List<HomeItem>>() {
            @Override
            public void onNext(List<HomeItem> homeItems) {
//                datas = homeItems;
//                ((HomeItemAdapter)mAdapter).updateItem(homeItems);
                homeView.setData(homeItems);
            }
        }, (Activity) homeView), 1, curPage, pageSize);
    }
}

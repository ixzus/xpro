package com.ixzus.xpro.ui.activity.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ixzus.xpro.R;
import com.ixzus.xpro.entity.HomeItem;
import com.ixzus.xpro.mvp.HomePresenter;
import com.ixzus.xpro.mvp.IHomeView;
import com.ixzus.xpro.ui.adapter.HomeItemAdapter;

import org.byteam.superadapter.SuperAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeToLoadActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener ,IHomeView{

    @Bind(R.id.swipetoload)
    SwipeToLoadLayout swipetoload;
    @Bind(R.id.swipe_target)
    RecyclerView swipeTarget;

    private List<HomeItem> datas = new ArrayList<>();
    private int mType;
    private SuperAdapter mAdapter;

    private HomePresenter homePresenter;
    private int curPage =1;
    private final int pageSize = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_swipe_to_load);
        ButterKnife.bind(this);

        homePresenter = new HomePresenter();
        homePresenter.attachView(this);

        initlisterner();
        initData();
        initRecycler();
    }

    private void initRecycler() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeItemAdapter(this, datas, null);
        swipeTarget.setAdapter(mAdapter);
    }

    private void initData() {
//        HttpMethods.getInstance().getHomeItem(new ProgressSubscriber(new SubscriberOnNextListener<List<HomeItem>>() {
//            @Override
//            public void onNext(List<HomeItem> homeItems) {
//                datas = homeItems;
//                ((HomeItemAdapter)mAdapter).updateItem(homeItems);
//            }
//        }, SwipeToLoadActivity.this), 1, 1,8);

        homePresenter.loadPageData(curPage,pageSize);

    }

    private void autoRefresh() {
        swipetoload.post(new Runnable() {
            @Override
            public void run() {
                swipetoload.setRefreshing(true);
            }
        });
    }

    private void initlisterner() {
        swipetoload.setOnRefreshListener(this);
        swipetoload.setOnLoadMoreListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (swipetoload.isLoadingMore()) {
            swipetoload.setLoadingMore(false);
        }
        if (swipetoload.isRefreshing()) {
            swipetoload.setRefreshing(false);
        }
    }

    @Override
    public void onLoadMore() {
        homePresenter.loadPageData(++curPage,pageSize);
        swipetoload.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipetoload.setLoadingMore(false);
            }
        }, 1800);
    }

    @Override
    public void onRefresh() {
        curPage = 1;
        homePresenter.loadPageData(curPage,pageSize);
        swipetoload.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipetoload.setRefreshing(false);
            }
        }, 1800);
    }

    @Override
    public void setData(List<HomeItem> homeItems) {
        if(1==curPage){
//            datas = homeItems;
            ((HomeItemAdapter)mAdapter).updateItem(homeItems);
        }else{
//            datas.addAll(homeItems);
            ((HomeItemAdapter)mAdapter).addItem(homeItems);
        }
    }
}

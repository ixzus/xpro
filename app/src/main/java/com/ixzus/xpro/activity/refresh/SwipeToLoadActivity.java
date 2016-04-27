package com.ixzus.xpro.activity.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ixzus.xpro.R;
import com.ixzus.xpro.adapter.MultipleAdapter;
import com.ixzus.xpro.bean.XBean;

import org.byteam.superadapter.SuperAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeToLoadActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {

    @Bind(R.id.swipetoload)
    SwipeToLoadLayout swipetoload;
    @Bind(R.id.swipe_target)
    RecyclerView swipeTarget;

    private List<XBean> datas = new ArrayList<>();
    private int mType;
    private SuperAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_to_load);
        ButterKnife.bind(this);
        initlisterner();
//        自动刷新
//        autoRefresh();
        initData();
        initRecycler();
    }

    private void initRecycler() {
        swipeTarget.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MultipleAdapter(this, datas, null);
        swipeTarget.setAdapter(mAdapter);
    }

    private void initData() {
        XBean xbean = new XBean("name1", "pwd1");
        datas.add(xbean);
        xbean = new XBean("name2", "pwd2");
        datas.add(xbean);
        xbean = new XBean("name3", "pwd3");
        datas.add(xbean);
        xbean = new XBean("name4", "pwd4");
        datas.add(xbean);
        xbean = new XBean("name5", "pwd5");
        datas.add(xbean);
        xbean = new XBean("name6", "pwd6");
        datas.add(xbean);
        xbean = new XBean("name7", "pwd7");
        datas.add(xbean);
        xbean = new XBean("name8", "pwd8");
        datas.add(xbean);
        xbean = new XBean("name9", "pwd9");
        datas.add(xbean);
        xbean = new XBean("name10", "pwd10");
        datas.add(xbean);
        xbean = new XBean("name11", "pwd11");
        datas.add(xbean);

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
        swipetoload.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipetoload.setLoadingMore(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        swipetoload.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipetoload.setLoadingMore(false);
            }
        }, 2000);
    }
}

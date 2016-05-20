package com.ixzus.xpro.http;

import com.ixzus.xpro.entity.HomeItem;
import com.ixzus.xpro.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by metro on 2016/5/16.
 * 描述:
 */
public interface ApiService {
    @GET("home.html")
    Observable<HttpResult<List<HomeItem>>> getHomeItem(@Query("isPaging") int isPaging, @Query("curPage") int curPage, @Query("pageSize") int pageSize);
}

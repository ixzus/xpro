package com.ixzus.xpro.entity;

import android.util.Log;

/**
 * Created by liukun on 16/3/5.
 */
public class HttpResult<T> {

    private String code;
    private int costTime;
    private int count;
    private int curPage;
    //用来模仿Data
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCostTime() {
        return costTime;
    }

    public void setCostTime(int costTime) {
        this.costTime = costTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" code=" + code+"curPage=" + curPage + " count=" + count );
        if(null==data){
            Log.e("TAG", "toString:"+"homeitem is null" );
        }
        if (null != data) {
            sb.append(" data:" + data.toString());
        }
        return sb.toString();
    }
}

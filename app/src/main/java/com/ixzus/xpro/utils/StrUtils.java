package com.ixzus.xpro.utils;

/**
 * Created by metro on 2016/5/20.
 * 描述:
 */
public class StrUtils {
    public static String dealImgUrl(String str) {
        if (null == str)
            return null;
        if (-1 == str.indexOf("http:")) {
            return "http://resource.zhubaoshi.cn/" + str;
        }
        return str;
    }
}

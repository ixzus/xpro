*readme测试*
**1.0**

零.
    Application单例,Application中缓存数据很不稳定稍有bug就丢失了

一.xpro公用说明


1.notifyactivity    x1

       targetSdkVersion<21 是不同效果
       用到图片x1开头
       用到layout x1开头
![image](xhttps://github.com/ixzus/xpro/blob/master/xpic/x1notify.gif)

2.dorpdownmenu  x2

![image](xhttps://github.com/ixzus/xpro/blob/master/xpic/x2dropdownmenu.gif)

3.SwipeToLoadLayoutActivity
    支持各种刷新

4.SupterAdater
    支持LinearLayout, GridView, RecyclerView,
    支持多布局

5.BottomNavigation



二.xlib 公用module

1.FormatEditText 格式化电话号码

2.AlignTextView 中英混排,最后一行可以左中右对齐

3.CBAlignTextView 中英混排, 支持复制

4.ACache    缓存

5.topbar
 <com.ixzus.xpro.view.TopBar
        android:id="@+id/topbar"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="@color/colorBlueAccent"

        custom:xleftText="返回"
        custom:xleftTextColor="@color/colorPrimaryText"
        custom:xleftVisiable="false"

        custom:xrightText="更多"
        custom:xrightTextColor="@color/colorPrimaryText"
        custom:xrightVisiable="false"

        custom:xtitle="xpro"
        custom:xtitleTextColor="@color/colorPrimaryText"
         custom:xtitleVisiable="true"
        custom:xtitleTextSize="12sp">
    </com.ixzus.xpro.view.TopBar>
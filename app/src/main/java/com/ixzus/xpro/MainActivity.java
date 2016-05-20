package com.ixzus.xpro;

import android.animation.Animator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ixzus.xpro.base.BaseActivity;
import com.ixzus.xpro.theme.ColorUiUtil;
import com.ixzus.xpro.theme.Theme;
import com.ixzus.xpro.ui.fragment.HomeFragment;
import com.ixzus.xpro.ui.fragment.NetFragment;
import com.ixzus.xpro.ui.fragment.OtherFragment;
import com.ixzus.xpro.ui.fragment.UIFragment;
import com.ixzus.xpro.ui.fragment.WebFragment;
import com.ixzus.xpro.utils.PreUtils;
import com.ixzus.xpro.utils.ThemeUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements ColorChooserDialog.ColorCallback, HomeFragment.OnHomeFragmentInteractionListener, NetFragment.OnNetFragmentInteractionListener, UIFragment.OnUIFragmentInteractionListener, WebFragment.OnWebFragmentInteractionListener, OtherFragment.OnOtherFragmentInteractionListener {


    @Bind(R.id.rl_content)
    RelativeLayout rlContent;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;


    private HomeFragment homeFragment;
    private UIFragment uiFragment;
    private NetFragment netFragment;
    private WebFragment webFragment;
    private OtherFragment otherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        各种通知演示
//        startActivity(new Intent(this, NotifyActivity.class));
//        下拉选择菜单
//        startActivity(new Intent(this, DropDownMenuActivity.class));
//        startActivity(new Intent(this, SwipeToLoadActivity.class));

        initBottomNavigatinoBar();
    }

    private void initBottomNavigatinoBar() {
        initBnBarItem();
        initBnBarListener();
        setDefaultFragment();


    }

    private void initBnBarItem() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_CLASSIC); //MODE_SHIFTING MODE_CLASSIC
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.bnbar_home, "Home").setActiveColor(R.color.bnbar_home).setInActiveColor(R.color.bnbar_m))
                .addItem(new BottomNavigationItem(R.mipmap.bnbar_ui, "UI").setActiveColor(R.color.bnbar_ui).setInActiveColor(R.color.bnbar_m))
                .addItem(new BottomNavigationItem(R.mipmap.bnbar_net, "Net").setActiveColor(R.color.bnbar_net).setInActiveColor(R.color.bnbar_m))
                .addItem(new BottomNavigationItem(R.mipmap.bnbar_web, "Web").setActiveColor(R.color.bnbar_web).setInActiveColor(R.color.bnbar_m))
                .addItem(new BottomNavigationItem(R.mipmap.bnbar_other, "Other").setActiveColor(R.color.bnbar_other).setInActiveColor(R.color.bnbar_m))
                .initialise();

    }

    private void initBnBarListener() {
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switchFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    private void switchFragment(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
//                changeTheme(getResources().getColor(R.color.colorTealPrimary));
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance("", "");
                }
                transaction.replace(R.id.rl_content, homeFragment);
                break;
            case 1:
//                changeTheme(getResources().getColor(R.color.colorBrownPrimary));
                if (uiFragment == null) {
                    uiFragment = UIFragment.newInstance("", "");
                }
                transaction.replace(R.id.rl_content, uiFragment);
                break;
            case 2:
//                changeTheme(getResources().getColor(R.color.colorBluePrimary));
                if (netFragment == null) {
                    netFragment = NetFragment.newInstance("", "");
                }
                transaction.replace(R.id.rl_content, netFragment);
                break;
            case 3:
//                changeTheme(getResources().getColor(R.color.colorBlueGreyPrimary));
                if (webFragment == null) {
                    webFragment = WebFragment.newInstance("", "");
                }
                transaction.replace(R.id.rl_content, webFragment);
                break;
            case 4:
//                changeTheme(getResources().getColor(R.color.colorOrangePrimary));
                if (otherFragment == null) {
                    otherFragment = OtherFragment.newInstance("", "");
                }
                transaction.replace(R.id.rl_content, otherFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance("", "");
        transaction.replace(R.id.rl_content, homeFragment);
        transaction.commit();
    }


    /**
     * fragment 接口
     *
     * @param uri
     */

    @Override
    public void onHomeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onNetFragmentInteraction(Uri uri) {

    }

    @Override
    public void onOtherFragmentInteraction(Uri uri) {
        new ColorChooserDialog.Builder(this, R.string.theme)
                .customColors(R.array.colors, null)
                .doneButton(R.string.done)
                .cancelButton(R.string.cancel)
                .allowUserColorInput(false)
                .allowUserColorInputAlpha(false)
                .show();
    }

    @Override
    public void onUIFragmentInteraction(Uri uri) {

    }

    @Override
    public void onWebFragmentInteraction(Uri uri) {

    }


    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
       changeTheme(selectedColor);
    }

    private void changeTheme(int selectedColor) {
        if (selectedColor == ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
            return;

        if (selectedColor == getResources().getColor(R.color.colorBluePrimary)) {
            setTheme(R.style.BlueTheme);
            PreUtils.setCurrentTheme(this, Theme.Blue);

        } else if (selectedColor == getResources().getColor(R.color.colorRedPrimary)) {
            setTheme(R.style.RedTheme);
            PreUtils.setCurrentTheme(this, Theme.Red);

        } else if (selectedColor == getResources().getColor(R.color.colorBrownPrimary)) {
            setTheme(R.style.BrownTheme);
            PreUtils.setCurrentTheme(this, Theme.Brown);

        } else if (selectedColor == getResources().getColor(R.color.colorGreenPrimary)) {
            setTheme(R.style.GreenTheme);
            PreUtils.setCurrentTheme(this, Theme.Green);

        } else if (selectedColor == getResources().getColor(R.color.colorPurplePrimary)) {
            setTheme(R.style.PurpleTheme);
            PreUtils.setCurrentTheme(this, Theme.Purple);

        } else if (selectedColor == getResources().getColor(R.color.colorTealPrimary)) {
            setTheme(R.style.TealTheme);
            PreUtils.setCurrentTheme(this, Theme.Teal);

        } else if (selectedColor == getResources().getColor(R.color.colorPinkPrimary)) {
            setTheme(R.style.PinkTheme);
            PreUtils.setCurrentTheme(this, Theme.Pink);

        } else if (selectedColor == getResources().getColor(R.color.colorDeepPurplePrimary)) {
            setTheme(R.style.DeepPurpleTheme);
            PreUtils.setCurrentTheme(this, Theme.DeepPurple);

        } else if (selectedColor == getResources().getColor(R.color.colorOrangePrimary)) {
            setTheme(R.style.OrangeTheme);
            PreUtils.setCurrentTheme(this, Theme.Orange);

        } else if (selectedColor == getResources().getColor(R.color.colorIndigoPrimary)) {
            setTheme(R.style.IndigoTheme);
            PreUtils.setCurrentTheme(this, Theme.Indigo);

        } else if (selectedColor == getResources().getColor(R.color.colorLightGreenPrimary)) {
            setTheme(R.style.LightGreenTheme);
            PreUtils.setCurrentTheme(this, Theme.LightGreen);

        } else if (selectedColor == getResources().getColor(R.color.colorDeepOrangePrimary)) {
            setTheme(R.style.DeepOrangeTheme);
            PreUtils.setCurrentTheme(this, Theme.DeepOrange);

        } else if (selectedColor == getResources().getColor(R.color.colorLimePrimary)) {
            setTheme(R.style.LimeTheme);
            PreUtils.setCurrentTheme(this, Theme.Lime);

        } else if (selectedColor == getResources().getColor(R.color.colorBlueGreyPrimary)) {
            setTheme(R.style.BlueGreyTheme);
            PreUtils.setCurrentTheme(this, Theme.BlueGrey);

        } else if (selectedColor == getResources().getColor(R.color.colorCyanPrimary)) {
            setTheme(R.style.CyanTheme);
            PreUtils.setCurrentTheme(this, Theme.Cyan);

        }
        final View rootView = getWindow().getDecorView();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);

        final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        if (null != localBitmap && rootView instanceof ViewGroup) {
            final View tmpView = new View(getApplicationContext());
            tmpView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) rootView).addView(tmpView, params);
            tmpView.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    ColorUiUtil.changeTheme(rootView, getTheme());
                    System.gc();
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((ViewGroup) rootView).removeView(tmpView);
                    localBitmap.recycle();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).start();
        }
    }


}

package com.ixzus.xpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ixzus.xpro.R;

/**
 * Created by metro on 2016/4/26.
 */
public class TopBar extends RelativeLayout {

    private Button leftButton, rightButton;
    private TextView tvTitle;

    //left
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;
    //right
    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;
    //title
    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams, rightParams, titleParams;
    private boolean isVisiableTitle, isVisiableLeft,isVisiableRight;

    private topbarClickListener xlistener;

    public interface topbarClickListener {
        void leftClick();

        void rightClick();
    }

    public void setOnTopbarClickListener(topbarClickListener listener) {
        this.xlistener = listener;
    }


    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        initListener();


    }


    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
        //left
        leftTextColor = ta.getColor(R.styleable.Topbar_xleftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.Topbar_xleftBackground);
        leftText = ta.getString(R.styleable.Topbar_xleftText);
        //right
        rightTextColor = ta.getColor(R.styleable.Topbar_xrightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.Topbar_xrightBackground);
        rightText = ta.getString(R.styleable.Topbar_xrightText);
        //title
        titleTextSize = ta.getDimension(R.styleable.Topbar_xtitleTextSize, 0);
        titleTextColor = ta.getColor(R.styleable.Topbar_xtitleTextColor, 0);
        title = ta.getString(R.styleable.Topbar_xtitle);
        //visiable
        isVisiableTitle = ta.getBoolean(R.styleable.Topbar_xtitleVisiable,true);
        isVisiableLeft = ta.getBoolean(R.styleable.Topbar_xleftVisiable,true);
        isVisiableRight = ta.getBoolean(R.styleable.Topbar_xrightVisiable,true);
        //回收
        ta.recycle();
        //控件
        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitle = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(title);
        tvTitle.setGravity(Gravity.CENTER);


        //left
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton, leftParams);
        //right
        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightParams);
        //title
        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(tvTitle, titleParams);

        if(!isVisiableLeft){
            leftButton.setVisibility(View.GONE);
        }

        if(!isVisiableRight){
            rightButton.setVisibility(View.GONE);
        }

        if(!isVisiableTitle){
            tvTitle.setVisibility(View.GONE);
        }

    }

    private void initListener() {
        //click
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"left",Toast.LENGTH_LONG).show();
                showTitle();
                xlistener.leftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"left",Toast.LENGTH_LONG).show();
                xlistener.rightClick();
            }
        });
    }

    public void setLeftButtonVisable(boolean flag) {
        if (flag) {
            leftButton.setVisibility(View.VISIBLE);
        } else {
            leftButton.setVisibility(View.GONE);
        }
    }

    public void setRightButtonVisable(boolean flag) {
        if (flag) {
            rightButton.setVisibility(View.VISIBLE);
        } else {
            rightButton.setVisibility(View.GONE);
        }
    }

    public void showTitle(){
        Log.e("tvTitle:",""+tvTitle.getText().toString());
    }
}

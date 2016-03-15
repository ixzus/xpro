package com.ixzus.xpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ixzus.xpro.activity.dropdownmenu.DropDownMenuActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        各种通知演示
//        startActivity(new Intent(this, NotifyActivity.class));
//        下拉选择菜单
        startActivity(new Intent(this, DropDownMenuActivity.class));
    }


}

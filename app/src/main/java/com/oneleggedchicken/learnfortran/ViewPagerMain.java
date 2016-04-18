package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by a on 4/17/2016.
 */
public class ViewPagerMain extends Activity {

    public static ViewPager viewPager;
    ViewPagerAdapter adapter;
    String[] headarray,questionarray;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
        viewPager = (ViewPager) findViewById(R.id.pager);

        headarray = getIntent().getStringArrayExtra("headarray");
        questionarray = getIntent().getStringArrayExtra("questionarray");
        adapter = new ViewPagerAdapter(ViewPagerMain.this, headarray,questionarray);
        viewPager.setAdapter(adapter);



    }
}
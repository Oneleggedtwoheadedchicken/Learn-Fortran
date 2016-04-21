package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by a on 4/17/2016.
 */

public class ViewPagerMain extends Activity {


    public static ViewPager viewPager;
    ViewPagerAdapter adapter;
    String[] headarray,questionarray;
    public static int currentPage=0;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
        headarray = getIntent().getStringArrayExtra("headarray");
        questionarray = getIntent().getStringArrayExtra("questionarray");
       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle();*/
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(ViewPagerMain.this, headarray,questionarray);
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override

            public void onPageSelected(int position) {
                adapter.notifyDataSetChanged();

            }


        });

    }


}
package com.oneleggedchicken.learnfortran;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Chronometer;

public class TestPagerMain extends AppCompatActivity {


    public static ViewPager viewPager;
    TestPagerAdapter adapter;
    public static Chronometer time;
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Test");
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new TestPagerAdapter(TestPagerMain.this);
        viewPager.setAdapter(adapter);
        time = (Chronometer) findViewById(R.id.time);
        time.start();

    }


}
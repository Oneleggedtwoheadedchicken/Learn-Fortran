package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

/**
 * Created by a on 4/17/2016.
 */
public class ViewPagerMain extends Activity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    String[] headarray,questionarray;
    Button check;
    Data d;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);
        viewPager = (ViewPager) findViewById(R.id.pager);

        d= (Data) getIntent().getSerializableExtra("data");
        headarray = d.getquestionhead();
        questionarray = d.getquestiontext();
        adapter = new ViewPagerAdapter(ViewPagerMain.this, headarray,questionarray);
        viewPager.setAdapter(adapter);

        check = (Button) findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);

                if(viewPager.getCurrentItem()+1>headarray.length){

                    ViewPagerMain.this.finish();

                }

            }
        });

    }
}
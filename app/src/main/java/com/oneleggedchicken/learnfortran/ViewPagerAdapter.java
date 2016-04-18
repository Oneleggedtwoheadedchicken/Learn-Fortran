package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class ViewPagerAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;
    String[] questionarray = null;
    String[] headarray = null;
    TextView questionhead,question,attemps;
    Chronometer time;
    int attempsnum;
    Button check;

    Calendar calendar;
    public ViewPagerAdapter(Context context, String[] headarray, String[] questionarray) {
        this.context = context;
        this.questionarray = questionarray;
        this.headarray = headarray;


    }

    @Override
    public int getCount() {

        return questionarray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        if (position%2==0){

            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.viewpager_item, container,
                    false);

            questionhead = (TextView) itemView.findViewById(R.id.questionhead);
            questionhead.setText(headarray[position]);

            question = (TextView) itemView.findViewById(R.id.question);
            question.setText(questionarray[position]);

            check = (Button) itemView.findViewById(R.id.check);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ViewPagerMain.viewPager.getCurrentItem() + 2 > headarray.length) {

                        ((Activity)context).finish();

                    } else {

                        ViewPagerMain.viewPager.setCurrentItem(ViewPagerMain.viewPager.getCurrentItem() + 1, true);
                    }

                }
            });


            ((ViewPager)container).addView(itemView);


            return itemView;
        }

        else {
            attempsnum = 0;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.viewpager_test, container,
                    false);

            questionhead = (TextView) itemView.findViewById(R.id.questionhead);
            questionhead.setText(headarray[position]);
            attemps = (TextView )itemView.findViewById(R.id.attemps);
            time = (Chronometer)itemView.findViewById(R.id.time);
            time.start();
            attemps.setText("Attemps:" + attempsnum);

                ((ViewPager) container).addView(itemView);


            return itemView;

        }


    }




    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}


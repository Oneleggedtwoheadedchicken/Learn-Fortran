package com.oneleggedchicken.learnfortran;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;
    String[] questionarray = null;
    String[] headarray = null;

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
        TextView questionhead,question;


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        questionhead = (TextView) itemView.findViewById(R.id.questionhead);
        questionhead.setText(headarray[position]);

        question = (TextView) itemView.findViewById(R.id.question);
        question.setText(questionarray[position]);


        ((ViewPager)container).addView(itemView);


        return itemView;
    }




    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}


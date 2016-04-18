package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.InputFilter;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class ViewPagerAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;
    String[] questionarray = null;
    String[] headarray = null;
    TextView questionhead,question,attemps,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    EditText et1,et2,et3,et4;
    Chronometer time;
    TableLayout table;
    TableRow row,row1,row2,row3 ;
    String s ="",answer1,answer2,answer3,answer4;
    int attempsnum;
    Button check;
    String[] questionss;
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

        ((Activity) context).getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

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
            tv1 = new TextView(context);
            tv2 = new TextView(context);
            tv3 = new TextView(context);
            tv4 = new TextView(context);
            tv5 = new TextView(context);
            tv6 = new TextView(context);
            tv7 = new TextView(context);
            tv8 = new TextView(context);
            et1 = new EditText(context);
            et2 = new EditText(context);
            et3 = new EditText(context);
            et4 = new EditText(context);
            s = Arrays.asList(questionarray).get(position);
           // s = Arrays.toString(());
           // s = s.replaceAll(",", "").replaceAll("\\[|\\]","");
            questionss = s.split("---");
         //   number1 = Arrays.asList(questionarray).get(3).length();
           // number2 = Arrays.asList(questionarray).get(5).length();
            if(Arrays.asList(questionss).size()>0) {
                tv1.setText(Arrays.asList(questionss).get(0));
            }
            if(Arrays.asList(questionss).size()>2) {
                tv2.setText(Arrays.asList(questionss).get(2));
            }
            if(Arrays.asList(questionss).size()>3) {
                tv3.setText(Arrays.asList(questionss).get(3));

            }
            if(Arrays.asList(questionss).size()>5) {
                tv4.setText(Arrays.asList(questionss).get(5));
            }

            if(Arrays.asList(questionss).size()>6) {
                tv5.setText(Arrays.asList(questionss).get(6));
            }

            if(Arrays.asList(questionss).size()>8) {
                tv6.setText(Arrays.asList(questionss).get(8));
            }
            if(Arrays.asList(questionss).size()>9) {
                tv7.setText(Arrays.asList(questionss).get(9));
            }

            if(Arrays.asList(questionss).size()>11) {
                tv8.setText(Arrays.asList(questionss).get(11));
            }

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
            table = (TableLayout) itemView.findViewById(R.id.layout);
            row = new TableRow(context);
            row.addView(tv1);
            if(Arrays.asList(questionss).size()>1) {
                row.addView(et1);
            }
            row.addView(tv2);
            table.addView(row);
            row1 = new TableRow(context);
            row1.addView(tv3);
            if(Arrays.asList(questionss).size()>4) {
                row1.addView(et2);
            }
            row1.addView(tv4);

            table.addView(row1);
            row2 = new TableRow(context);
            row2.addView(tv5);
            if(Arrays.asList(questionss).size()>7){
                row2.addView(et3);
            }
            row2.addView(tv6);
            table.addView(row2);

            row3 = new TableRow(context);
            row3.addView(tv7);
            if(Arrays.asList(questionss).size()>10) {
                row3.addView(et4);
            }
            row3.addView(tv8);
            table.addView(row3);

            check = (Button) itemView.findViewById(R.id.check);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answer1 = et1.getText().toString().replaceAll(" ", "").toLowerCase();
                    answer2 = et2.getText().toString().replaceAll(" ", "").toLowerCase();
                    answer3 = et3.getText().toString().replaceAll(" ", "").toLowerCase();
                    answer4 = et4.getText().toString().replaceAll(" ", "").toLowerCase();
                    System.out.println(s);
                    System.out.println(questionss);
                    System.out.println(Arrays.asList(questionss).get(1));
                    System.out.println(Arrays.asList(questionss).get(4));
                    System.out.println(Arrays.toString(questionss));

                    if (Arrays.asList(questionss).size() > 10) {
                        if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase()) && answer2.equals(Arrays.asList(questionss).get(4).replaceAll(" ", "").toLowerCase()) && answer3.equals(Arrays.asList(questionss).get(7).replaceAll(" ", "").toLowerCase())
                                && answer4.equals(Arrays.asList(questionss).get(10).replaceAll(" ", "").toLowerCase())) {

                            Toast.makeText(context, "RIGHT!", Toast.LENGTH_LONG).show();

                        } else {
                            attempsnum += 1;
                            attemps.setText("Attemps:" + attempsnum);
                            Toast.makeText(context, "WRONG!", Toast.LENGTH_LONG).show();
                        }

                    } else if (Arrays.asList(questionss).size() > 6) {

                        if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase()) && answer2.equals(Arrays.asList(questionss).get(4).replaceAll(" ", "").toLowerCase())&& answer3.equals(Arrays.asList(questionss).get(7).replaceAll(" ", "").toLowerCase())) {

                            Toast.makeText(context, "RIGHT!", Toast.LENGTH_LONG).show();

                        } else {
                            attempsnum += 1;
                            attemps.setText("Attemps:" + attempsnum);
                            Toast.makeText(context, "WRONG!", Toast.LENGTH_LONG).show();
                        }
                    } else if (Arrays.asList(questionss).size() > 4) {

                        if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase()) && answer2.equals(Arrays.asList(questionss).get(4).replaceAll(" ", "").toLowerCase())) {

                            Toast.makeText(context, "RIGHT!", Toast.LENGTH_LONG).show();

                        } else {
                            attempsnum += 1;
                            attemps.setText("Attemps:" + attempsnum);
                            Toast.makeText(context, "WRONG!", Toast.LENGTH_LONG).show();
                        }


                    } else if (Arrays.asList(questionss).size() > 1) {

                        if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase())) {

                            Toast.makeText(context, "RIGHT!", Toast.LENGTH_LONG).show();

                        } else {
                            attempsnum += 1;
                            attemps.setText("Attemps:" + attempsnum);
                            Toast.makeText(context, "WRONG!", Toast.LENGTH_LONG).show();
                        }

                    }


                }
            });


            ((ViewPager) container).addView(itemView);


            return itemView;

        }


    }




    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}


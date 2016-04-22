package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;
    String[] questionarray = null;
    String[] headarray = null;
    TextView questionhead, question, attemps, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    EditText et1, et2, et3, et4;
    Chronometer time;
    String s = "", answer1, answer2, answer3, answer4;
    int attempsnum;
    Button check, answer;
    String[] questionss;
    AlertDialog.Builder al;
    int btnclick = 0;
    public ViewPagerAdapter(Context context, String[] headarray, String[] questionarray) {
        this.context = context;
        this.questionarray = questionarray;
        this.headarray = headarray;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



    public int getItemPosition(Object object){
        return POSITION_NONE;
    }

    @Override
    public int getCount() {

        return headarray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ((Activity) context).getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        if (position % 2 == 0) {
            

            View itemView1 = inflater.inflate(R.layout.viewpager_item, container,
                    false);

            questionhead = (TextView) itemView1.findViewById(R.id.questionhead);
            questionhead.setText(headarray[position]);
            question = (TextView) itemView1.findViewById(R.id.question);
            question.setText(questionarray[position]);

            check = (Button) itemView1.findViewById(R.id.check);
            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pager();
                }
            });


            ((ViewPager) container).addView(itemView1);


            return itemView1;
        } else {


            View itemView = inflater.inflate(R.layout.viewpager_test, container,
                    false);


            attempsnum = 0;


            tv1 = (TextView) itemView.findViewById(R.id.ftext);
            tv2 = (TextView) itemView.findViewById(R.id.stext);
            tv3 = (TextView) itemView.findViewById(R.id.f1text);
            tv4 = (TextView) itemView.findViewById(R.id.s1text);
            tv5 = (TextView) itemView.findViewById(R.id.f2text);
            tv6 = (TextView) itemView.findViewById(R.id.s2text);
            tv7 = (TextView) itemView.findViewById(R.id.f3text);
            tv8 = (TextView) itemView.findViewById(R.id.s3text);
            et1 = (EditText) itemView.findViewById(R.id.edittext);
            et2 = (EditText) itemView.findViewById(R.id.edit1text);
            et3 = (EditText) itemView.findViewById(R.id.edit2text);
            et4 = (EditText) itemView.findViewById(R.id.edit3text);

            s = questionarray[position];
            System.out.println(""+s);

            questionss = s.split("---");


            if (Arrays.asList(questionss).size() > 0) {
                tv1.setText(Arrays.asList(questionss).get(0));
            }
            if (Arrays.asList(questionss).size() > 2) {
                tv2.setText(Arrays.asList(questionss).get(2));

            } else {
                et1.setVisibility(View.GONE);
            }
            if (Arrays.asList(questionss).size() > 3) {
                tv3.setText(Arrays.asList(questionss).get(3));

            }
            if (Arrays.asList(questionss).size() > 5) {
                tv4.setText(Arrays.asList(questionss).get(5));
            } else {
                et2.setVisibility(View.GONE);
            }

            if (Arrays.asList(questionss).size() > 6) {
                tv5.setText(Arrays.asList(questionss).get(6));
            }

            if (Arrays.asList(questionss).size() > 8) {
                tv6.setText(Arrays.asList(questionss).get(8));
            } else {
                et3.setVisibility(View.GONE);
            }
            if (Arrays.asList(questionss).size() > 9) {
                tv7.setText(Arrays.asList(questionss).get(9));
            }

            if (Arrays.asList(questionss).size() > 11) {
                tv8.setText(Arrays.asList(questionss).get(11));
            } else {
                et4.setVisibility(View.GONE);
            }

            questionhead = (TextView) itemView.findViewById(R.id.questionhead);
            questionhead.setText(headarray[position]);
            attemps = (TextView) itemView.findViewById(R.id.attemps);
            time = (Chronometer) itemView.findViewById(R.id.time);
            time.start();
            attemps.setText("Attemps:" + attempsnum);

            check = (Button) itemView.findViewById(R.id.check);
            answer = (Button) itemView.findViewById(R.id.answer);

            answer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnclick =1;
                    check.setText("Continue");
                    al = new AlertDialog.Builder(context);

                    if (Arrays.asList(questionss).size() > 11) {
                        al.setMessage("" + Arrays.asList(questionss).get(1) + System.lineSeparator() + Arrays.asList(questionss).get(4) + System.lineSeparator() + Arrays.asList(questionss).get(7) + System.lineSeparator() + Arrays.asList(questionss).get(10));
                    } else if (Arrays.asList(questionss).size() > 7) {
                        al.setMessage("" + Arrays.asList(questionss).get(1) + System.lineSeparator() + Arrays.asList(questionss).get(4) + System.lineSeparator() + Arrays.asList(questionss).get(7));
                    } else if (Arrays.asList(questionss).size() > 5) {
                        al.setMessage("" + Arrays.asList(questionss).get(1) + System.lineSeparator() + Arrays.asList(questionss).get(4));
                    } else if (Arrays.asList(questionss).size() > 2) {
                        if (Arrays.asList(questionss).get(1).equals("ERROR")) {
                            al.setMessage("" + Arrays.asList(questionss).get(1) + " (x must be REAL)");

                        } else if (Arrays.asList(questionss).get(1).equals("S")) {
                            al.setMessage("" + Arrays.asList(questionss).get(1) + " (Character length is not specified so character length here = 1 ");


                        } else if (Arrays.asList(questionss).get(1).equals(" ERROR ")) {
                            al.setMessage("" + Arrays.asList(questionss).get(1) + " (because 'END if' is missing)");


                        } else if (Arrays.asList(questionss).get(1).equals(" 50 ")) {
                            al.setMessage("" + Arrays.asList(questionss).get(1) + " (11+12+13+14)");


                        } else if (Arrays.asList(questionss).get(1).equals("  ERROR  ")) {
                            al.setMessage("" + Arrays.asList(questionss).get(1) + " (because 'while' is missing)");

                        } else {
                            al.setMessage("" + Arrays.asList(questionss).get(1));
                        }
                    }

                    al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }

                    });

                    AlertDialog dialog = al.show();
                    TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
                    messageView.setGravity(Gravity.CENTER);

                }

            });


            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        if(btnclick==0) {
                            answer1 = et1.getText().toString().replaceAll(" ", "").toLowerCase();
                            answer2 = et2.getText().toString().replaceAll(" ", "").toLowerCase();
                            answer3 = et3.getText().toString().replaceAll(" ", "").toLowerCase();
                            answer4 = et4.getText().toString().replaceAll(" ", "").toLowerCase();

                            if (Arrays.asList(questionss).size() > 11) {
                                if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase()) && answer2.equals(Arrays.asList(questionss).get(4).replaceAll(" ", "").toLowerCase()) && answer3.equals(Arrays.asList(questionss).get(7).replaceAll(" ", "").toLowerCase())
                                        && answer4.equals(Arrays.asList(questionss).get(10).replaceAll(" ", "").toLowerCase())) {
                                    Right();
                                    check.setText("Countine");
                                } else {
                                    Wrong();
                                }

                            } else if (Arrays.asList(questionss).size() > 7) {

                                if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase()) && answer2.equals(Arrays.asList(questionss).get(4).replaceAll(" ", "").toLowerCase()) && answer3.equals(Arrays.asList(questionss).get(7).replaceAll(" ", "").toLowerCase())) {
                                    Right();
                                    check.setText("Countine");
                                } else {
                                    Wrong();
                                }
                            } else if (Arrays.asList(questionss).size() > 5) {

                                if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase()) && answer2.equals(Arrays.asList(questionss).get(4).replaceAll(" ", "").toLowerCase())) {
                                    Right();
                                    check.setText("Countine");
                                } else {
                                    Wrong();
                                }
                            } else if (Arrays.asList(questionss).size() > 2) {

                                if (answer1.equals(Arrays.asList(questionss).get(1).replaceAll(" ", "").toLowerCase())) {
                                    Right();
                                    check.setText("Countine");
                                } else {
                                    Wrong();
                                }
                            }

                        }else {
                            btnclick=0;
                            Pager();
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

    public static int setCount() {
        ViewPagerMain.currentPage= ViewPagerMain.currentPage+1;
        return ViewPagerMain.currentPage;
    }



    public void Right() {
        Toast.makeText(context, "RIGHT!", Toast.LENGTH_LONG).show();
        btnclick = 1;
    }

    public void Wrong() {

        attempsnum += 1;
        attemps.setText("Attemps:" + attempsnum);
        Toast.makeText(context, "WRONG!", Toast.LENGTH_LONG).show();

    }

    public void Pager(){

        if (ViewPagerMain.viewPager.getCurrentItem() + 2 >getCount()) {

            ((Activity) context).finish();

        } else {

            ViewPagerMain.viewPager.setCurrentItem(ViewPagerMain.viewPager.getCurrentItem() + 1, true);
        }

    }
}



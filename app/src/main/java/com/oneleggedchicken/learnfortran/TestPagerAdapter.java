package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class TestPagerAdapter extends PagerAdapter {

    int percentage=0;
    ArrayList<String> answer = new ArrayList<String>();

    Context context;
    LayoutInflater inflater;
    Button check;
    RadioButton R1,R2,R3,R4,R5,R6;
    EditText E1,E2,E3,E4,E5;
    String A1,A2,A3,A4,A5;

    public TestPagerAdapter(Context context) {
        this.context = context;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getItemPosition(Object object){
        return POSITION_NONE;
    }

    @Override
    public int getCount() {

        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

     if(position==0) {
         View itemView = inflater.inflate(R.layout.mcq_test, container,
                 false);

         R1 = (RadioButton) itemView.findViewById(R.id.SRB1);
         R2 = (RadioButton) itemView.findViewById(R.id.SR2);
         R3 = (RadioButton) itemView.findViewById(R.id.FORB3);
         R4 = (RadioButton) itemView.findViewById(R.id.FORB4);
         R5 = (RadioButton) itemView.findViewById(R.id.FRB5);
         R6 = (RadioButton) itemView.findViewById(R.id.FORB6);


         check = (Button) itemView.findViewById(R.id.check);
         check.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (R1.isChecked()) {
                     percentage += 10;
                 } else {
                     answer.add("1)" + R1.getText().toString());
                 }
                 if (R2.isChecked()) {
                     percentage += 10;
                 } else {
                     answer.add("2)"+ R2.getText().toString());
                 }
                 if (R3.isChecked()) {
                     percentage += 10;
                 } else {
                     answer.add("3)"+ R3.getText().toString());
                 }
                 if (R4.isChecked()) {
                     percentage += 10;
                 } else {
                     answer.add("4)"+ R4.getText().toString());
                 }
                 if (R5.isChecked()) {
                     percentage += 10;
                 } else {

                     answer.add("5)"+ R5.getText().toString());

                 }
                 if (R6.isChecked()) {
                     percentage += 10;
                 } else {
                     answer.add(R6.getText().toString());
                 }

                 Toast.makeText(context, "" + percentage, Toast.LENGTH_LONG).show();

                 Pager();

             }
         });


         ((ViewPager) container).addView(itemView);


         return itemView;
     }
     else {

        View itemView = inflater.inflate(R.layout.complete_test, container,
                false);

         E1 = (EditText) itemView.findViewById(R.id.E1);
         E2 = (EditText) itemView.findViewById(R.id.E2);
         E3 = (EditText) itemView.findViewById(R.id.E3);
         E4 = (EditText) itemView.findViewById(R.id.E4);
         E5 = (EditText) itemView.findViewById(R.id.E5);

         check = (Button) itemView.findViewById(R.id.check);
         check.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 A1 = E1.getText().toString().replace(" ","").toLowerCase();
                 A2 = E2.getText().toString().replace(" ","").toLowerCase();
                 A3 = E3.getText().toString().replace(" ","").toLowerCase();
                 A4 = E4.getText().toString().replace(" ","").toLowerCase();
                 A5 = E5.getText().toString().replace(" ","").toLowerCase();

                 if(A1.equals("54.0") || A1.equals("54.0")){
                     percentage += 10;
                 }else{
                     answer.add("6)"+" 54.0");
                 }

                 if(A2.equals("12.5")){
                     percentage += 10;
                 }else{
                     answer.add("7)"+"12.5");

                 }

                 if(A3.equals("78.0") || A1.equals("78.")){
                     percentage += 10;
                 }else{
                     answer.add("8)"+" 78.0");
                 }

                 if(A4.equals("9)"+" 3.5")){
                     percentage += 10;
                 }else{
                     answer.add("3.5");
                 }

                 if(A5.equals("error")){
                     percentage += 10;
                 }else{
                     answer.add("10)"+" Error because 144 should be REAL");
                 }

                 Toast.makeText(context, "" + percentage, Toast.LENGTH_LONG).show();

                 Pager();

             }
         });





         ((ViewPager) container).addView(itemView);


         return itemView;

     }

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);

    }

    public void Pager(){

        if (TestPagerMain.viewPager.getCurrentItem() + 2 >getCount()) {
            Intent intent = new Intent(context,Dialog.class);
            intent.putExtra("time",TestPagerMain.time.getText().toString());
            intent.putExtra("percentage", String.valueOf(percentage));
            intent.putExtra("answer",(answer).toString().replaceAll("\\[|\\]", "").replaceAll(",", System.lineSeparator()));
            context.startActivity(intent);


        } else {

            TestPagerMain.viewPager.setCurrentItem(TestPagerMain.viewPager.getCurrentItem() + 1, true);
        }

    }
}



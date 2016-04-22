package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Dialog extends Activity {

    TextView tv1,tv2,tv3;

    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        tv1 = (TextView) findViewById(R.id.textView8);
        tv2 = (TextView) findViewById(R.id.textView9);
        tv3 = (TextView) findViewById(R.id.textView);
        tv1.setText("Time:" + getIntent().getStringExtra("time"));
        tv2.setText("" + getIntent().getStringExtra("answer"));
        tv3.setText("Your percentage:" + getIntent().getStringExtra("percentage") +"%");


    }
}

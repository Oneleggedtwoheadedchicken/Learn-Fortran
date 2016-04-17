package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;


public class TableGrid  extends Activity {

    GridView gv;
    ArrayList Button;
    String[] firstText,secText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        firstText = getIntent().getStringArrayExtra("array");
        secText = getIntent().getStringArrayExtra("secarray");

        gv=(GridView) findViewById(R.id.gridView);
        gv.setAdapter(new CustomGrid(this,firstText , secText));

    }
}

package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;


public class TableGrid  extends Activity {

    GridView gv;
    ArrayList Button;
    String[] firstText,secText,question,questionhead;
    Data d;
    ArrayList<Data> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);

        d= (Data) getIntent().getSerializableExtra("data");
        firstText=d.getgridtext();
        secText = d.getgridsectext();
        gv=(GridView) findViewById(R.id.gridView);
        gv.setAdapter(new CustomGrid(this,firstText, secText,d));

    }
}

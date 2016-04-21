package com.oneleggedchicken.learnfortran;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import java.util.ArrayList;


public class TableGrid  extends AppCompatActivity {

    GridView gv;
    ArrayList Button;
    String[] firstText,secText;
    String title;
    Data d;
    ArrayList<Data> al;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        title = getIntent().getStringExtra("name");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        d= (Data) getIntent().getSerializableExtra("data");
        firstText=d.getgridtext();
        secText = d.getgridsectext();
        gv=(GridView) findViewById(R.id.gridView);
        gv.setAdapter(new CustomGrid(this,firstText, secText,d));

    }
}

package com.oneleggedchicken.learnfortran;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Glossary extends AppCompatActivity {

    ListView listView;
    String[] values;
    ArrayAdapter<String> adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Glossary");

        listView = (ListView) findViewById(R.id.list);

         values = getResources().getStringArray(R.array.glossary);


        adapter = new ArrayAdapter<String>(this,
                R.layout.list_text,
                values);


        listView.setAdapter(adapter);

    }
}

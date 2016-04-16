package com.oneleggedchicken.learnfortran;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Glossary extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ListView listView = (ListView) findViewById(R.id.list);

        String[] values = getResources().getStringArray(R.array.glossary);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2, android.R.id.text2,
                values);


        listView.setAdapter(adapter);

    }
}

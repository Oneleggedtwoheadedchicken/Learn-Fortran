package com.oneleggedchicken.learnfortran;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class CustomGrid extends BaseAdapter{

    String [] text;
    String [] sctext;
    Context context;
    Data d;
    int [] btn;
    private static LayoutInflater inflater=null;
    public CustomGrid(TableGrid tableGrid, String[] firstText,String[] seconText ) {


        sctext=seconText;
        text=firstText;
        context=tableGrid;
       // btn=Button;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView tv1;
      //  Button btnn;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.table_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.firstText);
        holder.tv1=(TextView) rowView.findViewById(R.id.bottomText);
      //  holder.btnn=(Button) rowView.findViewById(R.id.table_btn);

        holder.tv.setText(text[position]);
        holder.tv1.setText(sctext[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            Intent intent = new Intent(context,ViewPagerMain.class);
             context.startActivity(intent);

            }
        });

        return rowView;
    }

}
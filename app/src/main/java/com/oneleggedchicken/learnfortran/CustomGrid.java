package com.oneleggedchicken.learnfortran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomGrid extends BaseAdapter{

    String [] text;
    String [] sctext;

    Context context;
    int [] btn;
    private static LayoutInflater inflater=null;
    public CustomGrid(MainActivity mainActivity, String[] firstText,String[] seconText, int[] Button) {

        sctext=seconText;
        text=firstText;
        context=mainActivity;
        btn=Button;
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
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.table_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.);
        holder.img=(ImageView) rowView.findViewById(R.id.);

        holder.tv.setText(text[position]);
        holder.tv1.setText(sctext[position]);

        holder.img.setImageResource(btn[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        return rowView;
    }

}
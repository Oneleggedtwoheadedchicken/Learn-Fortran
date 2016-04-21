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

import java.util.ArrayList;

public class CustomGrid extends BaseAdapter{

    String [] text;
    String [] sctext;
    ArrayList<Data> al1;
    Context context;
    Data d;
    int [] btn;
    ArrayList<Data> al;

    private static LayoutInflater inflater=null;
    public CustomGrid(TableGrid tableGrid, String[] firstText, String[] seconText, Data d1) {

        d = d1;

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
        Button btnn;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.table_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.firstText);
        holder.tv1=(TextView) rowView.findViewById(R.id.bottomText);
        holder.btnn=(Button) rowView.findViewById(R.id.table_btn);
        holder.tv.setText(text[position]);
        holder.tv1.setText(sctext[position]);

        holder.btnn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (position == 0) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getfirstquestionhead());
                    intent.putExtra("questionarray", d.getfirstquestiontext());

                    context.startActivity(intent);

                } else if (position == 1) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getsecondquestionhead());
                    intent.putExtra("questionarray", d.getsecondquestiontext());
                    context.startActivity(intent);
                } else if (position == 2) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getthirdquestionhead());
                    intent.putExtra("questionarray", d.getthirdquestiontext());
                    context.startActivity(intent);
                }else if (position == 3) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getfourthquestionhead());
                    intent.putExtra("questionarray", d.getfourthquestiontext());
                    context.startActivity(intent);
                }else if (position == 4) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getfifthquestionhead());
                    intent.putExtra("questionarray", d.getfifthquestiontext());
                    context.startActivity(intent);
                }else if (position == 5) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getsixthquestionhead());
                    intent.putExtra("questionarray", d.getsixthquestiontext());
                    context.startActivity(intent);
                }else if (position == 6) {

                    Intent intent = new Intent(context, ViewPagerMain.class);
                    intent.putExtra("headarray", d.getseventhquestionhead());
                    intent.putExtra("questionarray", d.getseventhquestiontext());
                    context.startActivity(intent);
                }


            }
        });

        return rowView;
    }

}
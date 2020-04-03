package com.example.examenatorproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> val;
    boolean[] check;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, ArrayList<String> val, boolean[] check){
        this.context = context;
        this.val = val;
        this.check = check;
    }

    @Override
    public int getCount() {
        return val.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View converView, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (converView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.item, null);
            TextView textView = view.findViewById(R.id.tvText);

            if (check[i])
                textView.setBackgroundResource(R.drawable.round_fill_button);
            else
                textView.setBackgroundResource(R.drawable.round_contour_button);

            textView.setText(val.get(i));

        }
        return view;
    }
}

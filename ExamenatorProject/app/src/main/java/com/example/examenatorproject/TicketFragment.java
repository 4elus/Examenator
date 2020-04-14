package com.example.examenatorproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.examenatorproject.Utils.statusTicket;

public class TicketFragment extends Fragment {
    View v;
    GridView gridView;

    public TicketFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.progress_ticket, container, false);

        if (Utils.numberTicket.size() == 0)
            for (int i = 0; i < 15; i++) {
                Utils.numberTicket.add(String.valueOf(i+1));
            }

        //СБОР ДАННЫХ ИЗ БД
        DbHelper dbHelper = new DbHelper(getActivity());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Utils.setStatusTicket(db);

        gridView = (GridView) v.findViewById(R.id.grid2);
        GridAdapter gridAdapter = new GridAdapter(getActivity(), Utils.numberTicket, Utils.statusTicket);
        gridView.setAdapter(gridAdapter);

        return v;
    }
}

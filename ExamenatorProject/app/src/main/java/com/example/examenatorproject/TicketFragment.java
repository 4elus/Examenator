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

<<<<<<< HEAD
import java.util.ArrayList;
=======
import static com.example.examenatorproject.Utils.statusTicket;
>>>>>>> aef97ba6fbf1a409fee8bd19654e4441ed953932

public class TicketFragment extends Fragment {
    View v;
    GridView gridView;

    public TicketFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.progress_ticket, container, false);

<<<<<<< HEAD
        ArrayList<String> numberQuestion = new ArrayList<>();

        for (int i = 0; i < 75; i++) {
            numberQuestion.add(String.valueOf(i+1));
        }

        gridView = (GridView) v.findViewById(R.id.grid2);
        GridAdapter gridAdapter = new GridAdapter(getActivity(), numberQuestion, Utils.statusQuestion);
=======
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
>>>>>>> aef97ba6fbf1a409fee8bd19654e4441ed953932
        gridView.setAdapter(gridAdapter);

        return v;
    }
}

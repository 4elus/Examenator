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

import static com.example.examenatorproject.Utils.*;

public class QuestionFragment extends Fragment {
    View v;

    GridView gridView;

    public QuestionFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.progress, container, false);

        if (Utils.numberQuestion.size() == 0)
            for (int i = 0; i < 75; i++){
                Utils.numberQuestion.add(String.valueOf(i+1));
            }
        //СБОР ДАННЫХ ИЗ БД
        DbHelper dbHelper = new DbHelper(getActivity());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Utils.setStatusQuestion(db);

        gridView = (GridView) v.findViewById(R.id.grid);
        GridAdapter gridAdapter = new GridAdapter(getActivity(), Utils.numberQuestion, Utils.statusQuestion);
        gridView.setAdapter(gridAdapter);
        return v;
    }


}

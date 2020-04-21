package com.example.examenatorproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class TicketFragment extends Fragment {
    View v;
    GridView gridView;

    public TicketFragment(){
        //for (int i = 0; i < 75; i++) {
            //Utils.numberQuestion.add(String.valueOf(i+1));

            /*if (i % 2 == 0)
                Utils.statusQuestion[i] = true;
            else
                Utils.statusQuestion[i] = false;*/
       // }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.progress_ticket, container, false);

        ArrayList<String> numberQuestion = new ArrayList<>();

        for (int i = 0; i < 75; i++) {
            numberQuestion.add(String.valueOf(i+1));
        }

        gridView = (GridView) v.findViewById(R.id.grid2);
        GridAdapter gridAdapter = new GridAdapter(getActivity(), numberQuestion, Utils.statusQuestion);
        gridView.setAdapter(gridAdapter);

        return v;
    }
}

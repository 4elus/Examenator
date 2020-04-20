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

        ArrayList<String> numberTicket = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            numberTicket.add(String.valueOf(i+1));
        }

        gridView = (GridView) v.findViewById(R.id.grid);
        GridAdapter gridAdapter = new GridAdapter(getActivity(), numberTicket, statusTicket);
        gridView.setAdapter(gridAdapter);
        return v;
    }


}

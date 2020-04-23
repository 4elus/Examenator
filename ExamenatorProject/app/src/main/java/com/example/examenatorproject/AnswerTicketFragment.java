package com.example.examenatorproject;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AnswerTicketFragment extends Fragment {
    View v;
    SpannableString textQuestion;
    TextView textViewQuestion;
    int numberTicket;
    int currnetQ;

    public AnswerTicketFragment(SpannableString textQuestion, int numberTicket, int currnetQ) {
        this.textQuestion = textQuestion;
        this.numberTicket = numberTicket;
        this.currnetQ = currnetQ;

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.show_answer, container, false);


        textViewQuestion = v.findViewById(R.id.textQuestion);
        textViewQuestion.setText(textQuestion);
        textViewQuestion.setTextSize(22);
        textViewQuestion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        textViewQuestion.setMovementMethod(LinkMovementMethod.getInstance());
        textViewQuestion.setHighlightColor(Color.TRANSPARENT);
        return v;
    }
}

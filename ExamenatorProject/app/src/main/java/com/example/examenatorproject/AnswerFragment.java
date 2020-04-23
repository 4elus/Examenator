package com.example.examenatorproject;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.graphics.Typeface;
import com.ortiz.touchview.TouchImageView;

public class AnswerFragment extends Fragment {


    View v;
    SpannableString textQuestion;
    TextView textViewQuestion;
    int numberTicket;
    int currnetQ;


    public AnswerFragment(SpannableString textQuestion, int numberTicket, int currnetQ) {
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

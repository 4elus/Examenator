package com.example.examenatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Utils.numberQuestion.size() == 0)
            setQuestionValueToList();

        if (Utils.numberTicket.size() == 0)
            setTicketValueToList();
    }

    public void clickProgress(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }

    public void showTickets(View view) {
        Intent intent = new Intent(this, TicketListActivity.class);
        startActivity(intent);
    }

    public void clickQuestion(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    public void clickExam(View view) {
        Intent intent = new Intent(this, TicketActivity.class);
        startActivity(intent);
    }

    public void setQuestionValueToList() {
        for (int i = 0; i < 75; i++) {
            Utils.numberQuestion.add(String.valueOf(i + 1));
            Utils.questionDuplicate.add(String.valueOf(i + 1));
        }
    }

    public void setTicketValueToList() {
        for (int i = 0; i < 15; i++)
            Utils.numberTicket.add(String.valueOf(i+1));
    }
}

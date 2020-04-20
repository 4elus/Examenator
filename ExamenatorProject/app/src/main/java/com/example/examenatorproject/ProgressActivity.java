package com.example.examenatorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.examenatorproject.Model.Question;
import com.example.examenatorproject.Model.Ticket;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {
    private ArrayList<Ticket> ticketsArrayList = new ArrayList<>();
    private ArrayList<Question> questionsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        this.setTitle("Прогресс");
        ticketsArrayList.addAll(Utils.ticketAppDatabase.getTicketDAO().getAllTickets());
        questionsArrayList.addAll(Utils.questionAppDatabase.getQuestionDAO().getAllQuestions());
    }

    public void clickQuestion(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new QuestionFragment());
        ft.commit();
    }

    public void clickTicket(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new TicketFragment());
        ft.commit();
    }

    public void resetTicket(View view) {
        Utils.countTicket = 15;
        for (int i = 0; i < Utils.countTicket; i++) {
            updateTicket("0", i);
            Utils.statusTicket[i] = false;
        }

        Utils.ticketDuplicate = new ArrayList<>();
        Utils.numberTicket = new ArrayList<>();
        Utils.ticketPassed = 0;

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void updateTicket(String status, int position){
        Ticket ticket = ticketsArrayList.get(position);

        ticket.setStatus(status);

        Utils.ticketAppDatabase.getTicketDAO().updateTicket(ticket);
        ticketsArrayList.set(position, ticket);
    }

    public void resetQuestion(View view) {
        Utils.countQuestion = 75;
        for (int i = 0; i < Utils.countQuestion; i++) {
            updateQuestion("0", i);
            Utils.statusQuestion[i] = false;
        }

        Utils.questionDuplicate = new ArrayList<>();
        Utils.numberQuestion = new ArrayList<>();
        Utils.questionPassed = 0;

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void updateQuestion(String questionStatus, int position){
        Question question = questionsArrayList.get(position);

        question.setStatus(questionStatus);

        Utils.questionAppDatabase.getQuestionDAO().updateQuestion(question);
        questionsArrayList.set(position, question);
    }
}

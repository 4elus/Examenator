package com.example.examenatorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenatorproject.Model.Question;
import com.example.examenatorproject.Model.Ticket;
import com.ortiz.touchview.TouchImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TicketActivity extends AppCompatActivity {

    private ArrayList<Ticket> ticketsArrayList = new ArrayList<>();
    private ArrayList<Question> questions;
    private boolean[] passedQuestions;
    private Button buttonSuccessful;
    private ScrollView scrollViewTicket;
    TextView textView;
    boolean accessCorrect;
    int numberTicket;
    String answer;
    double randNum;
    int currnetQ;
    int passedQ;
    int correctAnswer;
    Ticket t;
    FrameLayout frameLayout;


    ClickableSpan clickableSpan;
    ClickableSpan clickableSpan2;
    ClickableSpan clickableSpan3;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        button1 = findViewById(R.id.oneQ);
        button2 = findViewById(R.id.twoQ);
        button3 = findViewById(R.id.threeQ);
        button4 = findViewById(R.id.fourQ);
        button5 = findViewById(R.id.fiveQ);
        buttonSuccessful = findViewById(R.id.yesAnswer);
        textView = (TextView) findViewById(R.id.title_question);
        frameLayout = findViewById(R.id.container);
        scrollViewTicket = findViewById(R.id.ticketScrollView);
        ticketsArrayList.addAll(Utils.ticketAppDatabase.getTicketDAO().getAllTickets());

        if (savedInstanceState == null){
            numberTicket = getNumber();
            passedQuestions = new boolean[5];
            currnetQ = 1;
            correctAnswer = 0;
            questions = (ArrayList<Question>) Utils.questionAppDatabase.getQuestionDAO().getQuestion2(numberTicket-1);
            textView.setText(questions.get(0).getQuestion());

        }else{
            setDefaultColorButton();
            buttonSuccessful.setEnabled(savedInstanceState.getBoolean("access"));
            frameLayout.setVisibility(View.INVISIBLE);
            numberTicket = savedInstanceState.getInt("numTicket");

            button1.setEnabled(savedInstanceState.getBoolean("button1"));
            button2.setEnabled(savedInstanceState.getBoolean("button2"));
            button3.setEnabled(savedInstanceState.getBoolean("button3"));
            button4.setEnabled(savedInstanceState.getBoolean("button4"));
            button5.setEnabled(savedInstanceState.getBoolean("button5"));

            if (!button1.isEnabled()){
                button1.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
            }
            if (!button2.isEnabled()){
                button2.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
            }
            if (!button3.isEnabled()){
                button3.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
            }
            if (!button4.isEnabled()){
                button4.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
            }
            if (!button5.isEnabled()){
                button5.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
            }

            passedQuestions = savedInstanceState.getBooleanArray("passed");

            currnetQ = savedInstanceState.getInt("currentQ");
            correctAnswer = savedInstanceState.getInt("correct");
            passedQ = savedInstanceState.getInt("passedQuestion");
            textView.setText(savedInstanceState.getString("text"));

            switch (currnetQ){
                case 1:
                    button1.setTextColor(getResources().getColor(R.color.colorWhite));
                    break;
                case 2:
                    button2.setTextColor(getResources().getColor(R.color.colorWhite));
                    break;
                case 3:
                    button3.setTextColor(getResources().getColor(R.color.colorWhite));
                    break;
                case 4:
                    button4.setTextColor(getResources().getColor(R.color.colorWhite));
                    break;
                case 5:
                    button5.setTextColor(getResources().getColor(R.color.colorWhite));
                    break;

            }
            scrollViewTicket.fullScroll(ScrollView.FOCUS_UP);

        }

        if (numberTicket == -1) return;


        t = Utils.ticketAppDatabase.getTicketDAO().getTicket(numberTicket);
        questions = (ArrayList<Question>) Utils.questionAppDatabase.getQuestionDAO().getQuestion2(numberTicket-1);
        answer = questions.get(0).getAnswer();



        this.setTitle("Билет " + numberTicket);

        //SpannableString ss = new SpannableString("Более подробно можно раcсмотреть в приложении ....");
         clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                int key = 0;
                TouchImageView image = new TouchImageView(TicketActivity.this);
                TextView text = new TextView(TicketActivity.this);
                WebView wb = new WebView(TicketActivity.this);
                if (numberTicket == 1 && currnetQ == 3){
                    image.setImageResource(R.drawable.ptb193);
                }else if (numberTicket == 1 && currnetQ == 4){
                    image.setImageResource(R.drawable.table1);
                }else if (numberTicket == 2 && currnetQ == 2){
                    image.setImageResource(R.drawable.table46);
                }else if (numberTicket == 5 && currnetQ == 2){
                    text.setText(getResources().getText(R.string.messageWithLink));
                    text.setMovementMethod(LinkMovementMethod.getInstance());
                    key = 1;
                }else if (numberTicket == 7 && currnetQ == 4){
                    image.setImageResource(R.drawable.app6);
                }else if (numberTicket == 8 && currnetQ == 4){
                    image.setImageResource(R.drawable.app5);
                }else if (numberTicket == 11 && currnetQ == 4){
                    image.setImageResource(R.drawable.table1);
                }else if (numberTicket == 12 && currnetQ == 4){
                    wb.loadUrl("file:///android_asset/posters.html");
                    key = 2;
                }else if (numberTicket == 12 && currnetQ == 5){
                    image.setImageResource(R.drawable.notification);
                }else if (numberTicket == 14 && currnetQ == 4){
                    image.setImageResource(R.drawable.rsz_blank);
                    key = 3;
                }

              if (key == 1){
                  AlertDialog.Builder builder =
                          new AlertDialog.Builder(TicketActivity.this).
                                  setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                      @Override
                                      public void onClick(DialogInterface dialog, int which) {
                                          dialog.dismiss();
                                      }
                                  }).
                                  setView(text);
                  builder.create().show();
              }else if (key == 2){
                  AlertDialog.Builder builder =
                          new AlertDialog.Builder(TicketActivity.this).
                                  setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                      @Override
                                      public void onClick(DialogInterface dialog, int which) {
                                          dialog.dismiss();
                                      }
                                  }).
                                  setView(wb);
                  builder.create().show();
              }
              else{
                  AlertDialog.Builder builder =
                          new AlertDialog.Builder(TicketActivity.this).
                                  setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                      @Override
                                      public void onClick(DialogInterface dialog, int which) {
                                          dialog.dismiss();
                                      }
                                  }).
                                  setView(image);
                  builder.create().show();
              }
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };


        clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                TouchImageView image = new TouchImageView(TicketActivity.this);
                if (numberTicket == 1 && currnetQ == 3){
                    image.setImageResource(R.drawable.ptb193);
                }else if (numberTicket == 1 && currnetQ == 4){
                    image.setImageResource(R.drawable.stop);
                }else if (numberTicket == 7 && currnetQ == 4){
                    image.setImageResource(R.drawable.app7);
                }else if (numberTicket == 11 && currnetQ == 4){
                    image.setImageResource(R.drawable.table1);
                }else if (numberTicket == 12 && currnetQ == 4){
                    image.setImageResource(R.drawable.app5);
                }

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(TicketActivity.this).
                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(image);
                builder.create().show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                TouchImageView image = new TouchImageView(TicketActivity.this);
                if (numberTicket == 7 && currnetQ == 4){
                    image.setImageResource(R.drawable.ptb240);
                }

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(TicketActivity.this).
                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(image);
                builder.create().show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };




        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }

    public void showAnswer(View view) {
        accessCorrect = false;
        buttonSuccessful.setEnabled(accessCorrect);

       SpannableString ss;
        if (numberTicket == 1 && currnetQ == 3){
            ss = new SpannableString(answer);
            String clickable = "в пункте 193";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else if (numberTicket == 1 && currnetQ == 4){
            ss = new SpannableString(answer);
            String clickable = "таблице 1";
            String clickable2 = "приложению 9";

            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(clickableSpan2, answer.indexOf(clickable2), answer.indexOf(clickable2) + clickable2.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 2 && currnetQ == 2){
            ss = new SpannableString(answer);
            String clickable = "Сечение";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 5 && currnetQ == 2){
            ss = new SpannableString(answer);
            String clickable = "элегазового";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 7 && currnetQ == 4){
            ss = new SpannableString(answer);
            String clickable = "приложению 6";
            String clickable2 = "приложению 7";
            String clickable3 = "пунктом 240";

            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(clickableSpan2, answer.indexOf(clickable2), answer.indexOf(clickable2) + clickable2.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(clickableSpan3, answer.indexOf(clickable3), answer.indexOf(clickable3) + clickable3.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 8 && currnetQ == 4){
            ss = new SpannableString(answer);
            String clickable = "приложению 5";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 11 && currnetQ == 4){
            ss = new SpannableString(answer);
            String clickable = "таблице 1";

            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(clickableSpan2, answer.indexOf(clickable, answer.indexOf(clickable)+1), answer.indexOf(clickable, answer.indexOf(clickable)+1) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 12 && currnetQ == 4) {
            ss = new SpannableString(answer);
            String clickable = "запрещающие плакаты";
            String clickable2 = "приложению 5";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(clickableSpan2, answer.indexOf(clickable2), answer.indexOf(clickable2) + clickable2.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 12 && currnetQ == 5){
            ss = new SpannableString(answer);
            String clickable = "Смотреть схему";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else if (numberTicket == 14 && currnetQ == 4){
            ss = new SpannableString(answer);
            String clickable = "Бланк наряда";
            ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else{
            ss = new SpannableString(answer);
        }

       /*dialogAnswer = new AlertDialog.Builder(this).setMessage(ss)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        check();
                    }
                }).show();
        TextView textView = (TextView) dialogAnswer.findViewById(android.R.id.message);
        textView.setTextSize(12);
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);*/

        frameLayout.setVisibility(View.VISIBLE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new AnswerTicketFragment(ss, numberTicket, currnetQ));
        ft.commit();
    }

    private void updateQuestion(String ticketStatus){
        Ticket ticket = t;

        ticket.setStatus(ticketStatus);

        Utils.ticketAppDatabase.getTicketDAO().updateTicket(ticket);
        ticketsArrayList.set(numberTicket-1, ticket);
    }

    private int getNumber(){
        int size = Utils.countTicket;

        if (size > 0){
            Random random = new Random();
            randNum = random.nextInt(size) + 1;
            //int index = (int) randNum;
            int index = Integer.parseInt(Utils.ticketDuplicate.get((int)(randNum-1)));
            return index;
        }else{
            Toast.makeText(this, "Все билеты пройдены", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    public void navQuestion(View view) {
        frameLayout.setVisibility(View.INVISIBLE);
        buttonSuccessful.setEnabled(true);
        switch (view.getId()){
            case R.id.oneQ:
                textView.setText(questions.get(0).getQuestion());
                answer = questions.get(0).getAnswer();
                setDefaultColorButton();
                currnetQ = 1;

                button1.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.twoQ:
                textView.setText(questions.get(1).getQuestion());
                answer = questions.get(1).getAnswer();
                setDefaultColorButton();
                currnetQ = 2;

                button2.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.threeQ:
                textView.setText(questions.get(2).getQuestion());
                answer = questions.get(2).getAnswer();
                setDefaultColorButton();
                currnetQ = 3;

                button3.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.fourQ:
                textView.setText(questions.get(3).getQuestion());
                answer = questions.get(3).getAnswer();
                setDefaultColorButton();
                currnetQ = 4;

                button4.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case R.id.fiveQ:
                textView.setText(questions.get(4).getQuestion());
                answer = questions.get(4).getAnswer();
                setDefaultColorButton();
                currnetQ = 5;

                button5.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
        }
    }

    private void setDefaultColorButton(){
        button1.setTextColor(getResources().getColor(R.color.colorDivider));
        button2.setTextColor(getResources().getColor(R.color.colorDivider));
        button3.setTextColor(getResources().getColor(R.color.colorDivider));
        button4.setTextColor(getResources().getColor(R.color.colorDivider));
        button5.setTextColor(getResources().getColor(R.color.colorDivider));
    }

    public void correctAnswer(View view) {
        if (!passedQuestions[currnetQ-1]){
            correctAnswer += 1;
        }
        accessCorrect = true;
        check();
    }

    private void check(){
        switch (currnetQ){
            case 1:

                button1.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
                if (button1.isEnabled()) {
                    passedQ += 1;
                    passedQuestions[currnetQ-1] = true;
                }
                button1.setEnabled(false);
                nextQuestion();
                break;
            case 2:

                button2.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
                if (button2.isEnabled()) {
                    passedQ += 1;
                    passedQuestions[currnetQ-1] = true;
                }
                button2.setEnabled(false);
                nextQuestion();
                break;
            case 3:
                button3.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
                if (button3.isEnabled()) {
                    passedQ += 1;
                    passedQuestions[currnetQ-1] = true;
                }
                button3.setEnabled(false);
                nextQuestion();
                break;
            case 4:
                button4.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
                if (button4.isEnabled()) {
                    passedQ += 1;
                    passedQuestions[currnetQ-1] = true;
                }
                button4.setEnabled(false);
                nextQuestion();
                break;
            case 5:
                button5.setBackgroundTintList(getResources().getColorStateList(R.color.colorClose));
                if (button5.isEnabled()) {
                    passedQ += 1;
                    passedQuestions[currnetQ-1] = true;
                }
                button5.setEnabled(false);
                nextQuestion();
                break;
        }
        if (correctAnswer == 5){
            Utils.statusTicket[numberTicket-1] = true;
            Utils.ticketDuplicate.remove(String.valueOf(numberTicket));
            Utils.countTicket -= 1;
            Utils.ticketPassed += 1;
            updateQuestion("1");
            Toast.makeText(this, "Билет пройден", Toast.LENGTH_SHORT).show();
            home();
        }else{
            if (passedQ == 5){
                Toast.makeText(this, "Билет не пройден", Toast.LENGTH_SHORT).show();
                home();
            }
        }
    }

    private void nextQuestion(){
        frameLayout.setVisibility(View.INVISIBLE);
        buttonSuccessful.setEnabled(true);
        switch (currnetQ){
            case 1:
                textView.setText(questions.get(1).getQuestion());
                answer = questions.get(1).getAnswer();
                setDefaultColorButton();
                currnetQ = 2;
                button2.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case 2:
                textView.setText(questions.get(2).getQuestion());
                answer = questions.get(2).getAnswer();
                setDefaultColorButton();
                currnetQ = 3;
                button3.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case 3:
                textView.setText(questions.get(3).getQuestion());
                answer = questions.get(3).getAnswer();
                setDefaultColorButton();

                currnetQ = 4;
                button4.setTextColor(getResources().getColor(R.color.colorWhite));

                break;
            case 4:
                textView.setText(questions.get(4).getQuestion());
                answer = questions.get(4).getAnswer();
                setDefaultColorButton();
                currnetQ = 5;
                button5.setTextColor(getResources().getColor(R.color.colorWhite));

                break;
        }
    }

    private void home(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void closeAnswer(View view) {
        check();
        scrollViewTicket.fullScroll(ScrollView.FOCUS_UP);
        accessCorrect = true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("numTicket", numberTicket);

        outState.putBoolean("button1", button1.isEnabled());
        outState.putBoolean("button2", button2.isEnabled());
        outState.putBoolean("button3", button3.isEnabled());
        outState.putBoolean("button4", button4.isEnabled());
        outState.putBoolean("button5", button5.isEnabled());
        outState.putBooleanArray("passed", passedQuestions);
        outState.putInt("correct", correctAnswer);
        outState.putInt("currentQ", currnetQ);
        outState.putInt("passedQuestion", passedQ);
        outState.putString("text", textView.getText().toString());
        outState.putBoolean("access", accessCorrect);
    }
}
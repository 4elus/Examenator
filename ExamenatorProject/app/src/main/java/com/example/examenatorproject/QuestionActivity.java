package com.example.examenatorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenatorproject.Model.Question;
import com.example.examenatorproject.Model.Ticket;
import com.ortiz.touchview.TouchImageView;

import java.util.ArrayList;
import java.util.Random;
import android.widget.Button;

public class QuestionActivity extends AppCompatActivity {
    private double randNum;
    private Button buttonSuccessful;
    Question q;
    // private TicketAppDatabase ticketAppDatabase;
    private ArrayList<Ticket> ticketsArrayList = new ArrayList<>();

    // private QuestionAppDatabase questionAppDatabase;
    private ArrayList<Question> questionsArrayList = new ArrayList<>();
    String answer;
    TextView textView;
    ClickableSpan clickableSpan;
    ClickableSpan clickableSpan2;
    ClickableSpan clickableSpan3;
    int numberTicket;
    int currnetQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        buttonSuccessful = findViewById(R.id.yesAnswer);
        ticketsArrayList.addAll(Utils.ticketAppDatabase.getTicketDAO().getAllTickets());
        questionsArrayList.addAll(Utils.questionAppDatabase.getQuestionDAO().getAllQuestions());


        if (savedInstanceState == null){
            randNum = getNumber();
        }else{
            randNum = savedInstanceState.getDouble("numTicket");
            buttonSuccessful.setEnabled(savedInstanceState.getBoolean("enable"));
        }

        double ticket =  Math.ceil(randNum/5);
        int question = (randNum % 5 == 0) ? 5 : (int) (randNum % 5);
        long id = (long) randNum;



        q = Utils.questionAppDatabase.getQuestionDAO().getQuestion(id);


        answer = q.getAnswer();
        this.setTitle("Билет " + (int) ticket + ". " + "Вопрос " + question);
        numberTicket = (int) ticket;
        currnetQ = question;


        clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                int key = 0;
                TouchImageView image = new TouchImageView(QuestionActivity.this);
                TextView text = new TextView(QuestionActivity.this);
                WebView wb = new WebView(QuestionActivity.this);
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
                            new AlertDialog.Builder(QuestionActivity.this).
                                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            QuestionActivity.this.onBackPressed();
                                        }
                                    }).
                                    setView(text);
                    builder.create().show();
                }else if (key == 2){
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(QuestionActivity.this).
                                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            QuestionActivity.this.onBackPressed();
                                        }
                                    }).
                                    setView(wb);
                    builder.create().show();
                }
                else{
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(QuestionActivity.this).
                                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            QuestionActivity.this.onBackPressed();
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
                TouchImageView image = new TouchImageView(QuestionActivity.this);
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
                        new AlertDialog.Builder(QuestionActivity.this).
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
                TouchImageView image = new TouchImageView(QuestionActivity.this);
                if (numberTicket == 7 && currnetQ == 4){
                    image.setImageResource(R.drawable.ptb240);
                }

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(QuestionActivity.this).
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


        textView = (TextView) findViewById(R.id.title_question);
        textView.setText(q.getQuestion());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);


    }

    public void showAnswer(View view) {
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

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new AnswerFragment(ss, numberTicket, currnetQ));
        ft.commit();
    }

    public void correctAnswer(View view) {
        Utils.statusQuestion[(int) randNum-1] = true;
        Utils.questionDuplicate.remove(String.valueOf((int)randNum));
        Utils.countQuestion -= 1;
        Utils.questionPassed += 1;
        updateQuestion("1");

        home();
    }

    private void updateQuestion(String questionStatus){
        Question question = q;
        question.setStatus(questionStatus);

        Utils.questionAppDatabase.getQuestionDAO().updateQuestion(question);
        questionsArrayList.set((int) randNum-1, question);
    }

    private double getNumber(){
        int size = Utils.countQuestion;
        Random random = new Random();
        double randNum = random.nextInt(size) + 1;

        int index = Integer.parseInt(Utils.questionDuplicate.get((int)(randNum-1)));
        return index;

    }

    private void home(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("numTicket", randNum);
        outState.putBoolean("enable", false);

    }
}

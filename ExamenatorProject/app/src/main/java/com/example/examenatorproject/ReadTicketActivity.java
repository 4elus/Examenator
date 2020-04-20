package com.example.examenatorproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenatorproject.Model.Question;
import com.example.examenatorproject.Model.Ticket;
import com.ortiz.touchview.TouchImageView;

import java.util.ArrayList;

public class ReadTicketActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewAnswer;

    private ArrayList<Ticket> ticketsArrayList = new ArrayList<>();
    private ArrayList<Question> questions = new ArrayList<>();

    LinearLayout linearLayout;
    ClickableSpan clickableSpan;
    ClickableSpan clickableSpan2;
    ClickableSpan clickableSpan3;
    ClickableSpan clickableSpan4;
    String answer;
    int number;
    int[] question = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_ticket);

        linearLayout = findViewById(R.id.readLayout);
        Intent intent = getIntent();
        final int numberQ = intent.getIntExtra("number", -1);
        this.setTitle("Билет " + numberQ);

        
       /* textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewAnswer = findViewById(R.id.textAnswerForQuestion);

        ticketsArrayList.addAll(Utils.ticketAppDatabase.getTicketDAO().getAllTickets());
        questions = (ArrayList<Question>) Utils.questionAppDatabase.getQuestionDAO().getQuestion2(numberQ-1);

        textViewQuestion.setText(questions.get(0).getQuestion());*/
        ticketsArrayList.addAll(Utils.ticketAppDatabase.getTicketDAO().getAllTickets());
        questions = (ArrayList<Question>) Utils.questionAppDatabase.getQuestionDAO().getQuestion2(numberQ-1);
        TextView textView;
        number = 0;


        clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                int key = 0;
                TouchImageView image = new TouchImageView(ReadTicketActivity.this);
                TextView text = new TextView(ReadTicketActivity.this);
                WebView wb = new WebView(ReadTicketActivity.this);
                if (numberQ == 1 && question[0] == 3){
                    image.setImageResource(R.drawable.ptb193);
                }else if (numberQ == 2 && question[0] == 2){
                    image.setImageResource(R.drawable.table46);
                }else if (numberQ == 5 && question[0] == 2){
                    text.setText(getResources().getText(R.string.messageWithLink));
                    text.setMovementMethod(LinkMovementMethod.getInstance());
                    key = 1;
                }else if (numberQ == 7 && question[0] == 4){
                    image.setImageResource(R.drawable.app6);
                }else if (numberQ == 8 && question[0] == 4){
                    image.setImageResource(R.drawable.app5);
                }else if (numberQ == 11 && question[0] == 4){
                    image.setImageResource(R.drawable.table1);
                }else if (numberQ == 12 && question[0] == 4){
                    wb.loadUrl("file:///android_asset/posters.html");
                    key = 2;
                }else if (numberQ == 14 && question[0] == 4){
                    image.setImageResource(R.drawable.rsz_blank);
                }

                if (key == 1){
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(ReadTicketActivity.this).
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
                            new AlertDialog.Builder(ReadTicketActivity.this).
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
                            new AlertDialog.Builder(ReadTicketActivity.this).
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
                TouchImageView image = new TouchImageView(ReadTicketActivity.this);
                if (numberQ == 1 && question[1] == 4){
                    image.setImageResource(R.drawable.table1);
                }else if (numberQ == 7 && question[0] == 4){
                    image.setImageResource(R.drawable.app7);
                }else if (numberQ == 11 && question[1] == 4){
                    image.setImageResource(R.drawable.table1);
                }else if (numberQ == 12 && question[1] == 4){
                    image.setImageResource(R.drawable.app5);
                }

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(ReadTicketActivity.this).
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
                TouchImageView image = new TouchImageView(ReadTicketActivity.this);
                if (numberQ == 1 && question[2] == 4){
                    image.setImageResource(R.drawable.stop);
                }else if (numberQ == 7 && question[0] == 4){
                    image.setImageResource(R.drawable.ptb240);
                }else if (numberQ == 12 && question[2] == 4){
                    image.setImageResource(R.drawable.notification);
                }

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(ReadTicketActivity.this).
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


        for (int i = 1; i <= 10; i++) {
            textView = new TextView(this);
            textView.setId(i);

            answer = questions.get(number).getAnswer();

            //-------------------

            SpannableString ss;
            if (numberQ == 1 && number == 2){
                ss = new SpannableString(answer);
                String clickable = "в пункте 193";
                question[0] = 3;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            else if (numberQ == 1 && number == 3){
                ss = new SpannableString(answer);
                String clickable = "таблице 1";
                String clickable2 = "приложению 9";
                question[1] = 4;
                question[2] = 4;
                ss.setSpan(clickableSpan2, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(clickableSpan3, answer.indexOf(clickable2), answer.indexOf(clickable2) + clickable2.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 2 && number == 1){
                ss = new SpannableString(answer);
                String clickable = "Сечение";
                question[0] = 2;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 5 && number == 1){
                ss = new SpannableString(answer);
                String clickable = "элегазового";
                question[0] = 2;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 7 && number == 3){
                ss = new SpannableString(answer);
                String clickable = "приложению 6";
                String clickable2 = "приложению 7";
                String clickable3 = "пунктом 240";
                question[0] = 4;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(clickableSpan2, answer.indexOf(clickable2), answer.indexOf(clickable2) + clickable2.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(clickableSpan3, answer.indexOf(clickable3), answer.indexOf(clickable3) + clickable3.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 8 && number == 3){
                ss = new SpannableString(answer);
                String clickable = "приложению 5";
                question[0] = 4;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 11 && number == 3){
                ss = new SpannableString(answer);
                String clickable = "таблице 1";
                question[0] = 4;
                question[1] = 4;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(clickableSpan2, answer.indexOf(clickable, answer.indexOf(clickable)+1), answer.indexOf(clickable, answer.indexOf(clickable)+1) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 12 && number == 3) {
                ss = new SpannableString(answer);
                String clickable = "запрещающие плакаты";
                String clickable2 = "приложению 5";
                question[0] = 4;
                question[1] = 4;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(clickableSpan2, answer.indexOf(clickable2), answer.indexOf(clickable2) + clickable2.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 12 && number == 4){
                ss = new SpannableString(answer);
                String clickable = "Смотреть схему";
                question[2] = 4;
                ss.setSpan(clickableSpan3, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if (numberQ == 14 && number == 3){
                ss = new SpannableString(answer);
                String clickable = "Бланк наряда";
                question[0] = 4;
                ss.setSpan(clickableSpan, answer.indexOf(clickable), answer.indexOf(clickable) + clickable.length()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            else{
                ss = new SpannableString(answer);
            }

            //----------------------


            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0, 40, 0, 0); // llp.setMargins(left, top, right, bottom);
            if (i % 2 != 0){
                textView.setBackgroundColor(getResources().getColor(R.color.colorLight));
                textView.setText((number + 1) + ". " + questions.get(number).getQuestion());
                Typeface font = Typeface.createFromAsset(getAssets(), "robo.ttf");
                textView.setTypeface(font);
                textView.setTextSize(16);
            }else{
                textView.setBackgroundColor(getResources().getColor(R.color.colorLightYellowText));
                textView.setText(ss);
                textView.setTextSize(14);

                textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setHighlightColor(Color.TRANSPARENT);
                number += 1;
            }




            textView.setPadding(10, 10, 10, 10);
            textView.setLayoutParams(llp);
            linearLayout.addView(textView);
        }
    }
}

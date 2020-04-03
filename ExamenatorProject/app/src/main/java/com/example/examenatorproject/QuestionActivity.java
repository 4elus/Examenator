package com.example.examenatorproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ortiz.touchview.TouchImageView;

import java.util.ArrayList;
import java.util.Random;


public class QuestionActivity extends AppCompatActivity {
    private double randNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Random random = new Random();

        randNum = getNumber();
        double ticket =  Math.ceil(randNum/5);
        int question = (randNum % 5 == 0) ? 5 : (int) (randNum % 5);

        this.setTitle("Билет " + (int) ticket + ". " + "Вопрос " + question);

        SpannableString ss = new SpannableString("Более подробно можно раcсмотреть в таблице");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                TouchImageView image = new TouchImageView(QuestionActivity.this);
                image.setImageResource(R.drawable.table1);

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
        ss.setSpan(clickableSpan, 35, 42, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.text2);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);

    }

    public void showAnswer(View view) {
        ExampleDialog exampleDialog = new ExampleDialog("Идейные соображения высшего порядка");
        exampleDialog.show(getSupportFragmentManager(), "TEst");
    }

    public void correctAnswer(View view) {
        Utils.statusQuestion[(int) randNum-1] = true;
        Toast.makeText(this, "Test: " + randNum, Toast.LENGTH_SHORT).show();
    }

    private double getNumber(){
        int size = Utils.countQuestion;


        Random random = new Random();
        double randNum = random.nextInt(size) + 1;
        int index = (int) randNum;

        Utils.questionDuplicate.remove(String.valueOf(index));

        Utils.countQuestion -= 1;
        return index;
    }
}

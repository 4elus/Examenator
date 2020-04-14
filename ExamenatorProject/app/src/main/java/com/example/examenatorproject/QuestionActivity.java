package com.example.examenatorproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
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
    public DbHelper dbHelper;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Random random = new Random();
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        randNum = getNumber();
        double ticket =  Math.ceil(randNum/5);
        int question = (randNum % 5 == 0) ? 5 : (int) (randNum % 5);
        this.setTitle("Билет " + (int) ticket + ". " + "Вопрос " + question);

        //код с ссылками пока хзхз как с ним
/*        SpannableString ss = new SpannableString("Более подробно можно раcсмотреть в таблице");
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


        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);*/

        TextView textView = (TextView) findViewById(R.id.textQuestion);
        textView.setText(getQuestionText((int) randNum));
    }

    public void showAnswer(View view) {
        //надо как-то придумать как оформить вопросы
        ExampleDialog exampleDialog = new ExampleDialog("Идейные соображения высшего порядка");
        exampleDialog.show(getSupportFragmentManager(), "TEst");
    }

    public void correctAnswer(View view) {
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.STATUS, 1);
        db.update(DbHelper.TABLE_QUESTION, cv, DbHelper._ID + "=" + String.valueOf((int)randNum), null);

        Utils.setStatusQuestion(this.db);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public String getQuestionText(int id)
    {
        String result = "";
        Cursor c = db.query(DbHelper.TABLE_QUESTION, new String[]{DbHelper._ID, DbHelper.TEXT},
                DbHelper._ID + "=" + String.valueOf(id),  null, null, null, null);

        if(c.moveToPosition(0)){
            result = c.getString(c.getColumnIndex(DbHelper.TEXT));
        }
        c.close();

        return result;
    }

    private int getNumber(){
        int size = Utils.countQuestion;

        Random random = new Random();
        int index = 0;

        while(true)
        {
            index = (int) (random.nextInt(size) + 1);
            if(Utils.statusQuestion[index - 1])
                continue;
            else
                break;
        }

        return index;
    }
}

package com.example.examenatorproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ortiz.touchview.TouchImageView;

import java.util.Random;

public class TicketActivity extends AppCompatActivity {

    public DbHelper dbHelper;
    public SQLiteDatabase db;
    public int currentTicket;
    public int currentQuestion;
    public int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Random random = new Random();
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();
        result = 0;

        currentTicket = getNumber();
        this.setTitle("Билет " + currentTicket);
        currentQuestion = 1;
        changePanel(currentQuestion);


/*        SpannableString ss = new SpannableString("Более подробно можно раcсмотреть в приложении ....");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                TouchImageView image = new TouchImageView(TicketActivity.this);
                image.setImageResource(R.drawable.app6);

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
        ss.setSpan(clickableSpan, 35, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.title_question);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);*/
    }

    public void showAnswer(View view) {
        ExampleDialog exampleDialog = new ExampleDialog("Ответ к вопросу");
        exampleDialog.show(getSupportFragmentManager(), "TEst");

        if(currentQuestion < 5)
        {
            currentQuestion++;
            changePanel(currentQuestion);
        }
        else
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    public void correctAnswer(View view) {
        result++;

        if(currentQuestion < 5)
        {
            currentQuestion++;
            changePanel(currentQuestion);
        }
        else
        {
            if(result == 5)
            {
                ContentValues cv = new ContentValues();
                cv.put(DbHelper.STATUS, 1);
                db.update(DbHelper.TABLE_TICKET, cv, DbHelper._ID + "=" + String.valueOf(currentTicket), null);

                Utils.setStatusQuestion(this.db);
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public int getNumber()
    {
        int size = Utils.countTicket;

        Random random = new Random();
        int index = 0;

        while(true)
        {
            index = (int) (random.nextInt(size) + 1);
            if(Utils.statusTicket[index - 1])
                continue;
            else
                break;
        }

        return index;
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

    public void changePanel(int index)
    {
        TextView textQue = (TextView) findViewById(R.id.title_question);
        textQue.setText(getQuestionText((currentTicket - 1)*5 + index));

        Button button;
        switch(currentQuestion)
        {
            case 2:
                button = (Button) findViewById(R.id.topFirst);
                button.setTextColor(getResources().getColor(R.color.colorDivider));
                button = (Button) findViewById(R.id.topSecond);
                button.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case 3:
                button = (Button) findViewById(R.id.topSecond);
                button.setTextColor(getResources().getColor(R.color.colorDivider));
                button = (Button) findViewById(R.id.topThird);
                button.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case 4:
                button = (Button) findViewById(R.id.topThird);
                button.setTextColor(getResources().getColor(R.color.colorDivider));
                button = (Button) findViewById(R.id.topForth);
                button.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
            case 5:
                button = (Button) findViewById(R.id.topForth);
                button.setTextColor(getResources().getColor(R.color.colorDivider));
                button = (Button) findViewById(R.id.topFifth);
                button.setTextColor(getResources().getColor(R.color.colorWhite));
                break;
        }

    }

}

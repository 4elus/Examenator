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

import com.ortiz.touchview.TouchImageView;

import java.util.Random;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Random random = new Random();
        int countTicket = 15;
        int numberTicket = random.nextInt(countTicket) + 1;
        this.setTitle("Билет " + numberTicket);

        SpannableString ss = new SpannableString("Более подробно можно раcсмотреть в приложении ....");
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
        textView.setHighlightColor(Color.TRANSPARENT);
    }

    public void showAnswer(View view) {
        ExampleDialog exampleDialog = new ExampleDialog("Ответ к вопросу");
        exampleDialog.show(getSupportFragmentManager(), "TEst");
    }
}

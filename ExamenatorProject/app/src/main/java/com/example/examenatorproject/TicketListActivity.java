package com.example.examenatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class TicketListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);
        this.setTitle("Список билетов");

        GridLayout gridLayout = (GridLayout)findViewById(R.id.tableGrid);
        gridLayout.removeAllViews();

        Button button = null;
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(5);

        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++) {
                button = new Button(this);
                button.setId((5 * i) + 1 + j);
                button.setText(String.valueOf((5 * i) + 1 + j));
                button.setBackgroundResource(R.drawable.bg_for_btn);

                Typeface font = Typeface.createFromAsset(getAssets(), "robo.ttf");
                button.setTypeface(font);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numberQ = v.getId();
                        Intent intent = new Intent(getApplicationContext(), ReadTicketActivity.class);
                        intent.putExtra("number", numberQ);
                        startActivity(intent);

                    }});
                gridLayout.addView(button);
            }
        }
    }
}

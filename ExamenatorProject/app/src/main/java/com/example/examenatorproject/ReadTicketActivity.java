package com.example.examenatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReadTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_ticket);

        Intent intent = getIntent();
        int numberQ = intent.getIntExtra("number", -1);
        this.setTitle("Билет " + numberQ);
        //TextView titleTV = findViewById(R.id.ticketNumber);
       // titleTV.setText("Билет - " + numberQ);
    }
}

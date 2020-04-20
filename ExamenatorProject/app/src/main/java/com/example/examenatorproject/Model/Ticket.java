package com.example.examenatorproject.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tickets")
public class Ticket {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ticket_id")
    private long id;

    @ColumnInfo(name = "ticket_status")
    private String status;

    @ColumnInfo(name = "ticket_number")
    private int number;

    @Ignore
    public Ticket() {
    }



    public Ticket(long id, String status, int number) {
        this.id = id;
        this.status = status;
        this.number = number;
    }

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

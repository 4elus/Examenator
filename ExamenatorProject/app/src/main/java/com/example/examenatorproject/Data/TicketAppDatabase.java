package com.example.examenatorproject.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.examenatorproject.Model.Ticket;

@Database(entities = {Ticket.class}, version = 2)
public abstract class TicketAppDatabase extends RoomDatabase {
    public abstract TicketDAO getTicketDAO();
}

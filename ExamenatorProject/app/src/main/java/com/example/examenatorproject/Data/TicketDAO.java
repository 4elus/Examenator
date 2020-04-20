package com.example.examenatorproject.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.examenatorproject.Model.Ticket;

import java.util.List;

@Dao
public interface TicketDAO {
    @Insert
    public long addTicket(Ticket ticket);

    @Update
    public void updateTicket(Ticket ticket);

    @Delete()
    public void deleteTicket(Ticket ticket);

    @Query("select * from tickets")
    public List<Ticket> getAllTickets();

    @Query("select * from tickets where ticket_id =:ticketId ")
    public Ticket getTicket(long ticketId);

    @Query("DELETE FROM tickets")
    public void clearTable();


}
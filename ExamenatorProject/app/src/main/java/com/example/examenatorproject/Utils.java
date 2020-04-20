package com.example.examenatorproject;

import com.example.examenatorproject.Data.QuestionAppDatabase;
import com.example.examenatorproject.Data.TicketAppDatabase;

import java.util.ArrayList;

public class  Utils {
    public static int countTicket = 15;
    public static int ticketPassed = 0;

    public static  ArrayList<String> numberTicket = new ArrayList<>();
    public static boolean[] statusTicket = new boolean[countTicket];
    public static ArrayList<String> ticketDuplicate = new ArrayList<>();

    public static int countQuestion = 75;
    public static int questionPassed = 0;
    public static ArrayList<String> numberQuestion = new ArrayList<>();
    public static ArrayList<String> questionDuplicate = new ArrayList<>();
    public static boolean[] statusQuestion = new boolean[countQuestion];

    public static QuestionAppDatabase questionAppDatabase;
    public static TicketAppDatabase ticketAppDatabase;
}

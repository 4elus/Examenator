package com.example.examenatorproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class  Utils {
    public static int countTicket = 15;
    public static  ArrayList<String> numberTicket = new ArrayList<>();
    public static boolean[] statusTicket = new boolean[countTicket];

    public static int countQuestion = 75;
    public static ArrayList<String> numberQuestion = new ArrayList<>();
    public static ArrayList<String> questionDuplicate = new ArrayList<>();
    public static boolean[] statusQuestion = new boolean[countQuestion];


    public static void setStatusQuestion(SQLiteDatabase database)
    {
        Cursor cur = database.query(DbHelper.TABLE_QUESTION, new String[] {DbHelper._ID, DbHelper.STATUS}, null, null, null, null, null);
        if (cur.moveToFirst()) {
            do {
                int id = cur.getInt(cur.getColumnIndex(DbHelper._ID)) - 1;
                System.out.println("**********************************************************");
                if(cur.getInt(cur.getColumnIndex(DbHelper.STATUS)) == 1)
                    statusQuestion[id] = true;
                else
                    statusQuestion[id] = false;
            } while (cur.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cur.close();
    }

    public static void setStatusTicket(SQLiteDatabase database)
    {
        Cursor cur = database.query(DbHelper.TABLE_TICKET, new String[] {DbHelper._ID, DbHelper.STATUS}, null, null, null, null, null);
        if (cur.moveToFirst()) {
            do {
                int id = cur.getInt(cur.getColumnIndex(DbHelper._ID)) - 1;
                System.out.println("**********************************************************");
                if(cur.getInt(cur.getColumnIndex(DbHelper.STATUS)) == 1)
                    statusTicket[id] = true;
                else
                    statusTicket[id] = false;
            } while (cur.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cur.close();
    }

}

package com.example.examenatorproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 6;
    public static final String DATABASE_NAME = "examenatorDB";
    /*COMMON*/
    public static final String _ID = "_id";
    public static final String STATUS = "status";
    /*TIKETS*/
    public static final String TABLE_TICKET = "tickets";
    /*QUESTIONS*/
    public static final String TABLE_QUESTION = "questions";
    public static final String TEXT = "text";
    public static final String IMAGE = "image";
    /*UNION*/
    public static final String TABLE_UNION = "unions";
    public static final String TICKET_ID = "ticket_id";
    public static final String QUESTION_ID = "question_id";


    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "create table " + TABLE_TICKET + "(" +
                            _ID + " integer primary key, " +
                            STATUS + " integer)");
            db.execSQL(
                    "create table " + TABLE_QUESTION + "(" +
                            _ID + " integer primary key, " +
                            STATUS + " integer, " +
                            TEXT + " string, " +
                            IMAGE + " string)");
            db.execSQL(
                    "create table " + TABLE_UNION + "(" +
                            TICKET_ID + " integer, " +
                            QUESTION_ID + " integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TICKET);
        db.execSQL("drop table if exists " + TABLE_QUESTION);
        db.execSQL("drop table if exists " + TABLE_UNION);

        onCreate(db);
    }
}

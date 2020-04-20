package com.example.examenatorproject.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.examenatorproject.Model.Question;

@Database(entities = {Question.class}, version = 2)
public abstract class QuestionAppDatabase extends RoomDatabase {
    public abstract QuestionDAO getQuestionDAO();
}

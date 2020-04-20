package com.example.examenatorproject.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id")
    private long id;

    @ColumnInfo(name = "number_ticket")
    private String number_ticke;

    @ColumnInfo(name = "question_text")
    private String question;

    @ColumnInfo(name = "question_status")
    private String status;

    @ColumnInfo(name = "question_answer")
    private String answer;

    @Ignore
    public Question(){

    }


    public Question(long id, String number_ticke, String question, String status, String answer) {
        this.id = id;
        this.number_ticke = number_ticke;
        this.question = question;
        this.status = status;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber_ticke() {
        return number_ticke;
    }

    public void setNumber_ticke(String number_ticke) {
        this.number_ticke = number_ticke;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}


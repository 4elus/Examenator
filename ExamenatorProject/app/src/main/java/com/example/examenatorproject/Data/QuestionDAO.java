package com.example.examenatorproject.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.examenatorproject.Model.Question;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Insert
    public long addQuestion(Question question);

    @Update
    public void updateQuestion(Question question);

    @Delete()
    public void deleteQuestion(Question question);

    @Query("select * from questions")
    public List<Question> getAllQuestions();

    @Query("select * from questions where question_id =:questionId ")
    public Question getQuestion(long questionId);

    @Query("select * from questions where number_ticket =:questionId ")
    public List<Question> getQuestion2(long questionId);


    @Query("DELETE FROM questions")
    public void clearTable();
}

package com.first.Quiz.App.Dao;

import com.first.Quiz.App.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}

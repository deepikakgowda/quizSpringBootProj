package com.sample.quiz.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.quiz.app.model.QuizQuestion;

@Repository
public interface QuizDao extends JpaRepository<QuizQuestion, Integer> {

}

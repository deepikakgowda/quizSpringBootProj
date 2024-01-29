package com.sample.quiz.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.quiz.app.model.Quiz;

@Repository
public interface QuestionDao extends JpaRepository<Quiz, Integer>{
	
	List<Quiz> findByCategory(String category);

	@Query(value = "select * from quiz q where q.category=:category ORDER BY RANDOM() LIMIT :numQ ", nativeQuery = true)
	List<Quiz> findRandomQuestionByCategory(String category, int numQ);

}

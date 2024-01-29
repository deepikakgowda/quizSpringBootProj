package com.sample.quiz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.quiz.app.Dao.QuestionDao;
import com.sample.quiz.app.model.Quiz;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public List<Quiz> getAllQuestions()
	{
		System.out.println(questionDao.findAll());
		return questionDao.findAll();
		
	}
	
	public List<Quiz> getQuestionByCategory(String category)
	{
		return questionDao.findByCategory(category);
	}
	
	public String addQuestion(Quiz quiz)
	{
		questionDao.save(quiz);
		return "success";
	}
	
	public String deleteQuestion(int id)
	{
		questionDao.deleteById(id);
		return "deleted";
	}
	
	public String updateQuestion(Quiz quiz)
	{
		questionDao.save(quiz);
		return "updated";
	}

}

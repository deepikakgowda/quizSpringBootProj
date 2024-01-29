package com.sample.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.quiz.app.model.Quiz;
import com.sample.quiz.app.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestion")
	public List<Quiz> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{cat}")
	public List<Quiz> getQuestionByCategory(@PathVariable("cat") String category)
	{
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Quiz quiz)
	{
		return questionService.addQuestion(quiz);
		
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable int id)
	{
		return questionService.deleteQuestion(id);
	}
	
	@PutMapping("update")
	public String updateQuestion(@RequestBody Quiz quiz)
	{
		return questionService.updateQuestion(quiz);
	}
}

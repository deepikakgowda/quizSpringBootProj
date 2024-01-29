package com.sample.quiz.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class QuizQuestion {
	
	@Id
	private int id;
	private String title;
    @ManyToMany
	private List<Quiz> question;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Quiz> getQuestion() {
		return question;
	}
	public void setQuestion(List<Quiz> question) {
		this.question = question;
	}
    
    

}

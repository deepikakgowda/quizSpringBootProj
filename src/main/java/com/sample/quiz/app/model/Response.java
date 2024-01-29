package com.sample.quiz.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {

	private int id;
	private String Response;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}
	
	
}

package com.sample.quiz.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.quiz.app.Dao.QuestionDao;
import com.sample.quiz.app.Dao.QuizDao;
import com.sample.quiz.app.model.QuestionWrapper;
import com.sample.quiz.app.model.Quiz;
import com.sample.quiz.app.model.QuizQuestion;
import com.sample.quiz.app.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title)
	{
		List<Quiz> question = questionDao.findRandomQuestionByCategory(category,numQ);
		
		QuizQuestion quizQuestion = new QuizQuestion();
		quizQuestion.setTitle(title);
		quizQuestion.setQuestion(question);
		quizDao.save(quizQuestion);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		Optional<QuizQuestion> question = quizDao.findById(id);
		List<Quiz> questionFromDb = question.get().getQuestion();
		List<QuestionWrapper> questionWrapper = new ArrayList<>();
		for (Quiz q : questionFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestions(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionWrapper.add(qw);

		}
		return new ResponseEntity<>(questionWrapper, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateQuiz(int id, List<Response> response) {
		Optional<QuizQuestion> quizQuestion = quizDao.findById(id);
		List<Quiz> questionList = quizQuestion.get().getQuestion();
		int rightAns = 0;
		int i = 0;
		for (Quiz quiz : questionList) {
			if (quiz.getRightAnswer().equals(response.get(i).getResponse())) {
				rightAns++;
			}
			i++;
		}
		return new ResponseEntity<>(rightAns,HttpStatus.OK);
	}
}

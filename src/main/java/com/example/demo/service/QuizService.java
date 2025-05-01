package com.example.demo.service;


import com.example.demo.DAO.QuizDao;
import com.example.demo.Model.QuestionAnswer;
import com.example.demo.Model.QuestionWraper;

import com.example.demo.Model.Quiz;
import com.example.demo.feign.QuizInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterFace quizInterFace;

    public ResponseEntity<String> createQuiz(String category, int numQ, String tittle) {

    List<Integer> questionIds = quizInterFace.generateQuestions(category,numQ).getBody();

    Quiz quiz =new Quiz();
    quiz.setTitle(tittle);
    quiz.setQuestionIds(questionIds);
    quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWraper>> getUserQuestion(Integer id) {
          Quiz quiz = quizDao.findById(id).get();
          List<Integer> questionIds = quiz.getQuestionIds();
          List<QuestionWraper> questionWrapper = quizInterFace.getQuestionsForQuiz(questionIds).getBody();


        return new ResponseEntity<>(questionWrapper,HttpStatus.OK);

    }

    public ResponseEntity<Integer> QuizResult(Integer id,List<QuestionAnswer> response) {

        Integer result = quizInterFace.quizResult(response).getBody();

        return new ResponseEntity<>( result ,HttpStatus.BAD_REQUEST);
    }
}

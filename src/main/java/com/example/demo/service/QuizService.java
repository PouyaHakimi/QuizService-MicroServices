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


       // List<Integer> questions = //call the generate url
//
//        Quiz quiz = new Quiz();
//        quiz.setTitle(tittle);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWraper>> getUserQuestion(Integer id) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWraper> userQuestions = new ArrayList<>();
//
//        for (Question q: questionFromDB){
//            QuestionWraper qw =new QuestionWraper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
//            userQuestions.add(qw);
//        }

        return new ResponseEntity<>(userQuestions,HttpStatus.OK);

    }

    public ResponseEntity<Integer> QuizResult(Integer id,List<QuestionAnswer> response) {


//        Optional<Quiz> quiz =quizDao.findById(id);
//        if (!quiz.isPresent()) {
//            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
//        }
//        List<Question> questionsFromDB = quiz.get().getQuestions();
//
//        if (response.size() != questionsFromDB.size()) {
//            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
//        }
          int right = 0;
//        int i = 0;
       try {
//        for(QuestionAnswer q :response) {
//
//            if( q.getAnswer().equals(questionsFromDB.get(i).getRightAnswer()))
//                right++;
//        i++;
//        }

            return new ResponseEntity<>(right, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( 0 ,HttpStatus.BAD_REQUEST);
    }
}

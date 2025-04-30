package com.example.demo.controller;

import com.example.demo.Model.QuestionAnswer;
import com.example.demo.Model.QuestionWraper;
import com.example.demo.Model.QuizDto;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumberOfQuestion(),quizDto.getTitle());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWraper>> getUserQuestion(@PathVariable Integer id){
        return quizService.getUserQuestion(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> QuizResult(@PathVariable Integer id,@RequestBody List<QuestionAnswer> response){
        return quizService.QuizResult(id,response);
    }

}

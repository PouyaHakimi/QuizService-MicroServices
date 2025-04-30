package com.example.demo.controller;

import com.pouya.QuizApp.Model.QuestionAnswer;
import com.pouya.QuizApp.Model.QuestionWraper;
import com.pouya.QuizApp.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ ,@RequestParam String tittle){
        return quizService.createQuiz(category,numQ,tittle);
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

package com.example.demo.feign;

import com.example.demo.Model.QuestionAnswer;
import com.example.demo.Model.QuestionWraper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterFace {


    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category , @RequestParam Integer numQ );


    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWraper>> getQuestionsForQuiz(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> quizResult(@RequestBody List<QuestionAnswer> answers );

}

package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Quiz {

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getQuestions() {
        return questionIds;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Integer> questions) {
        this.questionIds = questions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String title;
    @ElementCollection
    private List<Integer> questionIds;
}

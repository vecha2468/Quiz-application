package com.first.Quiz.App.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    private Integer id;

    @JsonProperty
    private String questionTitle;

    @JsonProperty
    private String option1;

    @JsonProperty
    private String option2;

    @JsonProperty
    private String option3;

    @JsonProperty
    private String option4;

    @JsonProperty
    private String rightAnswer;

    @JsonProperty
    private String difficultyLevel;

    @JsonProperty
    private String category;

    public Integer getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getCategory() {
        return category;
    }
}
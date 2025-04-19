package com.first.Quiz.App.Controller;

import com.first.Quiz.App.Model.Question;
import com.first.Quiz.App.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllquestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public  ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody  Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("updatequestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("deletequestion/{id}")
    public  ResponseEntity<String> deleteQuestion (@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }



}

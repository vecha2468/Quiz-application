package com.first.Quiz.App.Controller;



import com.first.Quiz.App.Model.QuestionWrapper;
import com.first.Quiz.App.Model.Response;
import com.first.Quiz.App.Service.QuizService;
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
    public ResponseEntity<String> crateRQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title)
    {
        return quizService.createRquiz(category,numQ,title);
    }

    @GetMapping("get")
    public ResponseEntity<List<QuestionWrapper>>getQuiz(@RequestParam Integer id){
        return  quizService.getQuiz(id);
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer>getResult(@PathVariable Integer quizId, @RequestBody List<Response> responses){
        System.out.println(responses);
        return  quizService.getResult(quizId,responses);
    }
}

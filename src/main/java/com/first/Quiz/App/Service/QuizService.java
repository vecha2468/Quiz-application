package com.first.Quiz.App.Service;


import com.first.Quiz.App.Dao.QuestionDao;
import com.first.Quiz.App.Dao.QuizDao;
import com.first.Quiz.App.Model.Question;
import com.first.Quiz.App.Model.QuestionWrapper;
import com.first.Quiz.App.Model.Quiz;
import com.first.Quiz.App.Model.Response;
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
    QuestionDao questionDao;


    public ResponseEntity<String> createRquiz(String category, Integer numQ, String title)
    {
        List<Question> questions= questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz rquiz= new Quiz();
        rquiz.setTitle(title);
        rquiz.setQuestions(questions);

        quizDao.save(rquiz);
        return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questions=quiz.get().getQuestions();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();

        for (Question q:questions){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionWrappers.add(qw);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}

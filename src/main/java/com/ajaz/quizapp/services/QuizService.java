package com.ajaz.quizapp.services;

import com.ajaz.quizapp.Dao.QuestionDao;
import com.ajaz.quizapp.Dao.QuizDao;
import com.ajaz.quizapp.models.Question;
import com.ajaz.quizapp.models.QuestionWrapper;
import com.ajaz.quizapp.models.Quiz;
import com.ajaz.quizapp.models.Response;
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
    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        if(quiz.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(),
                    q.getOption2(), q.getOption3(), q.getOption4());

            questionsForUser.add(qw);
        }


        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);

        if(quiz.isEmpty()){
            return new ResponseEntity<>(1, HttpStatus.BAD_REQUEST);
        }

        List<Question> questions = quiz.get().getQuestions();
        Integer count = 0;

        for(Question q : questions){
            System.out.println(q.getId() + " " + q.getRightAnswer());
            for(Response r : responses) {
                System.out.println(r.getId() + " " + r.getResponse());
                if (q.getId() == r.getId() && q.getRightAnswer().equals(r.getResponse()))
                    count += 1;
            }
            System.out.println("-------------------------------");
        }

        return new ResponseEntity<>(count, HttpStatus.OK);

    }
}

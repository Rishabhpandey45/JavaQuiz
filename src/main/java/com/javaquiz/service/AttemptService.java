package com.javaquiz.service;

import com.javaquiz.dao.AttemptDAO;
import com.javaquiz.dao.api.AttemptRepository;
import com.javaquiz.exception.QuizException;
import com.javaquiz.model.Question;
import com.javaquiz.service.api.ScoringService;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/** Thread-safe service responsible for scoring and persisting attempts. */
public class AttemptService implements ScoringService {
    private final AttemptRepository repository;

    public AttemptService() { this(new AttemptDAO()); }
    public AttemptService(AttemptRepository repository) { this.repository = repository; }

    @Override
    public synchronized int[] score(int userId, Integer topicId, List<Question> questions,
                                    Map<Integer, Integer> answers) throws QuizException {
        if (questions == null || questions.isEmpty()) throw new QuizException("Quiz has no questions.");
        int right=0, wrong=0, skip=0;
        for (Question q : questions) {
            Integer a=answers.get(q.getId());
            if (a==null || a<0) skip++;
            else if (a==q.getCorrectOption()) right++;
            else wrong++;
        }
        try {
            repository.save(userId,topicId,right,questions.size(),right,wrong,skip);
            return new int[]{right,wrong,skip};
        } catch (SQLException e) {
            throw new QuizException("Could not save quiz attempt.", e);
        }
    }
}

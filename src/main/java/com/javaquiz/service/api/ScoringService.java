package com.javaquiz.service.api;

import com.javaquiz.exception.QuizException;
import com.javaquiz.model.Question;
import java.util.List;
import java.util.Map;

/** Contract for scoring and persisting a quiz attempt. */
public interface ScoringService {
    int[] score(int userId, Integer topicId, List<Question> questions,
                Map<Integer, Integer> answers) throws QuizException;
}

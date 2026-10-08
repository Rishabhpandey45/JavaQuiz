package com.javaquiz.dao.api;

import com.javaquiz.model.Question;
import java.sql.SQLException;
import java.util.List;

/** Contract for question retrieval operations. */
public interface QuestionRepository {
    List<Question> findByTopic(int topicId) throws SQLException;
    List<Question> findMixed(int limit) throws SQLException;
}

package com.javaquiz.dao.api;

import java.sql.SQLException;

/** Contract for saving completed quiz attempts. */
public interface AttemptRepository {
    void save(int userId, Integer topicId, int score, int total,
              int correct, int wrong, int skipped) throws SQLException;
}

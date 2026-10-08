package com.javaquiz.dao.api;

import com.javaquiz.model.User;
import java.sql.SQLException;

/** Contract for user persistence operations. */
public interface UserRepository {
    User create(User user) throws SQLException;
}

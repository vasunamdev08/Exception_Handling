package assignment.q9;

import java.sql.SQLException;

class UserRepository {
    public String getUserById(int id) throws SQLException {
        // Simulate a database failure
        throw new SQLException("Database connection failed");
    }
}

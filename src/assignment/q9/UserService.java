package assignment.q9;

import java.sql.SQLException;

class UserService {
    private UserRepository userRepository = new UserRepository();

    public String fetchUser(int id) throws ServiceLayerException {
        try {
            return userRepository.getUserById(id);
        } catch (SQLException e) {
            throw new ServiceLayerException("Failed to fetch user from repository", e);
        }
    }
}
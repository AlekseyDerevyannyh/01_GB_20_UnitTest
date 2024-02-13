package seminars.third.hw;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> authenticatedUsers;

    public UserRepository() {
        this.authenticatedUsers = new ArrayList<>();
    }

    public boolean addUser(User user, String login, String password) {
        if (user.authentication(login, password)) {
            authenticatedUsers.add(user);
            return true;
        }
        return false;
    }

    public List<User> getAuthenticatedUsers() {
        return authenticatedUsers;
    }

    public void logoutAllExceptAdmins() {
        authenticatedUsers.removeIf(user -> !user.isAdmin());
    }
}

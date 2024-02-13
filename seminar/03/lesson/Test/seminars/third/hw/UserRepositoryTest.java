package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {
    UserRepository repository;
    User user;

    @BeforeEach
    void setUp() {
        repository = new UserRepository();
        user = new User("login", "password", false);
    }

    @ParameterizedTest
    @CsvSource({"login, password, true", "wrong_login, password, false",
        "login, wrong_password, false", "wrong_login, wrong_password, false"})
    void addUserCheckReturnValue(String login, String password, boolean expected) {
        assertThat(repository.addUser(user, login, password)).isEqualTo(expected);
    }

    @Test
    void addUserCheckAuthenticatedUsersIsNotEmpty() {
        repository.addUser(user, "login", "password");

        assertThat(repository.getAuthenticatedUsers()).isNotEmpty();
    }

    @Test
    void addWrongUserCheckAuthenticatedUsersIsEmpty() {
        repository.addUser(user, "login", "wrong_password");

        assertThat(repository.getAuthenticatedUsers()).isEmpty();
    }

    @Test
    void addUserCheckAuthenticatedUsersCount() {
        repository.addUser(user, "login", "password");

        assertThat(repository.getAuthenticatedUsers().size()).isEqualTo(1);
    }

    @Test
    void addWrongUserCheckAuthenticatedUsersCount() {
        repository.addUser(user, "login", "wrong_password");

        assertThat(repository.getAuthenticatedUsers().size()).isEqualTo(0);
    }

    @Test
    void CheckAddAndGetAuthenticatedUsers() {
        List<User> expectedUsers = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            expectedUsers.add(new User("login" + i, "password" + i, false));
        }
        for (User expectedUser : expectedUsers) {
            repository.addUser(expectedUser, expectedUser.getLogin(), expectedUser.getPassword());
        }

        List<User> actualUsers = repository.getAuthenticatedUsers();

        for (int i = 0; i < expectedUsers.size(); i ++) {
            assertThat(actualUsers.get(i).getLogin()).isEqualTo(expectedUsers.get(i).getLogin());
            assertThat(actualUsers.get(i).getPassword()).isEqualTo(expectedUsers.get(i).getPassword());
        }
    }

    @Test
    void logoutAllExceptAdminsCheckCount() {
        User userAdmin = new User("admin_login", "admin_password", true);
        repository.addUser(user, user.getLogin(), user.getPassword());
        repository.addUser(userAdmin, userAdmin.getLogin(), userAdmin.getPassword());

        repository.logoutAllExceptAdmins();

        assertThat(repository.getAuthenticatedUsers().size()).isEqualTo(1);
    }

    @Test
    void logoutAllExceptAdminCheckRemaining() {
        List<User> expectedAdmins = new ArrayList<>();
        for (int i = 0; i < 2; i ++) {
            expectedAdmins.add(new User("admin_login" + i, "admin_password" + i, true));
        }
        for (User user : expectedAdmins) {
            repository.addUser(user, user.getLogin(), user.getPassword());
        }
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 2; i ++) {
            users.add(new User("login" + i, "password" + i, false));
        }
        for (User user : users) {
            repository.addUser(user, user.getLogin(), user.getPassword());
        }

        repository.logoutAllExceptAdmins();
        List<User> actualUsers = repository.getAuthenticatedUsers();

        for (int i = 0; i < expectedAdmins.size(); i ++) {
            assertThat(actualUsers.get(i).getLogin()).isEqualTo(expectedAdmins.get(i).getLogin());
            assertThat(actualUsers.get(i).getPassword()).isEqualTo(expectedAdmins.get(i).getPassword());
        }
    }
}


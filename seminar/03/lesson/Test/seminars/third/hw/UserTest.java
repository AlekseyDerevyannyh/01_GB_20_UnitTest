package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User("login", "password", false);
    }

    @ParameterizedTest
    @CsvSource({"login, password, true", "wrong_login, password, false",
            "login, wrong_password, false", "wrong_login, wrong_password, false"})
    void authenticationTest(String login, String password, boolean expected) {
        assertThat(user.authentication(login, password)).isEqualTo(expected);
    }

    @Test
    void getLoginTest() {
        assertThat(user.getLogin()).isEqualTo("login");
    }

    @Test
    void getPasswordTest() {
        assertThat(user.getPassword()).isEqualTo("password");
    }

    @Test
    void isAdminTest() {
        assertThat(user.isAdmin()).isFalse();
    }
}

package seminars.five.user.integration;

import org.junit.jupiter.api.Test;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationUserTest {

    @Test
    void integrationUserTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String result = userService.getUserName(1);

        assertEquals("User 1", result);
    }

}

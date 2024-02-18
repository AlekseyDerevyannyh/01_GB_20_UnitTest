package seminars.five.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberModuleTest {

    @Test
    void generateNumbersTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        assertThat(randomNumberModule.generateNumbers(10)).hasSize(10);
    }

}
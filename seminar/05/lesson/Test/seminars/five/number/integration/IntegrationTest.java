package seminars.five.number.integration;

import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    @Test
    void integrationTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> numbers = randomNumberModule.generateNumbers(10);
        Integer max = maxNumberModule.maxNumber(numbers);

        assertThat(max).isEqualTo(Collections.max(numbers));
    }
}

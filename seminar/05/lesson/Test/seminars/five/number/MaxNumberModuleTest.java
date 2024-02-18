package seminars.five.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MaxNumberModuleTest {

    @Test
    void maxNumberTest() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        List<Integer> inputNumbers = List.of(2, 10, 5, -2, 3);

        assertThat(maxNumberModule.maxNumber(inputNumbers)).isEqualTo(10);
    }
}
package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class MainHWTest {
    MainHW testClass;

    @BeforeEach
    void setUp() {
        testClass = new MainHW();
    }

    @ParameterizedTest
    @CsvSource({"1, false", "2, true"})
    void evenOddNumberTest(int number, boolean expected) {
        assertThat(testClass.evenOddNumber(number)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"25, false", "26, true", "99, true", "100, false"})
    void numberInIntervalTest(int number, boolean expected) {
        assertThat(testClass.numberInInterval(number)).isEqualTo(expected);
    }
}

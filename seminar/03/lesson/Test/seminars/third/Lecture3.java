package seminars.third;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture3 {
    // Попробуйте реализовать в калькуляторе
    // с помощью методологии TDD (с описанием шагов)
    // функцию расчёта длины окружности

    @Test
    void circleLengthTest() {
        Circle circle = new Circle();
        Double expected = 62.83185307179586;

        Double actual = circle.calculateLength(10);

        assertThat(actual).isEqualTo(expected);
    }
}

package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService someService;

    @BeforeEach
    void setUp () {
        someService = new SomeService();
    }

   // 3.1.
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        String actual = someService.fizzBuzz(6);

        assertThat(actual).isEqualTo("Fizz");
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        String actual = someService.fizzBuzz(10);

        assertThat(actual).isEqualTo("Buzz");
    }

    @Test
    void multipleFifteenReturnsFizzBuzz() {
        String actual = someService.fizzBuzz(30);

        assertThat(actual).isEqualTo("FizzBuzz");
    }

    @Test
    void multipleReturnsStringNum() {
        String actual = someService.fizzBuzz(31);

        assertThat(actual).isEqualTo("31");
    }

    // 3.2.
    @Test
    void lastNumberIs6ReturnTrue() {
        int[] actual = new int[]{1, 3, 5, 6};

        assertTrue(someService.firstLast6(actual));
    }

    @Test
    void lastNumberNot6ReturnFalse() {
        int[] actual = new int[]{1, 3, 5, 3};

        assertFalse(someService.firstLast6(actual));
    }

    @Test
    void firstNumberIs6ReturnTrue() {
        int[] actual = new int[]{6, 3, 5, 1};

        assertTrue(someService.firstLast6(actual));
    }

    @Test
    void firstNumberNot6ReturnFalse() {
        int[] actual = new int[]{3, 3, 5, 1};

        assertFalse(someService.firstLast6(actual));
    }

    // 3.3.
    @ParameterizedTest
    @CsvSource({"2000.0, 50, 1000", "2000.0, 100, 0", "2000.0, 0, 2000"})
    void calculatingDiscountNormalTest(Double purchaseAmount, int discountAmount, int result) {
        assertThat(someService.calculatingDiscount(purchaseAmount, discountAmount))
                .isEqualTo(result); // обычная скидка
    }

    @ParameterizedTest
    @CsvSource({"2000.0, 101", "2000.0, -10"})
    void calculatingDiscountInvalidDiscount(Double purchaseAmount, int discountAmount) {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(purchaseAmount, discountAmount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    // 3.4.
    @Test
    void luckySumTestSum() {
        assertEquals(6, someService.luckySum(1, 2, 3));
    }

    @Test
    void luckySumTestSumWithFirst13() {
        assertEquals(5, someService.luckySum(13, 2, 3));
    }

    @Test
    void luckySumTestSumWithSecond13() {
        assertEquals(6, someService.luckySum(3, 13, 3));
    }

    @Test
    void luckySumTestSumWithThird13() {
        assertEquals(3, someService.luckySum(1, 2, 13));
    }
}
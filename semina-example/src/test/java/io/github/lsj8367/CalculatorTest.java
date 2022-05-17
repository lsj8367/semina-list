package io.github.lsj8367;

import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("생성 테스트")
    void initTest() {
        //given
        int number1 = 1;
        int number2 = 1;

        //when
        Calculator actual = new Calculator(number1, number2);

        //then
        Assertions.assertThat(actual).isEqualTo(new Calculator(1, 1));
    }

    @Test
    @DisplayName("생성중 앞 인자 음수일 때 에러 테스트")
    void initExceptionTest() {
        //given
        int number1 = -1;
        int number2 = 1;

        //when
        final AbstractThrowableAssert<?, ? extends Throwable> testingMethod = Assertions.assertThatThrownBy(() -> new Calculator(number1, number2));

        //then
        testingMethod
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("첫 숫자는 음수를 넣을 수 없습니다.");
    }

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        //given
        int number1 = 5;
        int number2 = 5;
        Calculator calculator = new Calculator(number1, number2);
        int expected = 10;

        //when
        final int actual = calculator.add();

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusTest() {
        //given
        int number1 = 5;
        int number2 = 5;
        Calculator calculator = new Calculator(number1, number2);
        int expected = 0;

        //when
        final int actual = calculator.minus();

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}

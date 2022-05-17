package io.github.lsj8367;

import java.util.Objects;

public class Calculator {

    private final int number1;
    private final int number2;

    public Calculator(final int number1, final int number2) {
        minusNumberValidation(number1);
        this.number1 = number1;
        this.number2 = number2;
    }

    private void minusNumberValidation(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("첫 숫자는 음수를 넣을 수 없습니다.");
        }
    }

    public int add() {
        return number1 + number2;
    }

    public int minus() {
        return number1 - number2;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Calculator that = (Calculator) o;
        return number1 == that.number1 && number2 == that.number2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number1, number2);
    }

}

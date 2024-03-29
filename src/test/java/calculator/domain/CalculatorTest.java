package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void 컴마가_구분자인_식의_결과를_제대로_나타내는지() {
        calculator = new Calculator("1,2,3");
        assertThat(calculator.plusAllNumbers()).isEqualTo(6);

        calculator = new Calculator("//,\n1,2,3");
        assertThat(calculator.plusAllNumbers()).isEqualTo(6);

        calculator = new Calculator("0");
        assertThat(calculator.plusAllNumbers()).isEqualTo(0);

        calculator = new Calculator("1");
        assertThat(calculator.plusAllNumbers()).isEqualTo(1);
    }

    @Test
    public void 콜론이_구분자인_식의_결과를_제대로_나타내는지() {
        calculator = new Calculator("1:2:3");
        assertThat(calculator.plusAllNumbers()).isEqualTo(6);

        calculator = new Calculator("//:\n1:2:3");
        assertThat(calculator.plusAllNumbers()).isEqualTo(6);
    }

    @Test
    public void 커스텀_구분자가_포함된_식의_결과를_제대로_나타내는지() {
        calculator = new Calculator("//;\n1;2;3");
        assertThat(calculator.plusAllNumbers()).isEqualTo(6);
    }

    @Test
    public void 주어진_식이_null_공백일때_0을_출력하는지() {
        calculator = new Calculator(null);
        assertThat(calculator.plusAllNumbers()).isEqualTo(0);

        calculator = new Calculator("  ");
        assertThat(calculator.plusAllNumbers()).isEqualTo(0);

    }

    @Test
    public void 주어진_식에서_음수나_문자가_포함되어있을떄_예외를_발생시키는지_확인() {
        assertThrows(RuntimeException.class, () -> {
            new Calculator("-1:2,3").plusAllNumbers();
            new Calculator("a:2,3").plusAllNumbers();
        });
    }
}

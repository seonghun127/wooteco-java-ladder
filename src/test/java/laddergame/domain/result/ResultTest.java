package laddergame.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultTest {
    Result result;

    @BeforeEach
    public void setUp() {
        result = new Result("꽝");
    }

    @Test
    public void 객체_생성_검사() {
        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @Test
    public void 문자길이가_5자리_이상으로_생성했을때_예외발생하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Result("500000");
        });
    }

}
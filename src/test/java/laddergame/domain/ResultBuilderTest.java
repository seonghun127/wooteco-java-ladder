package laddergame.domain;

import laddergame.domain.result.ResultBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultBuilderTest {
    @Test
    public void 객제_생성_검사() {
        ResultBuilder playerMaker = new ResultBuilder("pobi,crong");
        assertThat(playerMaker).isEqualTo(new ResultBuilder("pobi,crong"));
    }

    @Test
    public void 공백이_입력되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder(" ").makeResults();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder("").makeResults();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder(null).makeResults();
        });
    }

    @Test
    public void 이름목록에_스페이스가_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder(" ,pobi,honux,crong,jk").makeResults();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder("pobi,honux,crong,jk, ").makeResults();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder("pobi,honux, ,crong,jk").makeResults();
        });
    }

    @Test
    public void 이름목록에_공백이_포함되어있을때_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder(",pobi,honux,crong,jk").makeResults();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder("pobi,honux,crong,jk,").makeResults();
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultBuilder("pobi,honux,,crong,jk,").makeResults();
        });
    }
}
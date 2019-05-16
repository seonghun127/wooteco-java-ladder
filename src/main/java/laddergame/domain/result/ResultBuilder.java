package laddergame.domain.result;

import laddergame.domain.Constant;
import laddergame.domain.inputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultBuilder {
    private String result;

    public ResultBuilder(String result) {
        this.result = result;
    }

    public Results makeResults() {
        inputValidator.validateInput(result);

        List<Result> results =  Arrays.asList(result.split(Constant.COMMA)).stream()
                .map(Result::new)
                .collect(Collectors.toList());

        return new Results(results);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultBuilder)) return false;
        ResultBuilder that = (ResultBuilder) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}

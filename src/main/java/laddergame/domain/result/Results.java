package laddergame.domain.result;

import java.util.List;
import java.util.Objects;

public class Results {
    private final static String BLANK = " ";

    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public boolean isEqualToPlayersCount(int playerCount) {
        return (playerCount != results.size());
    }

    public Result getResult(int index) {
        return this.results.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Results)) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("%-3s", BLANK));
        for (Result result : results) {
            stringBuilder.append(String.format("%-6s", result));
        }
        return stringBuilder.toString();
    }
}
package lsn.recruitment.task2.output;

import lsn.recruitment.task2.domain.Result;

import java.util.Objects;

public class StdOutResultPrinter implements ResultPrinter {

    private static final String SPACE = " ";

    public void print(Result result) {
        if (Objects.isNull(result.getPairs())) {
            throw new IllegalArgumentException("Invalid result: missing pairs of numbers");
        }
        result.sortedPairs().forEach(pair -> System.out.println(pair.getLower() + SPACE + pair.getGreater()));
    }
}

package lsn.recruitment.task1.output;

import lsn.recruitment.task1.domain.Result;

import java.util.Objects;
import java.util.stream.Collectors;

public class StdOutResultPrinter implements ResultPrinter {

    private static final String SPACE = " ";

    public void print(Result result) {
        if (Objects.isNull(result.getSortedNumbers())) {
            throw new IllegalArgumentException("Invalid result: missing collections of sorted number");
        }
        String sortedNumbers = result.getSortedNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SPACE));
        System.out.println(sortedNumbers);
        System.out.println("count: " + result.getCount());
        System.out.println("distinct: " + result.getDistinct());
        System.out.println("min: " + result.getMin());
        System.out.println("max: " + result.getMax());
    }
}

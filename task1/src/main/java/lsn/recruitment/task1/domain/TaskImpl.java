package lsn.recruitment.task1.domain;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class TaskImpl implements Task {

    public Result execute(Collection<Integer> numbers) {
        if (Objects.isNull(numbers) || numbers.isEmpty()) {
            throw new IllegalArgumentException("Invalid list of numbers: numbers list can not be null or empty");
        }
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        long distinct = sortedNumbers.stream()
                .distinct()
                .count();
        int min = sortedNumbers.stream()
                .min(Integer::compareTo)
                .orElseThrow();
        int max = sortedNumbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        return Result.builder()
                .sortedNumbers(sortedNumbers)
                .count(sortedNumbers.size())
                .distinct(distinct)
                .min(min)
                .max(max)
                .build();
    }
}

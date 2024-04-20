package lsn.recruitment.task2.domain;

import lsn.recruitment.task2.domain.Result.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskImpl implements Task {

    public Result execute(List<Integer> numbers) {
        if (Objects.isNull(numbers) || numbers.size() < 2) {
            throw new IllegalArgumentException("Invalid list of numbers: numbers list can not be null and have " +
                    "to contains at least 2 numbers");
        }
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int firstNumber = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                int secondNumber = numbers.get(j);
                if (firstNumber + secondNumber == 13) {
                    pairs.add(new Pair(firstNumber, secondNumber));
                }
            }
        }
        return new Result(pairs);
    }
}

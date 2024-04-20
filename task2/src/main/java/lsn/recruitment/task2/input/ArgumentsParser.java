package lsn.recruitment.task2.input;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArgumentsParser {

    public List<Integer> parse(String[] args) {
        if (Objects.isNull(args) || args.length < 1) {
            throw new IllegalArgumentException("List of numbers not provided.");
        }
        if (args.length < 2) {
            throw new IllegalArgumentException("Too little arguments, program requires at lest 2 numbers");
        }
        return Arrays.stream(args)
                .mapToInt(this::parseToInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private Integer parseToInt(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format("Invalid integer provided: %s", arg));
        }
    }
}

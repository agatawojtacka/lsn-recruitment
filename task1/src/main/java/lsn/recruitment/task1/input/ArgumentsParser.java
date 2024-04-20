package lsn.recruitment.task1.input;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArgumentsParser {

    public List<Integer> parse(String[] args) {
        if (Objects.isNull(args) || args.length == 0) {
            throw new IllegalArgumentException("List of numbers not provided.");
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

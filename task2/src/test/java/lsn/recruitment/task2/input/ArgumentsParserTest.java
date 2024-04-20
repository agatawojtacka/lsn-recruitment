package lsn.recruitment.task2.input;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ArgumentsParserTest {


    @Test
    public void shouldParseArguments() {
        // given
        ArgumentsParser parser = new ArgumentsParser();
        String[] numbers = new String[] { "20", "1", "3", "5" };

        // when
        List<Integer> parsedArguments = parser.parse(numbers);

        // then
        assertThat(parsedArguments).containsExactlyInAnyOrder(
                20, 1, 3, 5
        );
    }

    @Test
    public void shouldThrowExceptionWhenArgumentsMissing() {
        // given
        ArgumentsParser parser = new ArgumentsParser();
        String[] numbers = null;

        // when && then
        assertThatCode(() -> parser.parse(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("List of numbers not provided.");
    }

    @Test
    public void shouldThrowExceptionWhenArgumentNotInteger() {
        // given
        ArgumentsParser parser = new ArgumentsParser();
        String[] numbers = new String[] { "20", "1", "3", "G" };

        // when && then
        assertThatCode(() -> parser.parse(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid integer provided: G");
    }

    @Test
    public void shouldThrowExceptionWhenToLittleArgumentsProvided() {
        // given
        ArgumentsParser parser = new ArgumentsParser();
        String[] numbers = new String[] { "20" };

        // when && then
        assertThatCode(() -> parser.parse(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Too little arguments, program requires at lest 2 numbers");
    }
}
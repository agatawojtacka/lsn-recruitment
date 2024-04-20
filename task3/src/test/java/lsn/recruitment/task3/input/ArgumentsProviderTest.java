package lsn.recruitment.task3.input;


import lsn.recruitment.task3.domain.Pair;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ArgumentsProviderTest {

    @Test
    public void shouldProvideArgumentsFromConsole() {
        // given
        ArgumentsProvider argumentsProvider = new ArgumentsProvider();
        String inputData = """
                3
                4 3
                1 4
                5 6
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        // when
        List<Pair> pairs = argumentsProvider.provide();

        // then
        assertThat(pairs).containsExactly(
                new Pair(4, 3),
                new Pair(1, 4),
                new Pair(5, 6)
        );
    }

    @Test
    public void shouldThrowException() {
        // given
        ArgumentsProvider argumentsProvider = new ArgumentsProvider();
        String inputData = """
                3
                a
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        // when && then
        assertThatCode(argumentsProvider::provide)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid arguments provided. All arguments have to be positive integers and fulfill " +
                        "requirements about input format: \nn - positive integer \nn couples positive integer");
    }
}
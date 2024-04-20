package lsn.recruitment.task2.output;

import lsn.recruitment.task2.domain.Result;
import lsn.recruitment.task2.domain.Result.Pair;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class StdOutResultPrinterTest {

    @Test
    public void shouldCorrectlyPrintResult() {
        // given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        StdOutResultPrinter printer = new StdOutResultPrinter();
        Result result = new Result(
                List.of(
                        new Pair(6, 7),
                        new Pair(0, 13),
                        new Pair(6, 7),
                        new Pair(3, 10)
                )
        );

        // when
        printer.print(result);

        // then
        assertThat(outputStreamCaptor.toString()).isEqualTo(
                "0 13\n" +
                        "3 10\n" +
                        "6 7\n" +
                        "6 7\n"
        );
    }

    @Test
    public void shouldThrowException() {
        // given
        StdOutResultPrinter printer = new StdOutResultPrinter();
        Result result = new Result(null);

        // when && then
        assertThatCode(() -> printer.print(result))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid result: missing pairs of numbers");
    }
}
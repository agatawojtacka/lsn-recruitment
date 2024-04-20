package lsn.recruitment.task1.output;

import lsn.recruitment.task1.domain.Result;
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
        Result result = Result.builder()
                .sortedNumbers(List.of(1, 10, 20, 20, 2, 5))
                .count(6)
                .distinct(5)
                .min(1)
                .max(20)
                .build();

        // when
        printer.print(result);

        // then
        assertThat(outputStreamCaptor.toString()).isEqualTo(
                "1 10 20 20 2 5\n" +
                        "count: 6\n" +
                        "distinct: 5\n" +
                        "min: 1\n" +
                        "max: 20\n"
        );
    }

    @Test
    public void shouldThrowException() {
        // given
        StdOutResultPrinter printer = new StdOutResultPrinter();
        Result result = Result.builder().build();

        // when && then
        assertThatCode(() -> printer.print(result))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid result: missing collections of sorted number");
    }
}
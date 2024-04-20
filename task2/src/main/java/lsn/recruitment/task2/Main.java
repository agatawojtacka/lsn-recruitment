package lsn.recruitment.task2;

import lombok.RequiredArgsConstructor;
import lsn.recruitment.task2.domain.Result;
import lsn.recruitment.task2.domain.Task;
import lsn.recruitment.task2.domain.TaskImpl;
import lsn.recruitment.task2.input.ArgumentsParser;
import lsn.recruitment.task2.output.ResultPrinter;
import lsn.recruitment.task2.output.StdOutResultPrinter;

import java.util.List;

@RequiredArgsConstructor
public class Main {
    private final ArgumentsParser argumentsParser;
    private final Task task;
    private final ResultPrinter resultPrinter;

    public static void main(String[] args) {
        Main main = new Main(new ArgumentsParser(), new TaskImpl(), new StdOutResultPrinter());
        try {
            main.run(args);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            System.err.println("Program exited.");
            System.exit(-1);
        }
    }

    private void run(String[] args) {
        List<Integer> numbers = argumentsParser.parse(args);
        Result result = task.execute(numbers);
        resultPrinter.print(result);
    }
}
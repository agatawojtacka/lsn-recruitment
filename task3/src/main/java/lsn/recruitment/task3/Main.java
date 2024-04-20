package lsn.recruitment.task3;

import lombok.RequiredArgsConstructor;
import lsn.recruitment.task3.domain.Pair;
import lsn.recruitment.task3.domain.Task;
import lsn.recruitment.task3.domain.TaskImpl;
import lsn.recruitment.task3.input.ArgumentsProvider;

import java.util.List;

@RequiredArgsConstructor
public class Main {

    private final Task task;
    private final ArgumentsProvider argumentsProvider;

    public static void main(String[] args) {
        try {
            new Main(new TaskImpl(), new ArgumentsProvider()).run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Program exited.");
            System.exit(-1);
        }
    }

    private void run() {
        List<Pair> pairs = argumentsProvider.provide();
        int numberOfGraphs = task.execute(pairs);
        System.out.println(numberOfGraphs);
    }
}
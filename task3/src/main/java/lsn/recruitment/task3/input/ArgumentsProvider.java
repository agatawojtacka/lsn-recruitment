package lsn.recruitment.task3.input;

import lsn.recruitment.task3.domain.Pair;

import java.util.*;

public class ArgumentsProvider {

    public List<Pair> provide() {
        try(Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                pairs.add(new Pair(first, second));
            }
            return pairs;
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Invalid arguments provided. All arguments have to be positive integers and fulfill " +
                            "requirements about input format: \nn - positive integer \nn couples positive integer");
        }
    }
}

package lsn.recruitment.task2.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Result {

    private final List<Pair> pairs;

    public List<Pair> sortedPairs() {
        List<Pair> copy = new ArrayList<>(pairs);
        Collections.sort(copy);
        return copy;
    }

    @Data
    public static class Pair implements Comparable<Pair> {
        private final int lower;
        private final int greater;

        public Pair(int first, int second) {
            if (first <= second) {
                this.lower = first;
                this.greater = second;
            } else {
                this.lower = second;
                this.greater = first;
            }
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(lower, pair.getLower());
        }
    }
}



package lsn.recruitment.task2.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    public void shouldReturnSortedPairs() {
        // given
        Result result = new Result(
                List.of(
                        new Result.Pair(6, 7),
                        new Result.Pair(0, 13),
                        new Result.Pair(6, 7),
                        new Result.Pair(3, 10)
                )
        );

        // when
        List<Result.Pair> sortedPairs = result.sortedPairs();

        // then
        assertThat(sortedPairs).containsExactly(
                new Result.Pair(0, 13),
                new Result.Pair(3, 10),
                new Result.Pair(6, 7),
                new Result.Pair(6, 7)
        );
    }

}
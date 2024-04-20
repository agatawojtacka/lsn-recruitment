package lsn.recruitment.task3.domain;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class TaskImplTest {

    @Test
    public void shouldFindNumberOfGraphs() {
        // given
        TaskImpl task = new TaskImpl();
        List<Pair> pairs = List.of(
                new Pair(4, 3),
                new Pair(1, 4),
                new Pair(5, 6)
        );

        // when
        int numberOfGraphs = task.execute(pairs);

        // then
        assertThat(numberOfGraphs).isEqualTo(2);
    }

    @Test
    public void shouldThrowException() {
        // given
        TaskImpl task = new TaskImpl();
        List<Pair> pairs = null;

        // when && then
        assertThatCode(() -> task.execute(pairs))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid input data: null");
    }
}
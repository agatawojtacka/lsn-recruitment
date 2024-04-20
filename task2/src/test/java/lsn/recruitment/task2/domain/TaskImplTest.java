package lsn.recruitment.task2.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class TaskImplTest {

    @Test
    public void shouldExecuteTask() {
        // given
        TaskImpl task = new TaskImpl();
        List<Integer> numbers = List.of(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);

        // when
        Result result = task.execute(numbers);

        // then
        assertThat(result.getPairs()).containsExactlyInAnyOrder(
                new Result.Pair(0, 13),
                new Result.Pair(3, 10),
                new Result.Pair(6, 7),
                new Result.Pair(6, 7)
        );
    }

    @Test
    public void shouldThrowException() {
        // given
        TaskImpl task = new TaskImpl();
        List<Integer> numbers = List.of(1);

        // when && then
        assertThatCode(() -> task.execute(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid list of numbers: numbers list can not be null and have to contains at least 2 numbers");
    }
}
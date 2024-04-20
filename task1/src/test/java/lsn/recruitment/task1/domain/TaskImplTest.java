package lsn.recruitment.task1.domain;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


public class TaskImplTest {

    @Test
    public void shouldExecuteTask() {
        // given
        TaskImpl task = new TaskImpl();
        List<Integer> numbers = List.of(1, 10, 20, 20, 2, 5);

        // when
        Result result = task.execute(numbers);

        // then
        assertThat(result.getSortedNumbers()).contains(1, 2, 5, 10, 20);
        assertThat(result.getCount()).isEqualTo(6);
        assertThat(result.getDistinct()).isEqualTo(5);
        assertThat(result.getMin()).isEqualTo(1);
        assertThat(result.getMax()).isEqualTo(20);
    }

    @Test
    public void shouldThrowException() {
        // given
        TaskImpl task = new TaskImpl();
        List<Integer> numbers = List.of();

        // when && then
        assertThatCode(() -> task.execute(numbers))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid list of numbers: numbers list can not be null or empty");
    }
}
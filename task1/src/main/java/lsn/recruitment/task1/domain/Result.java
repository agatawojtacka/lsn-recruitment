package lsn.recruitment.task1.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Result {

    private final List<Integer> sortedNumbers;
    private final long count;
    private final long distinct;
    private final int min;
    private final int max;
}

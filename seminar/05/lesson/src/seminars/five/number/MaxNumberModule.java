package seminars.five.number;

import java.util.Comparator;
import java.util.List;

public class MaxNumberModule {

    public Integer maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

}

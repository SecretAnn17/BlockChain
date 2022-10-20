import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> listStream = stream.sorted(order).collect(Collectors.toList());
        T max = listStream.isEmpty()?null:listStream.get(listStream.size()-1);
        T min = listStream.isEmpty()?null:listStream.get(0);
        minMaxConsumer.accept(min, max);
    }
}
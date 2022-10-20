// You can experiment here, it won’t be checked

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

  public static <T> void findMinMax(
          Stream<? extends T> stream,
          Comparator<? super T> order,
          BiConsumer<? super T, ? super T> minMaxConsumer) {

    Optional optionalStream = Optional.ofNullable(stream);
    if(optionalStream.isEmpty()) {
      minMaxConsumer.accept(null, null);
    } else {
      List<T> list = stream.sorted(order).collect(Collectors.toList());
      minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }
  }

}

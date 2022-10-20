// You can experiment here, it won’t be checked

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    int n = 5;
    Stream.iterate(1, i -> i * 2)
            .limit(n)
            .forEach(System.out::println);
  }
}

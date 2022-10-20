// You can experiment here, it won’t be checked

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    Stream.iterate(1, i -> i + 2)
            .skip(5)
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
    // put your code here
  }
}

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /**
     * Returns the sorted array of absolute numbers in ascending order.
     *
     * @param numbers the input array of String integer numbers
     * @return the sorted array of integer absolute numbers
     */
    public static int[] sortedAbsNumbers(String[] numbers) {
        return Arrays.stream(numbers).map(x->Integer.valueOf(x)).map(Math::abs).sorted().mapToInt(x->x).toArray();
    }

    // Don't change the code below
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(sortedAbsNumbers(scanner.nextLine().split("\\s+")))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );*/

        List<Integer> numbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        System.out.println(numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(x -> x)
                .sum());
    }
}
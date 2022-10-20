// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

class ArrayUtils {
    public static <T> boolean hasNull(T[] array){
        return IntStream.range(0, array.length).anyMatch(i -> array[i] == null);
    }
}
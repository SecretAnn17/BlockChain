// do not remove imports
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

class ArrayUtils {
    public static <T> T[] invert(T[] array){
        T buble;
        for(int i = 0; i < array.length/2; i++) {
            buble = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = buble;
        }
        return array;

    }
}
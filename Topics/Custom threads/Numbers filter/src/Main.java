import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        int value;
        while (scanner.hasNext()) {
            value = scanner.nextInt();
            if(value == 0) {
                break;
            }else if (value % 2 == 0) {
                System.out.println(value);
            }
            // implement this method
        }
    }
}
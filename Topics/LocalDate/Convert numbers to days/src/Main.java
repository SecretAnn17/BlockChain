import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer year = sc.nextInt();
        List<Integer> list = Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt());
        list.stream().forEach(date -> {
            System.out.println(LocalDate.ofYearDay(year, date));
        });
    }
}
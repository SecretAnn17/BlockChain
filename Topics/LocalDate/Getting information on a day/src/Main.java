import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date = sc.next();


        LocalDate theDay = LocalDate.parse(date);
        System.out.println(theDay.getDayOfYear() + " " + theDay.getDayOfMonth());
    }
}
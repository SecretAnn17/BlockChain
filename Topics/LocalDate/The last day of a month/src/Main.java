// You can experiment here, it won’t be checked

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer year = sc.nextInt();
        Integer dayOfAYear = sc.nextInt();

        Boolean isLastDay = false;
        LocalDate theDay = LocalDate.ofYearDay(year, dayOfAYear);
        if(theDay.getDayOfMonth()==theDay.lengthOfMonth()){
            isLastDay = true;
        }
        System.out.println(isLastDay);
        // put your code here
    }
}

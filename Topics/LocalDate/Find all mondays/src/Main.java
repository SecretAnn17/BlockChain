import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer year = sc.nextInt();
        Integer numberOfMonth = sc.nextInt();

        Boolean isLastDay = false;
        LocalDate theDay = LocalDate.of(year, numberOfMonth, 1);
        //System.out.println(theDay.getDayOfWeek());

        for(int i = 1; i < theDay.lengthOfMonth(); i++){
            if(theDay.plusDays(i).getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                System.out.println(theDay.plusDays(i));
            }
        }
    }
}
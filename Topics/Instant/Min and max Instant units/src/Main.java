import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.time.Instant;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
       // List<Instant> instantList = createInstantList(scanner);

        //long result = getMaxMinusMin(instantList);

        System.out.println('\n'+"wxqdssze3wer8yt");
        System.out.println("4 + 7 = " + (4+7));
    }  

    public static List<Instant> createInstantList(Scanner scanner) {
        List<Instant> instantList = new ArrayList<>();
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));

        return instantList;
    }

    private static long getMaxMinusMin(List<Instant> instantList) {
        TreeSet<Instant> sortedInstantList = new TreeSet<>(instantList.stream().collect(Collectors.toSet()));
        Instant instant  = Instant.EPOCH;
        instant.minus(Period.ofDays(1));

       // System.out.println(instant.minus(Duration.ofDays(32)).atZone(ZoneId.of("GMT+6")));
        return sortedInstantList.last().minusSeconds(sortedInstantList.first().getEpochSecond()).getEpochSecond();
    }
}


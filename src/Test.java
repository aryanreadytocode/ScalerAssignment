import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = List.of(10,0,15,5,20);
//        System.out.println(l);
//        int minValue = l.stream().min((i1, i2) -> i1.compareTo(i2)).get();
//        int maxValue = l.stream().min((i1, i2) -> -i1.compareTo(i2)).get();
//        System.out.println(minValue);
//        System.out.println(maxValue);
//        Consumer<Integer> s = i -> System.out.println("value"+i);
//        l.forEach( integer -> System.out.println("Square is "+integer*integer));
//        Integer[] arr = l.stream().toArray(Integer[]::new);
//        Arrays.stream(arr).forEach(integer -> System.out.println("I"+integer));
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();

//        System.out.println(localDate.getDayOfMonth());
//        System.out.println(localDate.getYear());
//        System.out.println(localDate.getMonthValue());
//        System.out.println(localTime);
//
//        System.out.printf("%d:%d:%d",localTime.getHour(), localTime.getMinute(), localTime.getSecond());
//
//        System.out.printf("%d-%d-%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getDayOfYear());

//        LocalDateTime dt = LocalDateTime.of(1994, Month.MAY, 13, 12,24);
//        System.out.println(dt);
//        System.out.println(dt.plusMonths(6));
//        System.out.println(dt.minusMonths(6));

//        LocalDate birthday = LocalDate.of(1993, Month.OCTOBER, 13);
//        LocalDate today = LocalDate.now();
//
//        Period p = Period.between(birthday, today);
//        System.out.println(p.getYears()+" "+ p.getMonths()+" "+p.getDays());

        /*while (true) {
            System.out.println("enter year:");
            Scanner sc = new Scanner(System.in);
            int year = sc.nextInt();
            Year y = Year.of(year);
            if (y.isLeap())
                System.out.printf("%d is leap year", year);
            else
                System.out.printf("%d is not leap year", year);
        }*/
        ZoneId id = ZoneId.systemDefault();
        System.out.println(id);

        ZoneId la = ZoneId.of("America/Los_Angeles");
        ZonedDateTime dt = ZonedDateTime.now(la);
        System.out.println(dt);


    }
}

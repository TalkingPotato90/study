package day0122;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * 날짜 정보 변경
 */
public class TimePackage3 {
    public TimePackage3() {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.now();
        LocalDateTime ldt3 = LocalDateTime.now();

//        ldt.withYear(2030); // method를 ㅎ출한 것으로는 변경되지 않는다
        ldt=ldt.withYear(2030);
        ldt = ldt.withMonth(5);
        ldt = ldt.withDayOfMonth(30);

        ldt2 = ldt2.plusYears(6);
        ldt2 = ldt2.plusMonths(4);
        ldt2 = ldt2.plusDays(8);

        ldt3 = ldt3.minusYears(1);
        ldt3 = ldt3.minusMonths(1);
        ldt3 = ldt3.minusDays(21);

        System.out.println(ldt);
        System.out.println(ldt2);
        System.out.println(ldt3);

        ldt = LocalDateTime.now(); // 2024-01-22
        ldt2 = LocalDateTime.of(2024,1,23,0,0);

        System.out.println(ldt.isAfter(ldt2)); // 이후 일자인지?
        System.out.println(ldt.isBefore(ldt2)); // 이전 일자인지?
        System.out.println(ldt.isEqual(ldt2)); // 같은 일자인지?

        System.out.println(ldt);
        System.out.println(ldt2);

        System.out.println("-------------------------------------------");
        // 두 날짜간의 차이 구하기
        LocalDate ld = LocalDate.of(2022,1,1);
        LocalDate ld2 = LocalDate.now(); // 2023-1-22

        // 차이를 구하는 객체 얻기
        Period p = Period.between(ld, ld2);
        System.out.println(ld.getYear()+"년과 "+ld2.getYear()+"년의 차 "+p.getYears()+"년");
        System.out.println(ld.getMonthValue()+"월과 "+ld2.getMonthValue()+"월의 차 "+p.getMonths()+"개월");
        System.out.println(ld.getDayOfMonth()+"일과 "+ld2.getDayOfMonth()+"일의 차 "+p.getDays()+"일");

    }

    public static void main(String[] args) {
        new TimePackage3();
    }
}

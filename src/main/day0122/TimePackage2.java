package day0122;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Spliterator;

public class TimePackage2 {
    public void useDate() {
        LocalDate ld = LocalDate.now();
        System.out.println(ld.getYear() + "-" + ld.getMonth() + " " + ld.getMonthValue()
                + "-" + ld.getDayOfMonth() + "오늘이 이번 년도의 몇번째 날 " + ld.getDayOfYear()
                + " 요일 : " + ld.getDayOfWeek() + " 요일의 수 : " + ld.getDayOfWeek().getValue());
    }

    public void useTime() {
        LocalTime lt = LocalTime.now();
        System.out.println(lt.getHour() + " : " + lt.getMinute() + " : " + lt.getSecond() + " " + lt.getNano());
    }

    public void useDateTime() {
        // 1. 날짜 관련 클래스 생성
        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(ldt.getYear() + "-" + ldt.getMonthValue() + "-" + ldt.getDayOfMonth()
//                + " " + ldt.getHour() + " : " + ldt.getMinute() + " : " + ldt.getSecond()+" "+ldt.getDayOfWeek());
        // 2. formatter 클래스 생성
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a EEEE", Locale.KOREA);
        // 3. 날짜 관련 클래스의 format method 호출하여 formatter 할당
        String dateFormat = ldt.format(dtf);
        System.out.println(dateFormat);
    }

    public static void main(String[] args) {
        TimePackage2 tp2 = new TimePackage2();
        System.out.println("-------------LocalDate---------------");
        tp2.useDate();
        System.out.println("-------------LocalTime---------------");
        tp2.useTime();
        System.out.println("-------------LocalDateTime---------------");
        tp2.useDateTime();
    }
}

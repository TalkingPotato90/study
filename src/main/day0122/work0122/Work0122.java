package day0122.work0122;

import day0119.work0119.Work0119;

import java.time.LocalDate;
import java.util.Calendar;

public class Work0122 {
    public void januaryCalendar() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i <= lastDay; i++) {

            if (i == 1) {
                System.out.printf("%" + (3 * (dayOfWeek - 1)) + "s", "");
                System.out.printf("%2d ", i);
            }else {
                System.out.printf("%2d ", i);
            }

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        System.out.println();
    }

    public int[] monthlyCalendar(int year, int month) {
        LocalDate localDate = LocalDate.of(year, month, 1);
        int[] monthly = new int[localDate.lengthOfMonth() + 1];
        for (int i = 1; i < localDate.lengthOfMonth() + 1; i++) {
            monthly[i] = i;
//            System.out.print(monthly[i] + " ");
        }
        return monthly;
    }

    public static void main(String[] args) {
        Work0122 work0122 = new Work0122();
        work0122.januaryCalendar();
        work0122.monthlyCalendar(2024, 2);
    }

}

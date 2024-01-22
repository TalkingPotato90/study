package day0122.work0122;

import day0119.work0119.Work0119;

import java.util.Calendar;

public class Work0122 {
    public void januaryCalendar() {

        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 32; ) {
            for (int j = 0; j < 7; j++) {
                if (i == 32) {
                    break;
                } else if (i == 0) {
                    System.out.print("  ");
                    i++;
                } else {
                    calendar.set(Calendar.DAY_OF_MONTH, i);
                    System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + " ");
                    i++;
                }
            }
            System.out.println();
        }


    }

    public void monthlyCalendar() {

    }

    public static void main(String[] args) {
        Work0122 work0122 = new Work0122();
        work0122.januaryCalendar();
        work0122.monthlyCalendar();
    }

}

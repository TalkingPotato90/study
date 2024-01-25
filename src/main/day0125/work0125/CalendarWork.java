package day0125.work0125;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Calendar;

public class CalendarWork extends JFrame {


    public CalendarWork() {
        super("달력");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        LocalDate localDate = LocalDate.now();
        Font font = new Font("맑은고딕", Font.BOLD, 20);

        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int[] calendarDay = new int[localDate.lengthOfMonth()];


        JButton[] jrbArr = new JButton[calendarDay.length];
        setLayout(new GridLayout(5, 7));
        JButton jbtnFwdMonth = new JButton("31");
        jbtnFwdMonth.setBackground(Color.BLACK);
        jbtnFwdMonth.setFont(font);
        add(jbtnFwdMonth);

        for (int i = 0; i < calendarDay.length; i++) {
            calendarDay[i] = i + 1;
            jrbArr[i] = new JButton(String.valueOf(calendarDay[i]));
            jrbArr[i].setBackground(Color.BLACK);
            jrbArr[i].setForeground(Color.WHITE);
            jrbArr[i].setFont(font);
            add(jrbArr[i]);
        }

        String[] numArr={"1","2","3"};
        JButton[] jrbArr2 = new JButton[numArr.length];

        for (int i = 0; i < numArr.length; i++) {
            jrbArr2[i] = new JButton(numArr[i]);
            jrbArr2[i].setBackground(Color.BLACK);
            jrbArr2[i].setFont(font);
            add(jrbArr2[i]);
        }

        setBounds(200,200,500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CalendarWork();
    }
}

package day0125.work0125;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class CalendarWork extends JFrame {
    public Calendar calendar = Calendar.getInstance();
    public int lastDay;
    public int dayOfWeek;

    public CalendarWork() {
        super("달력");

        initializeCalendar();
        setSelectedMonthInfo();

        int[] calendarDay = new int[lastDay];

        JButton[] jrbArr = new JButton[calendarDay.length];
        setLayout(new GridLayout(0, 7));

        lastMonthDay(dayOfWeek - 1);
        printThisMonth(calendarDay, jrbArr);
        nextMonthDay();
        swingSet();
    }

    public void initializeCalendar(){
        String inputData = JOptionPane.showInputDialog("출력할 달력의 월을 입력하세요 (기준연도 : 2024)");
        int selectMonth = Integer.parseInt(inputData);
        calendar.set(Calendar.MONTH, selectMonth-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
    }

    public void setSelectedMonthInfo(){
        lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public void lastMonthDay(int lastMonthDay) {
        JButton jbtnFwdMonth;
        for (int i = lastMonthDay - 1; i >= 0; i--) {
            jbtnFwdMonth = new JButton(String.valueOf(lastDay - i));
            setButton(jbtnFwdMonth);
        }
    }

    public void printThisMonth(int[] calendarDay, JButton[] jrbArr) {
        for (int i = 0; i < calendarDay.length; i++) {
            calendarDay[i] = i + 1;
            jrbArr[i] = new JButton(String.valueOf(calendarDay[i]));
            setButton(jrbArr[i]);
            jrbArr[i].setForeground(Color.WHITE);
        }
    }

    public void nextMonthDay() {
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        int lastDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int nextMonthButton = Calendar.DAY_OF_WEEK - lastDayOfWeek;

        String[] numArr = new String[nextMonthButton];
        for (int i = 0; i < nextMonthButton; i++) {
            numArr[i] = String.valueOf(i + 1);
        }

        JButton[] jrbArr2 = new JButton[numArr.length];

        for (int i = 0; i < numArr.length; i++) {
            jrbArr2[i] = new JButton(numArr[i]);
            setButton(jrbArr2[i]);
        }
    }

    public void setButton(JButton button) {
        Font font = new Font("맑은고딕", Font.BOLD, 20);
        button.setBackground(Color.BLACK);
        button.setFont(font);
        add(button);
    }

    public void swingSet() {
        setBounds(200, 200, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CalendarWork();
    }
}

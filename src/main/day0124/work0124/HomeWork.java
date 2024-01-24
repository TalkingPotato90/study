package day0124.work0124;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class HomeWork {
    public static final int STUDENT_NUMBER = 0;
    public static final int STUDENT_NAME = 1;
    public static final int JAVA_SCORE = 2;
    public static final int ORACLE_SCORE = 3;
    private Set<WorkVO> workSet;
    private boolean status = true;

    public HomeWork() {
        this.workSet = new HashSet<>();
    }

    public void selectMode() {
        String inputData = JOptionPane.showInputDialog("메뉴\n1.입력 2.검색 3.종료");
        if (inputData.equals("1")) {
            convertInputData(inputData);
        } else if (inputData.equals("2")) {
            printFormat();
        } else if (inputData.equals("3")) {
            exitCondition();
        }
    }

    public void convertInputData(String inputData) {
        inputData = JOptionPane.showInputDialog("학생의 정보를 아래와 같이 입력해주세요.\n예)학생번호,이름,자바점수,오라클점수");

        if (inputData.startsWith("1")) {
            checkInputData();
            convertInputData(inputData);
        } else {
            String[] temp = inputData.split(",");
            int number = Integer.parseInt(temp[STUDENT_NUMBER]);
            String name = temp[STUDENT_NAME];
            int java = Integer.parseInt(temp[JAVA_SCORE]);
            int oracle = Integer.parseInt(temp[ORACLE_SCORE]);
            WorkVO workVO = new WorkVO(number, name, java, oracle);

            workSet.add(workVO);
        }
    }

    public void checkInputData() {
        JOptionPane.showMessageDialog(null, "이미 존재하는 번호입니다");
    }

    public void printFormat() {
        System.out.printf("%3s %5s %5s %5s %5s %5s %n", "번호", "이름", "자바", "오라클", "총점", "평균");
        for (WorkVO workVO : workSet) {
            workVO.printScore();
        }
    }

    public void exitCondition() {
        status = false;
    }

    public static void main(String[] args) {

        HomeWork homeWork = new HomeWork();
        while (homeWork.status) {
            homeWork.selectMode();
        }

    }
}

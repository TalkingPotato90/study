package day0123.work0123;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    private List<WorkVO> workList;
    private boolean status = true;

    public HomeWork() {
        this.workList = new ArrayList<>();
    }

    public void selectMode() {
        String inputData = JOptionPane.showInputDialog("\"이름,자바점수,오라클점수\" 입력\n\"출력\"을 입력하면 출력됩니다.\n " +
                "종료하시려면 \"Y | y\"를 입력해주세요");

        if (inputData.contains(",")) {
            convertInputData(inputData);
        } else if (inputData.equals("출력")) {
            printFormat();
        } else if (inputData.equalsIgnoreCase("y")) {
            exitCondition();
        }
    }

    public void convertInputData(String inputData) {
        String[] temp = inputData.split(",");
        String name = temp[0];
        int java = Integer.parseInt(temp[1]);
        int oracle = Integer.parseInt(temp[2]);
        WorkVO workVO = new WorkVO(name, java, oracle);

        workList.add(workVO);
    }

    public void printFormat() {
        System.out.printf("%3s %5s %5s %5s %5s%n", "번호", "이름", "자바", "오라클", "총점");
        for (WorkVO workVO : workList) {
            workVO.printScore();
        }
    }

    public void exitCondition() {
        status = false;
    }
    public static void main(String[] args) {

//        String inputData = JOptionPane.showInputDialog("이름을 입력해주세요", "홍길동");
//        StringBuilder sb = new StringBuilder();
//        if ("윤웅찬".equals(inputData)) {
//            sb.append("조원동의 자랑 ");
//        }
//        sb.append(inputData).append("님");
//
//        System.out.println(sb);

//        String inputData = JOptionPane.showInputDialog("\"이름,자바점수,오라클점수\" 입력\n\"출력\"을 입력하면 출력됩니다.\n 종료하시려면 \"Y | y\"를 입력해주세요");
        HomeWork homeWork = new HomeWork();
        while (homeWork.status) {
            homeWork.selectMode();
        }

    }
}

package day0123.work0123;

import javax.swing.*;

public class HomeWork {

    public String selectMode(){
        String inputData = JOptionPane.showInputDialog("\"이름,자바점수,오라클점수\" 입력\n\"출력\"을 입력하면 출력됩니다.\n 종료하시려면 \"Y | y\"를 입력해주세요");
        return "출력";
    }

    public void processInputData() {
        String inputData = JOptionPane.showInputDialog("\"이름,자바점수,오라클점수\" 입력\n\"출력\"을 입력하면 출력됩니다.\n 종료하시려면 \"Y | y\"를 입력해주세요");
        if (inputData.contains(",")) {
            String[] temp = inputData.split(",");
            String name = temp[0];
            int java = Integer.parseInt(temp[1]);
            int oracle = Integer.parseInt(temp[2]);
            WorkVO workVO = new WorkVO(name, java, oracle);
            workVO.setStudentName(name);
            workVO.setJavaScore(java);
            workVO.setOracleScore(oracle);
            System.out.println(1 + "  " + workVO.getStudentName()+"  "+workVO.getJavaScore()+ "  "+workVO.getOracleScore() + "  " + 200);
        } else if (inputData.equals("출력")) {
            System.out.println("번호 이름 자바 오라클 총점");
        } else if(inputData.toLowerCase().equals("y")){
        }
    }

    public void outputData() {
    }

    public void printFormat() {
    }

    public void exitCondition() {

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
        homeWork.processInputData();

    }
}

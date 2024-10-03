package day0124;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class HomeWork2 {

    public static final int CSV_DATA = 3;
    private List<WorkVO> list;

    public HomeWork2() {
        list = new ArrayList<WorkVO>();
    }

    int cnt = 0;

    /**
     * 메뉴를 입력 받아서 CSV데이터인지, 출력, 종려 인지를 판단하여
     * 해당 method를 호출하는 일
     */
    public void inputMenu() {

        boolean exitFlag = false;
        String inputData;
        String[] inputArr; // CSV데이터를 저장할 배열
        do {

            inputData = JOptionPane.showInputDialog("이름,자바점수,오라클점수 입력\n출력을 입력하면 출력됩니다.\n중료하실려면 Y,y를 눌러주세요");
            if (inputData != null) {
                inputArr = inputData.split(",");

                switch (inputArr.length) {
                    case CSV_DATA:
                        inputData(inputArr);
                    default:
                        if ("출력".equals(inputData)) {
                            printData();
                        }

                        exitFlag = "Y".equals(inputData) || "y".equals(inputData);
//                    if ("y".equals(inputData)||"Y".equals(inputData)) {
//                        char key = inputData.charAt(0);
//                        exitFlag=exitProgram(key);
//                    }
                }

            }
        }
        while (!exitFlag);
    }

    public void inputData(String[] inputArr) {
        String name = inputArr[0];
        int java = Integer.parseInt(inputArr[1]);
        int oracle = Integer.parseInt(inputArr[2]);

        WorkVO vo = new WorkVO(name, java, oracle);

        list.add(vo);
    }

    /**
     * 출력 메서드
     */
    public void printData() {
        System.out.println("번호\t이름\t자바\t오라클\t총점");
        WorkVO wVO = null;
        for (int i = 0; i < list.size(); i++) {
            wVO = list.get(i);
            System.out.print((i + 1) + "\t" + wVO.getName() + "\t" + wVO.getJava() + "\t"
                    + wVO.getOracle() + "\t" + (wVO.getOracle() + wVO.getJava()) + "\n");
        }
    }

    /**
     * 종료 메서드
     */
    public boolean exitProgram(char key) {
        return key == 'Y' || key == 'y';
    }

    public static void main(String[] args) {
        HomeWork2 hm = new HomeWork2();
        hm.inputMenu();
    }
}

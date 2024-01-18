package day0118.work0118;

import java.util.HashSet;
import java.util.Set;

public class Work0118 {

    public static void generateArray() {
        String[] mz = "어쩔티비,저쩔티비,뇌절티비,안물티비,안궁티비,때리고싶쥬~,못때리쥬~,개킹받쥬~".split(",");
        int randIndex = (int) (Math.random() * 8);
        System.out.println(mz[randIndex]);
    }

    public static char validateRandomNum() {
        char inRangeChar;
        while (true) {
            char temp = (char) ((Math.random() * 75) + 48);
            if ((temp < 58) || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)) {
                inRangeChar = temp;
                break;
            }
        }
        return inRangeChar;
    }

    public static void generatePassword() {
        char[] password = new char[8];
        for (int i = 0; i < password.length; i++) {
            password[i] = validateRandomNum();
        }
        System.out.println(password);
    }

    public static int[] generateLottoNum() {
        int[] lottoNum = new int[6];
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < lottoNum.length; ) {
            int randomNumber = (int) ((Math.random() * 45) + 1);
            if (uniqueNumbers.add(randomNumber)) {
                lottoNum[i++] = randomNumber;
            }
        }
        return lottoNum;
    }

    public static void printLotto(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        generateArray();
        generatePassword();
        printLotto(generateLottoNum());
    }


}
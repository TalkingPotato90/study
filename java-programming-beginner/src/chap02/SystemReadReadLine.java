package chap02;

// readLine 문을 사용하기 위해 선언
import java.io.*;

public class SystemReadReadLine {
    // 에러 발생 시 예외처리
    public static void main(String[] args) throws java.io.IOException {
        int i;
        char ch;
        System.out.println("-->문자의 입력 실습<--");
        System.out.print("숫자와 문자를 입력 하세요 =>");
        // 아스키 문자의 숫자와 맞추기 위해 48을 뺌
        i = System.in.read() - 48;
        // 첫 번째 숫자 입력
        ch = (char) System.in.read();
        System.out.println("\n입력된 숫자 -> " + i);
        System.out.println("입력된 문자 -> " + ch);
        System.out.println();
        // 두 번째 알파벳 문자 입력
        ch = (char) System.in.read();

        // System.in readLine 사용을 위해 객체 선언
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String enter1 = in.readLine(); // 프로그램을 멈추기 위해 선언
        System.out.print("\n이름을 입력하세요 => ");
        String name = in.readLine(); // [Enter]키 전까지 입력 저장
        System.out.println("입력된 문자열 -> " + name);
        System.out.println();

    }
}

package chapter16;

import java.util.Scanner;

public class Ex01_ExceptionCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        // 입력되는 숫자가 0 일때만 예외 발생
        // 개발자가 판단과 처리
        int num2 = 10 / num1;
        System.out.println(num2);

        // 참조할 MyBook 클래스가 없어 에러 발생
        // 예외처리 필수
//        MyBook book1 = new MyBook();
    }
}

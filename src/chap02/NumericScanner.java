package chap02;

import java.util.Scanner;

public class NumericScanner {
    public static void main(String[] args) {
        // 데이터를 입력받기 위한 객체 선언
        Scanner sc = new Scanner(System.in);
        System.out.println("-->스캐너를 이용한 실습<--");
        System.out.println("\n정수 값 입력");

        // 첫 번째 데이터 입력
        int x = sc.nextInt();
        System.out.println("정수 값은 " + x);
        System.out.println("\n실수 값 입력");

        // 두 번째 데이터 입력
        double d = sc.nextDouble();
        System.out.println("실수 값은 " + d);
        System.out.println();
    }
}

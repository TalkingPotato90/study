package chap02;

import java.util.Scanner;

public class StringScanner {
    public static void main(String[] args) {
        System.out.println("-->스캐너를 이용한 문자 입력 실습<--");
        String str;
        // 데이터 입력을 받기 위한 객체 선언
        Scanner sc = new Scanner(System.in);
        System.out.println("\n이름을 입력");
        // next() 문은 문자열을 입력 받음
        str = sc.next();
        System.out.println("\n이름은 " + str);
        System.out.println();
    }
}

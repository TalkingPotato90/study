package chapter16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex09_ThrowsInMethod {
    public static void myMethod1() {
        myMethod2();
    }

    // RuntimeException 클래스는 throws 하지 않고
    // 반드시 처리해주어야하는 일반 예외 클래스만 선언하는 것이 일반적
    // RuntimeException 클래스를 선언해도 문제 ❌
    public static void myMethod2() throws ArithmeticException, InputMismatchException {
        Scanner sc = new Scanner(System.in);

        // 에러 발생 지점
        int num1 = sc.nextInt();
        // 에러 발생 지점
        int num2 = 10 / num1;
        System.out.println(num2);
    }

    public static void main(String[] args) {
        try {
            myMethod1();
        } catch (ArithmeticException | InputMismatchException e) {
            e.printStackTrace();
        }
        System.out.println("-------");
    }
}

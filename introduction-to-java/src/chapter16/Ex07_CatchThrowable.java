package chapter16;

import java.util.Scanner;

public class Ex07_CatchThrowable {
    public static void myMethod1() {
        myMethod2();
    }

    public static void myMethod2() {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = 10 / num1;
        System.out.println(num2);
    }

    public static void main(String[] args) {
        try {
            myMethod1();
        } catch (Throwable e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
        }
    }
}

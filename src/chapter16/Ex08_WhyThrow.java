package chapter16;

import java.util.Scanner;

public class Ex08_WhyThrow {
    public static void myMethod1(){
        try{
            // 여기로 예외가 넘어옴
            myMethodA();
        }catch (Throwable e){
            System.out.println("에러 !!!");
        }
    }

    public static void myMethod2(){
        try {
            // 여기로 예외가 넘어옴
            myMethodA();
        } catch(Throwable e){
            System.out.println("Error !!!");
        }
    }

    public static void myMethodA(){
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = 10 / num1;
        System.out.println(num2);
    }

    public static void main(String[] args) {
        myMethod1();
        myMethod2();
    }
}

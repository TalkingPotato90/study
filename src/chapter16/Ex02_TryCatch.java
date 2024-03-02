package chapter16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02_TryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            // 에러 발생 지점
            int num1 = sc.nextInt();
            // 에러 발생 지점
            int num2 = 10 / num1;
            System.out.println(num2);
            System.out.println("Good bye~~!");
        }
        // 수학적 오류 예외 처리
        catch (ArithmeticException e){
            // 예외에 대한 간단한 메시지를 문자열로 받아온다
            String str = e.getMessage();
            System.out.println(str);
            if (str.equals("/ by zero"))
                System.out.println("0으로 나눌 수 없습니다.");
        }
        // 입력값이 정수가 아닐 때 예외 처리
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
    }
}

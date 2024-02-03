package chap02;

public class Increment {
    public static void main(String[] args) {
        System.out.println("-->증감 연산자 실습<--");
        int x = 1;
        System.out.println("x = " + x);
        // x++은 1 값을 유지하며, 다음 줄로 가서 2로 증가
        int y = x++ * 2;
        System.out.println("x++ * 2 = " + y);

        x = 1;
        // ++x는 무조건 1을 증가
        y = ++x * 2;
        System.out.println("++x * 2 = " + y);

        x = 5;
        System.out.println("\nx = " + x);
        // ++x를 먼저 증가하고 x/2는 정수 연산으로 2 값이 발생
        System.out.println("x / 2 + ++x = " + (x / 2 + ++x));
        x = 5;
        // -x는 -5 값, x++은 그대로 5 값 유지
        System.out.println("-x + x++ = " + (-x + x++));
        x = 5;
        // x + ++x + x = 5 + 6 + 6 = 17
        System.out.println("x + ++x + x = " + (x + ++x + x));
        System.out.println();
    }
}

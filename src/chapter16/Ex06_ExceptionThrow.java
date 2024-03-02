package chapter16;

public class Ex06_ExceptionThrow {
    // myMethod1()에도 예외 처리가 되어있지 않음
    // myMethod1()을 호출한 main()으로 예외 던짐
    public static void myMethod1(int n){
        myMethod2(n, 0);
    }

    public static void myMethod2(int n1, int n2) {
        // 0으로 나누어 예외가 발생하나 예외처리를 하지 않음
        // myMethod2()를 호출한 myMethod1()으로 예외가 던져짐
        int r = n1 / n2;
    }

    // main()에도 예외 처리가 없어 JVM으로 예외 던짐
    public static void main(String[] args) {
        myMethod1(3); // 여기서 프로그램 종료
        System.out.println("Exception Throw !!!"); // 실행 ❌
    }
}

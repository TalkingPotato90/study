package chap02;

public class ShortCircuitOperator {
    public static void main(String[] args) {
        System.out.println("-->단순 논리연산자 실습<--");
        int x = 5;
        // true && true = true 연산
        boolean b = x > 4 && x < 9;
        System.out.println(b);
        // true || true = true 연산
        b = (x > 4) || (x < 9);
        System.out.println(b);
        // true && false = false 연산
        System.out.println(true && false);
        // !(true) = false 연산
        b = !(x > 4);
        System.out.println(b);
        System.out.println();
    }
}

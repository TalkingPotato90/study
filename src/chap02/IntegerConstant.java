package chap02;

public class IntegerConstant {
    public static void main(String[] args) {
        // 변수 선언
        int i, j, k;
        // 진수 값 대입
        i = 23; // 10진수
        j = 023; // 8진수
        k = 0X23; // 16진수

        // 결과 출력
        System.out.println("--->진수의 표현<---");
        System.out.println("10진수 23   -> " + i);
        System.out.println("8진수  023  -> " + j);
        System.out.println("16진수 0X23 -> " + k);
    }
}

package chap02;

/*
    주석 처리와 변수 선언
    Variable.java
 */
public class Variable {
    public static void main(String[] args) {
        int var1; // 변수의 선언
        int var2; // 다른 변수의 선언

        var1 = 1024; // 변수에 값을 할당
        // 문자열과 변수의 값
        System.out.println("var1 = " + var1);

        // 연산식
        var2 = var1 / 2;
        // 결과 출력
        System.out.print("var2 = var1 / 2 : ");
        System.out.println(var2);
    }
}

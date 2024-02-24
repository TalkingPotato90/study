package chap02;

public class Character {
    public static void main(String[] args) {
        System.out.println("-->Ascii Code 값<--");
        // 변수 선언 및 초기화
        int x = 65, y;
        // (char)문은 아스키 코드의 숫자에 해당되는 문자가 출력
        System.out.println(x + " = " + (char) x);
        // 연산식
        y = x + 32;
        System.out.println(y + " = " + (char) y);
        y = 36;
        System.out.println(y + " = " + (char) y);
        x = x + 30;
        System.out.println(x + " = " + (char) x);
        System.out.println();
    }
}

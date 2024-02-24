package chap02;

public class Char {
    public static void main(String[] args) {
        // 유니코드 대입
        char a = '\u0041'; // 유니코드
        // 개행 문자 대입
        char b = '\n'; // 다음 줄로 이동
        // 점 문자 대입
        char c = '.'; // 점 문자

        System.out.println("a = " + a);
        // b에 들어 있는 코드는 다음 줄로 이동하라는 개행문자이므로 출력되면 문자가 나타나지 않고 빈 줄을 하나 나타냄
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        // 모든 Char가 묶여서 출력됨
        System.out.println("a + b + c = " + a + b + c);
    }
}

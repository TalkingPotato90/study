package chap02;

public class LiteralCompute {
    public static void main(String[] args) {
        System.out.println("--->숫자와 문자의 연산<---");
        // 수치 연산
        System.out.println(6+4);
        // 문자 연산으로 아스키 값이 연산
        System.out.println('6'+'4'); // ascii 코드 '6' --> 54, '4' --> 52
        // 문자열 연산으로 결합법칙 적용
        System.out.println("abc" + "def");
        // 문자와 수치 연산으로 문자로 결과 출력
        System.out.println("abc"+6);
        System.out.println();
    }
}

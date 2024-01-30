package chap02;

public class UnicodeDisplay {
    public static void main(String[] args) {
        // unicode => char
        System.out.println('\u0041'); // A
        System.out.println('\u0061'); // a
        System.out.println('\uAC00'); // 가
        System.out.println('\uB098'); // 나
        System.out.println();

        // a 문자의 서로 다른 유니코드 문자 표현 방식
        char ch1 = '\u0061';
        char ch2 = '\uuuuu0061';
        char ch3 = '\uuuuuuuuuuuuuuuuuu0061';

        // a 문자의 출력
        System.out.println("ch1 : " + ch1);
        System.out.println("ch2 : " + ch2);
        System.out.println("ch3 : " + ch3);
        System.out.println();

        // 유니코드 문자의 길이
        System.out.println("a\u0022.length() + \u0022b".length());
        System.out.println("a".length() + "b".length());
    }
}

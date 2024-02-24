package chap02;

public class EscapeConstant {
    public static void main(String[] args) {
        System.out.println("-->이스케이프 상수의 표현<--");
        System.out.println("");

        // BackSpace의 문자값
        System.out.println(" backSpace  값 " + (int) '\b');

        // 탭의 문자값
        System.out.println(" tab        값 " + (int) '\t');

        // 다음 줄로 이동의 문자값
        System.out.println(" newline    값 " + (int) '\n');

        // CarriageReturn의 문자값
        System.out.println(" CR         값 " + (int) '\r');

        // "의 문자값
        System.out.println(" \"          값 " + (int) '\"');

        // '의 문자값
        System.out.println(" \'          값 " + (int) '\'');

        // null의 문자값
        System.out.println(" null       값 " + (int) '\0');
    }
}

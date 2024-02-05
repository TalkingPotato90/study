package chap02;

public class Printf2 {
    public static void main(String[] args) {
        int num = 763;
        double x = 658.75;
        String str = "Java Program.";
        System.out.println("-->printf문 문자열과 정수 출력 실습<--\n");
        System.out.println("1234567890123456789" + "01234567890");
        System.out.printf("%5d%7.2f%15s%n", num, x, str);
    }
}

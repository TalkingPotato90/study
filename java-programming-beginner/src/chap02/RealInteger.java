package chap02;

public class RealInteger {
    public static void main(String[] args) {
        System.out.println("실수형과 정수형 혼합 연산");
        int a;
        double b;

        a = 5;
        b = 3.7;
        // 실수형과 정수형 변수 혼합 연산
        System.out.println("a = " + a + "\nb = " + b);

        double c = a + b; // int는 실수형으로 변환
        System.out.println("c = " + c);

        int d;
        // 형 변환
        d = (int) c; // double 형은 int 형으로 변환
        System.out.println("d = " + d);
    }
}

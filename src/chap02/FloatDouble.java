package chap02;

public class FloatDouble {
    public static void main(String[] args) {
        float f;
        double d;

        System.out.println("-->실수형 상수<--");
        System.out.println("양의 실수 12.345 -> " + 12.345);
        System.out.println("음의 실수 -67.890 -> " + -67.890);

        d = 12.345 + -12.345;
        System.out.println("실수형 상수 d = " + d);

        // 지수는 출력자료를 확인해야 한다
        System.out.println("지수 12.345E5 -> " + 12345e5);
        System.out.println();
    }
}

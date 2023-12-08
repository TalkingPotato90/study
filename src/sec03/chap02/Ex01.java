package sec03.chap02;

public class Ex01 {
    public static void main(String[] args) {
        double a = 0.1, b = 0.2;

        // ⚠️ 오차가 생김, c = 0.30000000000000004
        double c = a + b;
    }
}

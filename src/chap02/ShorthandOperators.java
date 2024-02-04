package chap02;

public class ShorthandOperators {
    public static void main(String[] args) {
        int w = 10, x, y;
        x = 1;
        y = 2;
        System.out.println("-->축약 대입 연산자 실습<--");
        System.out.println("w = " + w + ", x = " + x + ", y = " + y);

        // 대입 연산자를 중심으로 오른쪽의 연산식에 대한 결과 대입 받는 변수에 누적 및 출력
        w += x;
        System.out.println("w = w + x : " + w);

        w = 10;
        w -= y;
        System.out.println("w = w * (x+ y) : " + w);

        w = 10;
        w /= y;
        System.out.println("w = w / x : " + w);

        w = 10;
        w %= x;
        System.out.println("w = w % x : " + w);
        System.out.println();

    }
}

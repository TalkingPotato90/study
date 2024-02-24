package chap02;

public class ShiftOperator {
    public static void main(String[] args) {
        byte x, y;
        int z;
        System.out.println("-->쉬프트 연산자 실습<--");
        // shift 연산자로 연산자 부호의 오른쪽 숫자만큼 bit를 좌우로 이동
        System.out.println("15 << 2 ->> " + (15 << 2));
        System.out.println("15 >> 2 ->> " + (15 >> 2));
        System.out.println("-15 >>> 2 ->> " + (-15 >>> 2));

        // byte 형 변환
        x = (byte)1;
        y = (byte)-1;
        z = -16;
        System.out.println("\nx = " + x +" , y = " + y + ", z = " + z );
        // 논리 연산 후 byte로 형 변환
        System.out.println(" ~x | x = " + (byte)(~x|x));
        System.out.println("  x ^ x = " + (byte)(x^x));
        // 부등호 방향으로 숫자값만큼 쉬프트 연산
        System.out.println(" x << 3 = " + (byte)(x << 3));
        System.out.println(" x >> 3 = " + (byte)(x >> 3));
        System.out.println("x >>> 3 = " + (int)(x >>> 3));
        System.out.println(" y << 3 = " + (byte)(y << 3));
        System.out.println(" y >> 3 = " + (byte)(y >> 3));
        System.out.println("z >>> 4 = " + (z >>> 4));
        System.out.println();

    }
}

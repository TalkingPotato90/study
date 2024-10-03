package day0102;

/*
대입연산
=,
+=, -=, *=, /=, %=,
<<=, >>=, >>>=,
&=, |=, ^=
*/
class Operator7 {
    public static void main(String[] args) {
        // 순수대입
        int i = 11;
        i = 25; // 기존의 값이 사라진다.
        System.out.println(i);

        // 산술 대입 : 기존의 값과 연산 후 연산 결과를 다시 변수에 할당.
        i += 2; // i = i + 2;
        i -= 20; // i = i - 20;
        i *= 3; // i = i * 3;
        i /= 4; // i = i / 4;
        i %= 3; // i = i % 3; // 0, 1, 2 중 하나가 나온다.

        // 쉬프트 대입
        i <<= 4; // i = i <<4; // 0000 0010 << 4 = 0010 0000
        i >>= 1; // i = i >>1; // 0010 0000 >> 1 = 0001 0000
        i >>>= 2; // i = i >>>2; // 0001 0000 >>> 2 = 0000 0100

        // 비트논리대입
        i &= 20; // i = i & 20; // 0000 0100 & 0001 0100 = 0000 0100
        i |= 0xF; // i = i | 15; // 0000 0100 | 0000 1111 = 0000 1111
        i ^= 10; // i = i ^ 10; // 0000 1111 ^ 0000 1010 = 0000 0101

        System.out.println(i);
    } // main
} // class

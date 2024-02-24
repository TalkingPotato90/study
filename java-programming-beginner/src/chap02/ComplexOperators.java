package chap02;

public class ComplexOperators {
    public static void main(String[] args) {
        int a;
        System.out.println("-->q복합 대입 연산자 실습<--");
        a = 10; // a 변수에 10을 대입
        a = a + 1;
        System.out.println("a = " + a); // 11

        a += 1;
        System.out.println("a = " + a); // 12

        a++;
        System.out.println("a = " + a); // 13

        a *= 10; // a = a * 10;
        System.out.println("a = " + a); // 130

        byte b = 1;
        b = (byte) (b+1);
        /*
        형 변환을 하지 않으면 컴파일에러
        byte 형인 b와 int형 리터럴인 숫자 1이 연산을 하면 결과값이 int형이라서
        형 변환을 하지 않으면 byte형인 b에 값을 넣을 수 없음
         */
        System.out.println("b = " + b); // 2

        b = 1;
        b +=1; // 형 변환 필요없음, 대입연산자로 취급됨
        System.out.println("b = " + b); // 2

        b++;
        System.out.println("b = " + b); // 3
        System.out.println();
    }
}

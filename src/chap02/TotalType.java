package chap02;

public class TotalType {
    public static void main(String[] args) {
        int i =65;
        short j =65;
        long k = 65L;
        int decimal_v = 10;
        int octal_v = 010;
        int hexa_v = 0X10;

        float x = 65.0F;
        double y = 65.0;

        char z = 65;
        char zz = 'A';
        char zzz = '\u0041';
        char z_z = 66;
        char z_zz = 'B';
        char z_zzz = '\u0042';

        boolean ken = true;
        boolean boo = false;
        System.out.println("-->전체 자료형 실습<--");
        System.out.println("\n** 정수형 상수와 변수의 표현 **");
        System.out.println("int i = " + i);
        System.out.println("short j = " + j);
        System.out.println("long k = " + k);

        System.out.println("** 정수형 상수의 진수 표현 **");
        System.out.println("10진수(10)의 표현 = " + decimal_v);
        System.out.println("8진수(010)의 표현 = " + octal_v);
        System.out.println("16진수(0X10)의 표현 = " + hexa_v);

        System.out.println("\n** 실수형 상수와 변수의 표현 **");
        System.out.println("float x = " + x);
        System.out.println("double y = " + y);

        System.out.println("\n** 문자형 상수와 변수의 표현 **");
        System.out.println("ASCII 코드 \'65\'의 문자형 표현 = " + z);
        System.out.println("문자형 상수 \'A\'의 문자형 표현 = " + zz);
        System.out.println("유니코드 \'\\u0041\'의 문자형 표현 = " + zzz);
        System.out.println("ASCII 코드 \'66\'의 문자형 표현 = " + z_z);
        System.out.println("문자형 상수 \'B\'의 문자형 표현 = " + z_zz);
        System.out.println("유니코드 \'\\u0042\'의 문자형 표현 = " + z_zzz);

        System.out.println("\n** 논리형 상수와 변수의 표현 **");
        System.out.println("boolean ken = " + ken);
        System.out.println("boolean boo = " + boo);

        System.out.println("\n** escape 문자의 표현 **");
        System.out.println("\t\'boolean ken\' = " + ken);
        System.out.println("\t\"boolean boo\" = " + boo);
        System.out.println();

    }
}

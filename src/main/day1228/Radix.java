package day1228;

/*
진수 사용
*/
class Radix {
    public static void main(String[] args) {

        int i = 10; // 10진수 -> 2진수로 저장
        int j = 012; // 8진수 -> 2진수로 저장
        int k = 0xA; // 16진수 -> 2진수로 저장

        System.out.println(i + j + k); // 2진수를 연산하여 10진수로 보여준다

        i = 25;
        System.out.println(i + "를 2진수로 : " + Integer.toBinaryString(i));

        i = 89;
        System.out.println(i + "를 2진수로 : " + Integer.toBinaryString(i));

        i = 300;
        System.out.println(i + "를 2진수로 : " + Integer.toBinaryString(i));

        System.out.println("==============================================");

        System.out.println("0X25를 2진수로 : " +
                Integer.toBinaryString(0X25));
        System.out.println("0X1D를 2진수로 : " +
                Integer.toBinaryString(0X1D));
        System.out.println("0XFF를 2진수로 : " +
                Integer.toBinaryString(0XFF));

        System.out.println("==============================================");

        System.out.println("10을 8진수로 : " +
                Integer.toOctalString(10));
        System.out.println("200을 8진수로 : " +
                Integer.toOctalString(10));

        System.out.println("==============================================");

        System.out.println("25 를 16진수로 : "
                + Integer.toHexString(25));
        System.out.println("300 를 16진수로 : "
                + Integer.toHexString(300));

        int tel = 01012341234; // 0으로 시작하는 수는 8진수
        System.out.println("내 전화번호는 :" + tel);
        // 8진수를 출력하면 10진수로 나온다. => 문자열로 저장

    } // main
} // class

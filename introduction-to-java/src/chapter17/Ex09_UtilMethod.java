package chapter17;

public class Ex09_UtilMethod {
    public static void main(String[] args) {
        Integer n1 = Integer.valueOf(5);
        Integer n2 = Integer.valueOf("1024");

        // 둘 중의 큰 수
        System.out.println("큰 수 : " + Integer.max(n1,n2));
        // 둘 중에 작은 수
        System.out.println("작은 수 : " + Integer.min(n1,n2));
        // 두 수의 합
        System.out.println("합 : " + Integer.sum(n1,n2));
        System.out.println();

        // 정수를 2진수로 표현
        System.out.println("12의 2진 표현 : 0B" + Integer.toBinaryString(12));
        // 정수를 8진수로 표현
        System.out.println("12의 8진 표현 : 0" + Integer.toOctalString(12));
        // 정수를 16진수로 표현
        System.out.println("12의 16진 표현 : 0x" + Integer.toHexString(12));
    }
}

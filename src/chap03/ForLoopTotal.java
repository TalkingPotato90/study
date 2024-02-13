package chap03;

public class ForLoopTotal {
    public static void main(String[] args) {
        System.out.println("-->반복문의 합계를 구하는 for문 실습<--");
        int n = 0, sum = 0;
        for (n = 0; n <= 100; n++)
            sum = sum + n;
        System.out.println("1에서 100까지 전체 합계 = " + sum);

        sum = 0;
        for (n = 0; n <= 100; n = n + 2)
            sum = sum + n;
        System.out.println("1에서 100까지 짝수 합계 = " + sum);


        sum = 0;
        for (n = 1; n <= 100; n = n + 2)
            sum = sum + n;
        System.out.println("1에서 100까지 홀수 합계 = " + sum);
        System.out.println();
    }
}

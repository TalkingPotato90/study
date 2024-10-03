package ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        // for문 밖에서 사용될 변수이기 때문에 for문 시작 전에 선언
        int sum = 0;
        int i;

        for (i = 1; i <= 100; i++) {
            sum += i;
        }

        // for문이 종료된 후 i++때문에 마지막 i가 101이 된다
        System.out.println("1~"+ (i-1) + " 합 : " + sum);
    }
}

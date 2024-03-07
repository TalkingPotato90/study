package chapter23;

import java.util.Arrays;

public class Ex02_Pipeline {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // Pipeline 구성
        // 스트림 생성
        int sum = Arrays.stream(arr)
                // 중간 연산
                .filter(n -> n % 2 == 1)
                // 최종 연산
                .sum();

        System.out.println(sum);
    }
}

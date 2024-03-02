package chapter15;

import java.util.Arrays;

public class Ex12_ArrayCopy {
    public static void main(String[] args) {
        // 길이가 10인 arr1 배열을 0으로 초기화
        int[] arr1 = new int[10];
        // 길이가 8인 arr2 배열을 0으로 초기화
        int[] arr2 = new int[8];

        // 배열 arr1을 3으로 초기화
        // Arrays.fill() : 지정한 값으로 배열 채우기
        Arrays.fill(arr1, 3);

        // 배열 arr1을 arr2로 부분 복사
        // System.arraycopy() : 기존에 만들어진 배열에 복사한 값을 넣어준다
        System.arraycopy(arr1, 0, arr2, 3, 4);

        // arr1 출력
        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ");
        System.out.println();


        // arr2 출력
        for (int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();


        // 배열 arr1을 arr3으로 부분 복사
        // Arrays.copyOfRange() :
        // 배열에서 부분 복사한 값을 이용하여 배열 객체를 생성하여 반환하고 배열 변수에 대입
        int[] arr3 = Arrays.copyOfRange(arr2, 2, 5);

        // arr3 출력
        for (int i = 0; i < arr3.length; i++)
            System.out.print(arr3[i] + " ");
        System.out.println();


    }
}

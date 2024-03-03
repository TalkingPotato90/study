package chapter19;

import java.util.Scanner;

public class BubbleSort {
    // 매개변수로 배열 사용
    public static void getNumber(int[] num){
        // 입력 스트림을 처리하는 스캐너 클래스 정의
        Scanner sc = new Scanner(System.in);
        System.out.println("10개의 정수를 무작위로 입력하세요.");

        // 반복문을 사용해 정수 10개의 입력을 받는다
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
    }

    public static void bubbleSort(int[] num){
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if(num[j]>num[j+1]){
                    int tmp= num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // 입력된 정수 10개를 처리하는 배열 정의
        int[] num = new int[10];

        // 메서드에 배열의 참조 변수를 매개변수로 넘긴다
        getNumber(num);

        bubbleSort(num);

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}

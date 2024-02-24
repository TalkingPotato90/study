package chap03;

import java.util.Scanner;

public class ArrayOne2 {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-->1차원 배열에 데이터를 입력 후 역으로 출력<--");
        int[] items = new int[5];
        int sum;
        int counter;
        System.out.println("5개의 정수를 입력하고 Enter를 누르세요!!");

        sum = 0;

        for (counter = 0; counter < items.length; counter++) {
            items[counter] = console.nextInt();
            sum = sum + items[counter];
        }

        System.out.println("합계 = " + sum);
        System.out.print("역으로 출력한 결과 : ");

        for (counter = items.length - 1; counter >= 0; counter--)
            System.out.print(items[counter] + " ");
        System.out.println("\n");
    }
}

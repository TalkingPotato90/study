package chapter15;

class BoxA6{}

public class Ex06_ArrayInit {
    public static void main(String[] args) {
        // 기본 자료형은 별도의 초기화를 하지 않아도 초기화 됨
        int[] arr1 = new int[3];
        // 데이터의 개수로 숫자 파악 가능
        // [] 안의 숫자 생략 가능
        int[] arr2 = new int[] {1,2,3};
        double[] arr3 = {1.0, 2.0, 3.0};
        double[] arr4 = new double[3];
        BoxA6[] arr5 = new BoxA6[3];

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
            System.out.print(arr2[i] + " ");
            System.out.print(arr3[i] + " ");
            System.out.print(arr4[i] + " ");
            System.out.print(arr5[i] + " ");
            System.out.println();
        }
    }
}

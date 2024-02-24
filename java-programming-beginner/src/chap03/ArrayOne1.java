package chap03;

public class ArrayOne1 {
    public static void main(String[] args) {
        System.out.println("-->1차원 배열 정의 및 출력 실습<--");
        int k;
        int num[];
        num = new int[5];

        for (int i = 0; i < 5; i++) {
            num[i] = i;
        }
        k = num.length;
        System.out.println("배열 요소의 개수는? " + k + "\n");

        for (int i = 0; i < 5; i++) {
            System.out.println("num["+i+"]의 값은? " + num[i]);
        }
        System.out.println();
    }
}

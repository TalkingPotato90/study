package chap03;

public class NestedFor {
    public static void main(String[] args) {
        System.out.print("-->내포된 for문의 실습<--\n");
        int i, j;
        for (i = 1; i < 10; i += 2) {
            System.out.print("\n : " + i);
            for (j = 1; j <= i; j++)
                System.out.print("*");

        }

        for (i = 7; i >= 1; i-= 2) {
            System.out.print("\n : " + i);
            for (j = 1; j <= i; j++)
                System.out.print("*");

        }
        System.out.print("\n\n");
    }
}

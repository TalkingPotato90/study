package chap03;

public class GugudanNestedFor {
    public static void main(String[] args) {
        int i, k;
        System.out.print("\n\t\t\t 구구단\n\n");
        for (i = 1; i <= 9; i++) {
            for (k = 1; k <= 9; k++) {
                System.out.print(k + " * " + i + " = " + ((i * k) < 10 ? " " : "") + (i * k) + "  ");
            }
            System.out.print("\n\n");
        }
    }
}

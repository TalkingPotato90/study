package chap02;

public class DoubleThreeOperator {
    public static void main(String[] args) {
        System.out.println("-->중첩 조건 연산자<--");
        int i, n = 40;
        for (i = 1; i <= n; i++) {
            System.out.print(i + ((i % 5 == 0 || i == n) ?
                    "\n" : ((i < 10) ? "  " : " ")));
        }
        System.out.println();

    }
}

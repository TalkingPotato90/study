package chap03;

public class ContinueLable {
    public static void main(String[] args) {
        System.out.println("-->continue 레이블 문의 실습<--");
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue outer;
                }
                System.out.print(" " + (i * j));
            }
        }
        System.out.println("\n");
    }
}

package chap03;

public class BreakLoop {
    public static void main(String[] args) {
        System.out.println("-->break 문의 블록 탈출 실습<--\n");
        for (int i = 0; i < 3; i++) {
            System.out.print("통과 " + i + " : ");
            for (int j = 0; j < 100; j++) {
                if(j==10) break;
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("\n블록의 종료.\n");
    }
}

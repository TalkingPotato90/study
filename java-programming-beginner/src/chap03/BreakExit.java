package chap03;

public class BreakExit {
    public static void main(String[] args) {
        System.out.println("-->break label문으로 loop 탈출 실습<--");
        outer :
        for (int i = 0; i < 3; i++) {
            System.out.print("통과" + i +" : ");
            for (int j = 0; j < 100; j++) {
                if(j==10) break outer; // 2개의 블록 탈출
                System.out.print(j + " ");
            }
            System.out.println("이곳은 나타나지 않음!!");
        }
        System.out.println("\n블록 종료!!.\n");
    }
}

package chapter15;

public class Ex10_ForInFor {
    public static void main(String[] args) {
        // 2차원 배열을 선언합니다
        int[][] arr = new int[3][3];

        int num = 1;

        for (int i = 0; i < 3; i++) {
            // 먼저 i로 층을 정하고 여기서 j로 각 층의 방을 다 돕니다
            // 바깥쪽 for문의 i 값 한 개당 내부의 for문이 한바퀴 돕니다
            for (int j = 0; j < 3; j++) {
                arr[i][j] = num;
                num++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

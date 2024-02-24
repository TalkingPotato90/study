package chap03;

public class TwoDimArray {
    public static void main(String[] args) {
        int twoD[][] = new int[4][5];
        int i, j, k = 0;
        System.out.println("-->for 문으로 2차원 배열 데이터 실습<--");
        for (i = 0; i < 4; i++)
            for (j = 0; j < 5; j++) {
                twoD[i][j] = k;
                k++;
            }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                k = twoD[i][j];
                System.out.print(((k < 10) ? " " : "") + k + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
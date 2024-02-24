package chap03;

public class MultiArray {
    public static void main(String[] args) {
        System.out.println("-->2차원 배열에 데이터를 출력<--");
        String str; int number = 1;
        int multarray[][];
        multarray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                multarray[i][j] = number; number++;
            }
        }
        for (int i = 0; i < 5; i++) {
            str="";
            for (int j = 0; j < 5; j++) {
                str = str + "(" + i + ","+j+")"+multarray[i][j] + '\t';
            }
            System.out.println(str);
        }
        System.out.println();
    }
}

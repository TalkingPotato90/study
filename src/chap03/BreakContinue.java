package chap03;

public class BreakContinue {
    public static void main(String[] args) {
        System.out.println("-->continue와 Break 문의 실습<--");
        int i = 15;

        System.out.println("시작!");

        while (true) {
            i--;
            if (i > 10) continue;
            // i 변수가 10 이상이면 처음 while 문으로 되돌려 보냄

            if (i == 0) break; // i 변수가 0이 되면 while 문을 끝냄
            System.out.println(i);
        }
        System.out.println();
    }
}

package chap03;

public class Continue {
    public static void main(String[] args) {
        int i, sum;
        boolean FLAG = true;
        System.out.println("-->continue 문의 실습<--");
        i = 1;
        sum = 0;

        // while 문 안에서 FLAG가 true인 동안 수행
        while (FLAG) {
            sum += i;
            // irk 10보다 작으면 12번으로 이동
            if (i++ < 10) continue;
            FLAG = false;
        }
        System.out.println("1~10의 합계 = " + sum);
        System.out.println();
    }
}

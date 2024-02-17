package chap03;

public class BreakLabel {
    public static void main(String[] args) {
        System.out.println("-->label break 문의 실습<--\n");
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("break 호출 이전!!");
                    if (t) break second; // secnod 블록을 빠져나감
                    System.out.println("이 문장은 실행하지 않음");
                }
                System.out.println("이 문장은 실행하지 않음");
            }
            System.out.println("이 곳은 second 블록 이후 입니다!!");
        }
        System.out.println();
    }
}

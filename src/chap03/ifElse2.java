package chap03;

public class ifElse2 {
    public static void main(String[] args) {
        int num; int a =0;
        System.out.println("-->Else if 실습<--");
        num = 13 / 2;
        if (num == 6)
            System.out.println("13 / 2 = 6");
        else
            System.out.println("13 / 2 = " + num);

        System.out.println("\n블록 Else if 실습");

        if (a==0){
            System.out.println("a 는 0 이므로");
            System.out.println("이 블록을 통과한다");
        } else {
            System.out.println("a 는 0 이 아니다.");
        }
        System.out.println();
    }
}

package chap03;

public class NestedIf2 {
    public static void main(String[] args) {
        System.out.println("-->nested if 문의 실습<--");
        int i = 2;
        if (i > 0) {
            if (i > 3) {
                System.out.println("i > 0이고 i > 3");
            }else {
                System.out.println("i > 0 이고 i <= 3");
            }
        }else {
            System.out.println("i <= 0");
        }
        System.out.println();
    }
}

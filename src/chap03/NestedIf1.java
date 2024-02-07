package chap03;

public class NestedIf1 {
    public static void main(String[] args) {
        System.out.println("-->nested if 문 실습<--");
        int a = 2;
        if (a == 0) {
            System.out.println("블록 안으로 진입");
            if (a == 2) {
                System.out.println(" a = 0");
            } else {
                System.out.println("a != 2"); // if 문은 이 문장을 수행
            }
        } else {
            System.out.println("a != 0");
        }
        System.out.println();
    }
}

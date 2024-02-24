package chap03;

public class BlockIf {
    public static void main(String[] args) {
        System.out.println("-->블록 if 문의 실습<--");
        int x = 9;
        // x가 4보다 클 경우 오른쪽 문장을 수행
        if (x > 4) System.out.println("단순 if\nx = " + x);

        int value = 8;
        int count = 10;
        int limit = 11;

        // if 조건문이 true인 경우에 수행
        if (++value % 2 != 0 || ++count < limit) {
            System.out.println("\nIf문 안의 값");
            System.out.println(value);
            System.out.println(count);
        }
        System.out.println("\nIf문이 지난 후 값");
        System.out.println(value);
        System.out.println(count);
        System.out.println();
    }
}

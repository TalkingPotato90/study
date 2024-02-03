package chap02;

public class RelativeLogical2 {
    public static void main(String[] args) {
        int i, j;
        boolean b1, b2;
        i = 10;
        j = 11;
        System.out.println("-->조건문을 이용한 관계 연산자 실습<--");
        System.out.println("i = " + i + ", j = " + j);
        // 산술 연산 결과 후 true이면 오른쪽의 출력문을 수행
        if (i < j) System.out.println("i < j");
        if (i <= j) System.out.println("i <= j");
        if (i != j) System.out.println("i != j");
        if (i == j) System.out.println("실행안됨");
        if (i >= j) System.out.println("실행안됨");
        if (i > j) System.out.println("실행안됨");

        b1 = true;
        b2 = false;

        // 논리 연산 결과 후 true이면 오른쪽의 출력문을 수행
        System.out.println("\nb1 = " + b1 + ", b2 + " + b2);
        if (b1 & b2) System.out.println("실행안됨");
        if (!(b1 & b2)) System.out.println("!(b1 & b2)는 true");
        if (b1 | b2) System.out.println("b1 | b2는 true");
        if (b1 ^ b2) System.out.println("b1 ^ b2는 true");
        System.out.println();
    }
}

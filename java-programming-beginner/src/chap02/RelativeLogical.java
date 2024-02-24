package chap02;

public class RelativeLogical {
    public static void main(String[] args) {
        int i = 1, j = 2, k = 3;
        boolean boo;
        System.out.println("-->관계 연산자 실습<--");
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + j);

        // 논리 연산으로 true 또는 false 발생
        System.out.println("j = k : " + (j == k));
        System.out.println("i != k : " + (i != k));
        System.out.println("i < j : " + (i < j));
        System.out.println("i > k : " + (i > k));
        System.out.println("j <= k : " + (j <= k));
        System.out.println("i >= j : " + (i >= j));

        // 관계 연산(<)을 먼저 수행하고 논리 연산(&&)을 수행
        boo = i < j && j < k;
        System.out.println("\n i < j && j < k : " + boo);

        // 관계 연산(== , < , >)을 먼저 수행하고 논리 연산(|| , &&)을 수행
        boo = i == j || j < k && j > k;
        System.out.println(" i == j || j < k && j > k : " + boo);
        System.out.println();
    }
}

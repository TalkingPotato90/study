package chap03;

public class NobodyWhile {
    public static void main(String[] args) {
        int i, j;
        System.out.println("-->몸체 없는 while문의 실습<--");
        i = 100;
        j = 200;
        // i와 j의 중간 값 발생
        // while 문에서 i 값은 1씩 증가, j 값은 1씩 감소시켜 i와 j의 값이 같은 경우 다음 문장 수행
        while (++i < --j) ; // loop 안의 블록이 없다

        System.out.println("i = " + i + ", j = " + j);
        System.out.println();
    }
}

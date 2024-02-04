package chap02;

public class ThreewayOperators {
    public static void main(String[] args) {
        int i, k;

        // i가 0보다 크면 -i를 k에 대입하고, 아니면 i를 k에 대입
        i = 10;
        System.out.println("-->조건 연산자 실습<--");
        k = i < 0 ? -i : i;
        System.out.println(i + " 의 절대값은 " + k + " 입니다.");

        i = -10;
        k = i < 0 ? -i : i;
        System.out.println(i + " 의 절대값은 " + k + " 입니다.");
        System.out.println();
    }
}

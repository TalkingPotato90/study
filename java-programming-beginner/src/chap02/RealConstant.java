package chap02;

public class RealConstant {
    public static void main(String[] args) {
        System.out.println("-->실수형 정수의 표현<--");
        System.out.println("");

        /* float형에 값을 대입할 때는 숫자의 끝에 f를 붙이고,
           0.14143e1은 1.4143 값의 지수 표현값이다 */
        float a = 1.4143f, b = 0.14143e1f;

        /* double의 표현값으로 0.14143E1은 1.4143값의 지수 표현값이다 */
        double c = 0.14143E1;

        // a, b, c의 값을 출력한다
        System.out.println("a(1.4143f)    = " +a);
        System.out.println("b(0.14143e1f) = " +b);
        System.out.println("c(0.14143E1f) = " +c);
        System.out.println("");

        // a와 b를 비교하면 같은 float형이므로 Yes를 출력한다
        if (a==b) System.out.println("a=b 결과 Yes");
        else System.out.println("a=b 결과 No");

        /*
        b와 c를 비교하면 float와 double이므로 저장
        상태가 차이가 나므로 No를 출력한다
        [실수의 경우 부동소수점 사용으로 저장값이 다름]
        */
        if (b==c) System.out.println("b=c 결과 Yes");
        else System.out.println("b=c 결과 No");
    }
}

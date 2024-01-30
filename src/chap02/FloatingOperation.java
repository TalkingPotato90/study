package chap02;

public class FloatingOperation {
    public static void main(String[] args) {
        System.out.println("-->Floating Operation<--");
        int a;
        double b;
        a = 3;
        b = 2.3;
        // a와 b의 값을 출력
        System.out.println("a = " + a + ", b = " + b);
        // a는 int 형이나 b가 double 형이므로 연산할 경우 결과는 double 형으로 변환되어 c 변수에 작성
        double c = a + b;
        System.out.println("c = " + c);
    }
}

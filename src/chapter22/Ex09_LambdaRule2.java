package chapter22;

interface Unit9 {
    // 매개변수 둘, 반환형 int
    int calc(int a, int b);
}

public class Ex09_LambdaRule2 {
    public static void main(String[] args) {
        Unit9 unit;
        unit = (a,b) -> {return a + b;};
        // 매개변수가 두 개이면
        // 앞쪽 소괄호 생략 안 됨
        // unit = a, b -> {return a + b;};

        // 중괄호 안의 구현부가 한 문장이라도 return문이 있다면
        // 뒤쪽 중괄호 생략 안 됨
        // unit = (a,b) -> return a + b;

        int num = unit.calc(10,20);
        System.out.println(num);

        // 중괄호 안의 구현부가 반환문 하나라면
        // 뒤쪽 중괄호와 return 생략 가능
        unit = (a,b) -> a * b;
        System.out.println(unit.calc(10,20));
    }
}

package chapter22;

interface Unit8{
    // 매개변수 하나, 반환형 void
    void move(String s);
}

public class Ex08_LambdaRule1 {
    public static void main(String[] args) {
        Unit8 unit;

        unit = (String s) -> {
            System.out.println(s);
        };
        unit.move("Lambda : 줄임 없는 표현 : 앞 예제 동일");

        // 중괄호 안의 구현부가 한 문장이면 중괄호 생략 가능
        unit = (String s) -> System.out.println(s);
        unit.move("Lambda : 중괄호 생략");

        // 매개 변수가 하나라면 매개 변수형 생략 가능
        unit = (s) -> System.out.println(s);
        unit.move("Lambda : 매개변수 형 생략");

        // 매개 변수가 하나라면 소괄호도 생략 가능
        unit = s -> System.out.println(s);
        unit.move("Lambda : 매개변수 소괄호 생략");
    }
}

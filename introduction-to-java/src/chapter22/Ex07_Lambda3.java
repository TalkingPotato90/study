package chapter22;

interface Unit7 {
    void move(String s);
}

public class Ex07_Lambda3 {
    public static void main(String[] args) {
        // 람다식의 구현
        // 인터페이스형 변수에 대입
        // 람다식이 인터페이스의 메서드에 할당 됨
        Unit7 unit = (String s) -> {
            System.out.println(s);
        };

        unit.move("Lambda : Unit 7");
    }
}

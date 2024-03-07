package chapter22;

interface Unit10{
    // 매개변수 없음, 반환형 String
    String move();
}
public class Ex10_LambdaRule3 {
    public static void main(String[] args) {
        // 매개변수가 없을 때는 형식을 유지하기 위해 빈 소괄호 사용
        // 생략 불가
        Unit10 unit = () ->{
            return "인간형 유닛 이동";
        };

        System.out.println(unit.move());
    }
}

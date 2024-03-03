package chapter17;

public class Ex10_BoxingUnboxing {
    public static void main(String[] args) {
        // 박싱
        // 기본 자료형의 값이 박싱에 의해 클래스 자료형으로 대입
        Integer iObj = Integer.valueOf(10);
        Double dObj = Double.valueOf(3.14);

        // 메서드 호출을 통한 언박싱
        // 래퍼 클래스의 메서드를 통해 기본 자료형의 값을 구해온다
        int num1 = iObj.intValue();
        double num2 = dObj.doubleValue();

        // 값의 출력
        // 래퍼 클래스는 toString()은 오버라이딩 되어있다
        System.out.println(num1 + " : " + iObj);
        System.out.println(num2 + " : " + dObj);
        System.out.println();

        // 래퍼 인스턴스 값의 증가 방법
        // 언박싱으로 값을 구하고 더한 다음에 다시 박싱
        iObj = Integer.valueOf(iObj.intValue() + 10);
        dObj = Double.valueOf(dObj.doubleValue() + 1.2);

        System.out.println(iObj);
        System.out.println(dObj);
    }
}

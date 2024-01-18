package day0110.day0117;

/**
 * OverrideSub는 OverrideSuper의 자식클래스
 */
public class OverrideSub extends OverrideSuper {

    int j;

    public OverrideSub() {
        System.out.println("자식클래스의 생성자");
    }

    public void temp() {
        System.out.println("자식의 method");
    }

    /**
     * Override의 규칙 : 접근지정자는 광의의 접근지정자(protected -> public)로 달라도 되고,
     * 반환형, method명, 매개변수는 동일하게 만든다
     */
    @Override
    public void printI() {
        System.out.println("자식 : " + j+", i : "+ this.i);
    }

    public static void main(String[] args) {
        // 자식클래스로 객체화 : 부모의 모든 자원과 자식의 모든 자원을 사용할 수 있다
        OverrideSub oSub = new OverrideSub();
        oSub.i = 2024; // 부모의 변수
        oSub.j = 1; // 자식의 변수

        oSub.test(); // 부모의 method
        oSub.temp(); // 자식의 method

        oSub.printI(); // 자식이 Override한 method

        System.out.println("----------------------------------------------");
        // is a 관계의 객체화
        OverrideSuper oSuper = new OverrideSub();
        oSuper.i = 12; // 부모의 변수
//        oSuper.j = 40; // 자식의 변수는 사용x

        oSuper.test(); // 부모의 method
//        oSuper.temp(); // 자식의 method 사용x

        oSuper.printI(); // 자식이 Override한 method
    }
}

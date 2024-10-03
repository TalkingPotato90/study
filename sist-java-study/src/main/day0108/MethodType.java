package day0108;

/**
 * method의 형태
 */
public class MethodType {
    // 고정 일 : 반환형 ❌(void), 매개변수 ❌
    public void typeA() {
        System.out.println("고정 일");
    }

    // 가변 일 : 반환형 ❌, 매개변수 ⭕
    public void typeB(int i) {
        System.out.println("가변 일 : " + i);
    }

    // 고정 값 : 반환형 ⭕, 매개변수 ❌
    // 반드시 method의 가장 마지막 줄에 return이 나와야한다
    public int typeC() {
        int i = 2024;
        return i;
    }

    // 가변 값 : 반환형 ⭕, 매개변수 ⭕
    public int typeD(double d) {
        return (int) d;
    }

    public static void main(String[] args) {
        // 객체화 : instance variable, instance method를 사용하기 위해
        // 클래스명 객체명 = new 클래스명();
        MethodType mt = new MethodType();
        // 고정 일 method 호출 => 여러번 호출해도 같은 일 한다
        mt.typeA();
//        mt.typeA();
//        mt.typeA();
//        mt.typeA();

        // 가변 일 method 호출 => 외부 값(arguments)에 대해 다른 일을 수행
        mt.typeB(0);
        mt.typeB(1);
        mt.typeB(8);

        // 고정 값 : 반환형에 일치하는 데이터형으로 변수를 만들고, 반환 값을 저장하여 사용
        int i = mt.typeC();
        System.out.println("고정 값 : " + i);
        i = mt.typeC();
        System.out.println("고정 값 : " + i);

        // 가변 값 : 반환형에 일치하는 데이터형으로 변수를 만들고, 반환 값을 저장하여 사용
        i = mt.typeD(2024.01);
        System.out.println("가변 값 : " +i);
        i = mt.typeD(1.08);
        System.out.println("가변 값 : " +i);
        i = mt.typeD(5.8);
        System.out.println("가변 값 : " +i);

    }

}

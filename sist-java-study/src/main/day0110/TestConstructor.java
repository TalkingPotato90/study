package day0110;

/**
 * 생성자 연습<br>
 * - 생성자는 직접 호출 불가능하고, new(객체생성용키워드)로만 호출 가능<br>
 * - 생성자는 반환형없이 클래스의 이름과 동일하게 생성
 */
public class TestConstructor {
    /**
     * 기본 생성자
     */
    public TestConstructor() { // instance 영역
        System.out.println("default constructor!! 기본 생성자");
    }

    /**
     * 매개변수 있는 생성자
     * @param i
     */
    public TestConstructor(int i){
        System.out.println("overload된 constructor!! 생성자의 다형성");
    }

    public void test(){ // instance method
        System.out.println("나는 test method");
    }

    public void temp(){ // instance method
        System.out.println("나는 temp method");
        test(); // 영역이 같다면 객체명 없이 바로 호출 가능
//        TestConstructor(); // 생성자는 직접 호출 불가능 error
        new TestConstructor();
    }

    public static void main(String[] args) { // static 영역

        // 생성자 호출
        TestConstructor tc = new TestConstructor();

        tc.temp();
        // temp(): instance 영역 main() : static 영역으로 영역이 다르기때문에
        // static영역에서 instance 영역의 method를 호출하려면 객체화를 하여 호출한다

        TestConstructor tc2 = new TestConstructor(2024);
        tc2.temp();
    }
}

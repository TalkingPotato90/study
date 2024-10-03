package day0118;

/**
 * Nested class<br>
 * 안쪽 클래스를 static 변수처럼 사용할 때 (객체화 없이 직접 사용할 때)
 */
public class NestedOutter {
    int outI;
    static int outJ;

    public NestedOutter() {
        System.out.println("바깥클래스의 생성자");
    }

    public void outInsMethod() {
        System.out.println("바깥 클래스의 인스터스 method");
    }

    public static void outStsMethod() {
        System.out.println("바깥 클래스의 static method");
    }

    ///////////////////////////////////nested class 시작 /////////////////////////////////////

    static class Inner { // 생성자를 만들지 않는다 -> 만들 수 없는게 아님
        // 변수나 method는 static으로 만들어 객체없이 사용하도록 한다
        static int inI;

        public static void inMethod() {
            System.out.println("안쪽 크래스의 method");
//            outI = 10; // instance 영역의 변수는 사용할 수 없다
//            outInsMethod(); // instance 영역의 method도 사용할 수 없다
            outJ = 20;
            outStsMethod();
        }
    }

    ///////////////////////////////////nested class 끝 //////////////////////////////////////

    public static void main(String[] args) {
        Inner.inMethod(); // Nested class는 객체 없이 클래스명으로 직접 사용할 수 있다
    }
}

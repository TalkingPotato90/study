package day0118;

/**
 * inner class :<br>
 * - 디자인 클래스 안에서 이벤트를 처리할 때 사용<br>
 * - 안쪽 클래스를 인스턴스 변수처럼 사용할 때
 */
public class Outter {

    int outI;

    public Outter() {
        System.out.println("바깥 클래스의 생성자");
    }

    public void outMethod() {
        System.out.println("바깥 클래스 method");
//        inI = 12; // 안쪽 클래스의 자원을 사용할 수 없다
//        inMethod(); // 안쪽 클래스의 자원을 사용할 수 없다
        Outter.Inner in = /*this.*/new Inner(); // this 생략가능
        in.inI = 12;
        in.inMethod();
    }

    ///////////////////////////////Inner class 시작///////////////////////////////////////////////////////
    public class Inner {
        int inI;

        public Inner() {
            System.out.println("안쪽 클래스의 생성자");
        }

        public void inMethod() {
            System.out.println("안쪽 클래스 method");
            // 바깥 클래스의 자원을 직접 사용가능
            outI=2024;
            System.out.println(outI);
        }
    }
    ///////////////////////////////Inner class 끝////////////////////////////////////////////////////////

    public static void main(String[] args) {
        // 1. 바깥 클래스의 객체화
        Outter out = new Outter();
        out.outMethod();
        // 2. 안쪽 클래스의 객체화 : 바깥클래스명.안쪽클래스명 객체명 = 바깥클래스객체명.new 안쪽생성자();
//        Inner in = new Inner();
//        Outter.Inner in = out.new Inner();

    }
}

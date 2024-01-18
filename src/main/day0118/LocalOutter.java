package day0118;

/**
 * 지역클래스
 */
public class LocalOutter {
    int i;

    public LocalOutter() {
        System.out.println("바깥 클래스의 생성자");
    }

    public void test() {
        System.out.println("바깥 클래스의 method");
    }

    public void method(int paramI, final int paranJ) {
        int locI = 2;
        final int locJ = 15;
        ////////////////////////////////////////지역 클래스 시작//////////////////////////////////////
        class Local {

            int j;

            public Local() {
                System.out.println("지역 클래스의 생성자");
            }

            public void inMethod() {
                System.out.println("지역클래스 method");
                i = 18; // 바깥 클래스의 인스턴스 변수
                System.out.println(i);
                test(); // 바깥 클래스의 method
//                locI = 30; // 지역 클래스 내에서는 final이 있는 것으로 간주
                // 매개변수 : JDK 1.8 이하에서는 final이 있는 변수만 사용가능
                System.out.println(paramI + " / " + paranJ);
                // 지역변수
                System.out.println(locI + " / " + locJ);

            }
        }
        ////////////////////////////////////////지역 클래스 끝////////////////////////////////////////

        Local lo = new Local();
        lo.inMethod();
//        lo.i = 10;
//        System.out.println(lo.i);
    }

    public static void main(String[] args) {
        LocalOutter lo = new LocalOutter();
        lo.method(2024, 1);
    }
}

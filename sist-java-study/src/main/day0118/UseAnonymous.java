package day0118;

import day0110.day0117.Clark;

public class UseAnonymous {
    public void testFly(Fly fly) {
        // fly는 어느 때에는 FlyImple이 되고, 어느 때에는 Clark이 될 수 있다
        System.out.println("추력 : " + fly.thrust());
        System.out.println("양력 : " + fly.lift());
    }

    public static void main(String[] args) {

        // testFly method를 호출해보세요!!
        UseAnonymous ua = new UseAnonymous();
        FlyImpl fi = new FlyImpl();
//        ua.testFly(new Fly()); // 인터페이스는 객체화 될 수 없다
        ua.testFly(new FlyImpl());
        ua.testFly(new Clark());
        // 클래스 파일 (소스코드)를 별도로 만들지 않고, 객체를 생성하여 arguments값을 할당할 때
        ua.testFly(new Fly() {
            @Override
            public String thrust() {
                return "포항항";
            }

            @Override
            public String lift() {
                return "데헷";
            }
        });

    }
}

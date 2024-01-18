package day0110.day0117;

/**
 * 추상클래스 : 직접 객체화 될 수 없다
 */
public abstract class AbstractSuper {
    public AbstractSuper() {
        System.out.println("부모 기본생성자");
    }

    public void test(){
        System.out.println("일반 instance method");
    }

    public abstract String msg();
    public abstract String msg(String msg);




//        public static void main(String[] args) {
//        new AbstractSuper(); // 직접 객체화 될 수 없음
//    }
}

package day0110.day0117;

/**
 * 추상클래스를 구현한 클래스
 * 부모클래스의 모든 abstract method를 Override 해야한다
 */
public class AbstractSub extends AbstractSuper {

    public AbstractSub() {
        System.out.println("자식의 생성자");
    }

    @Override
    public String msg() {
        return "Override한 method!!!";
    }

    @Override
    public String msg(String msg) {
        // 부모의 msg는 추상 메서드로 body가 없어 호출 될 수 없다
//        super.msg("안녕"); // error
        return msg + " 입니다.";
    }

    public static void main(String[] args) {
        // 자식클래스가 생성되면 부모클래스부터 생성된다 (이때에만 객체화 가능)
//        new AbstractSuper();
        AbstractSub as = new AbstractSub();
        System.out.println(as.msg());
        System.out.println(as.msg("수요일"));

    }
}

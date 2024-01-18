package day0118;

/**
 * 추상메서드는 반드시 구현(Override)해야한다
 */
public class SuperInterImpl implements SuperInter{

    @Override
    public String toDay() {
        return "오늘은 목요일 입니다.";
    }

    @Override
    public int getAge() {
        return 20;
    }

    public static void main(String[] args) {

        // 인터페이스는 객체화 될 수 없다
//        SuperInter si = new SuperInter();

        // 구현 클래스가 생성되고 그 주소(객체)를 저장할 수 있다
        SuperInter si = new SuperInterImpl();
        System.out.println(si);
        // si 객체로 호출가능 method Override한 method
        System.out.println(si.toDay());
        System.out.println(si.getAge());
        // JDK1.8 이후 부터는 default method를 호출
        System.out.println(si.defMethod());


    }
}

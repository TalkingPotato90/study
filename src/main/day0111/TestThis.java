package day0111;

public class TestThis {

    int i;
    int j;

    /**
     * this를 사용하지 않고 인스턴스 변수 i에 할당된 값을 설정해 보세요
     *
     * @param i
     */
    public void setI(int i, TestThis t2) {
        t2.i = i;
    }

    public void setJ(int j) {
        System.out.println(this + "번지에서 호출");
        this.j = j;
    }

    public static void main(String[] args) {
        TestThis t = new TestThis();
        t.setI(2024, t);
        System.out.println(t.i);
        t.setJ(2024);
        System.out.println(t.j);

        System.out.println("----------------");
        TestThis t2 =new TestThis();
        System.out.println(t2 + "객체의 주소");
        t2.setJ(1);
    }
}

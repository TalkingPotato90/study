package day0116.sub;

public class ConParent {
    public ConParent() {
        System.out.println("부모의 기본생성자");
    }
    public ConParent(int i) {
        this();
        System.out.println("부모의 인자생성자 " + i);
    }

}

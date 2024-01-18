package day0116.sub;

public class ConChild extends ConParent{
    public ConChild() {
        this(100);
        System.out.println("자식의 기본생성자");
    }

    public ConChild(int i) {
        super(100);
        System.out.println("자식의 인자생성자 " + i);
    }

    public static void main(String[] args) {
       new ConChild();
    }
}

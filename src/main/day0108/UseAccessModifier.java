package day0108;

/**
 * 다른 클래스의 접근지정자의 사용
 */
public class UseAccessModifier {
    public static void main(String[] args) {
        // 같은 패키지의 public이 있는 클래스를 접근
        TestAccessModifier tam = new TestAccessModifier();
        tam.a = 10; // public
        tam.b = 10; // protected
        tam.c = 10; // default
        // tam.d = 10; // private

        // 같은 패키지의 public이 없는 클래스를 접근
        TestAccessModifier tam2 = new TestAccessModifier();
        tam2.a = 10; // public
        tam2.b = 10; // protected
        tam2.c = 10; // default
        // tam.d = 10; // private

    }
}

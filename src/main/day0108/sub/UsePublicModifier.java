package day0108.sub;

import day0108.TestAccessModifier;

/**
 * 패키지가 다른 상태에서 public 접근지정자가 있는 클래스의 접근
 */
public class UsePublicModifier {
    public static void main(String[] args) {

        // TestAccessModifier는 클래스의 접근 지정자가 public 이므로 접근 가능
        TestAccessModifier tam = new TestAccessModifier();
        tam.a = 10; // a 변수는 접근 지정자가 public 이므로 접근 가능
//        tam.b = 10; // b 변수는 접근 지정자가 protected 이므로 접근 불가능
//        tam.c = 10; // c 변수는 접근 지정자가 default 이므로 접근 불가능
//        tam.d = 10; // d 변수는 접근 지정자가 private 이므로 접근 불가능

        // TestAccessModifier2는 클래스의 접근 지정자가 package 이므로 접근 가능
//        TestAccessModifier2 tam2 = new TestAccessModifier2();
    }
}

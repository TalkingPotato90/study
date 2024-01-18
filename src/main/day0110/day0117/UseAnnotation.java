package day0110.day0117;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UseAnnotation {

    @Deprecated
    public void test() {
        System.out.println("오늘은 수요일입니다.");
        Date date = new Date();
        System.out.println(date.getYear());
    }

    @SuppressWarnings({"unused", "rawtypes"})
    public void test2() {
//        @SuppressWarnings("unused")
        int day;
        int j;
        int k;

        List list = new ArrayList();
    }

    // Override는 부모클래스가 가지고 있는 method를 자식 클래스에서 그대로 정의하는것
    @Override
    public String toString() {
        return "오버라이딩한 메서드";
    }

    public static void main(String[] args) {
        UseAnnotation ua = new UseAnnotation();
        ua.test();

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();

        System.out.println(ua); // 내 객체 : 주소
        System.out.println(d); // 자바제공 객체 : 메시지
        System.out.println(sdf); // 자바제공 객체 : 주소

        int i = 10;
        System.out.println(i);
        long l = 20;
        System.out.println(l);
    }
}

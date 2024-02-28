package chapter13;

public class Ex03_CircleUsing {
    public static void main(String[] args) {
        chapter13.com.company.area.Circle c1 = new chapter13.com.company.area.Circle(3.5);
        System.out.println("반지름 3.5 원 넓이 : " + c1.getArea());

        chapter13.com.company.circumference.Circle c2 = new chapter13.com.company.circumference.Circle(3.5);
        System.out.println("반지름 3.5 원 둘레 : " + c2.getCircumference());
    }
}

package chapter17;

public class Ex07_Number {
    public static void main(String[] args) {
        // 자바 4까지의 문법
        // Integer num1 = new Integer(20);
        // 자바 5부터 문법
        Integer num1 = Integer.valueOf(20);
        System.out.println(num1.intValue());
        System.out.println(num1.doubleValue());

        Double num2 = Double.valueOf(3.14);
        System.out.println(num2.intValue());
        System.out.println(num2.doubleValue());
    }
}

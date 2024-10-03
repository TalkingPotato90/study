package day0122;

import java.util.Random;

public class UseRandom {
    public UseRandom() {
        // 1. 객체생성
        Random r = new Random();
        Random r2 = new Random(r.nextLong());

        // 정수의 난수
        int num = r2.nextInt();
        System.out.println("발생한 난수 : " + num);
        System.out.println("범위의 난수 : " + num % 10);
        System.out.println("범위의 난수를 양수로 : " + Math.abs(num % 10));

        int num2 = r2.nextInt(10);
        System.out.println(num2);

        // 실수의 난수
        double d = r2.nextDouble();
        System.out.println("발생 난수 " + d);
        System.out.println("범위의 난수 " + d * 10); // 범위의 난수
        System.out.println("범위의 난수를 정수로 " + (int) (d * 10)); // 범위의 난수에서 정수만

        // 불린의 난수
        boolean b = r2.nextBoolean();
        System.out.println(b);

        System.out.println(r2.nextInt(10));
        System.out.println(r2.nextInt(10));
        System.out.println(r2.nextInt(10));
        System.out.println(r2.nextInt(10));
        System.out.println(r2.nextInt(10));


    }

    public static void main(String[] args) {
        new UseRandom();
    }
}

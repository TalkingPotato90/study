package day0118;

/**
 * java.lang.Math 클래스의 사용<br
 * 객체 샛ㅇ성을 하지 않고, 제공되는 기능을 사용하는 클래스
 */
public class UseMath {
    public UseMath() {
        // Math m = new Math(); // 생성자가 없으므로 객체화 할 수 없다

        double d = Math.abs(-2024.01);
        int i = Math.abs(-2024);

        System.out.println(d + ", " + i);

        d = 10.5;
        long l = Math.round(d);
        System.out.println(d + ", " + l);

        d=10.01;
        System.out.println(Math.ceil(d));

        d = 10.9;
        System.out.println(Math.floor(d));

        d = 10.9;
        System.out.println((int)d);

        System.out.println(Math.random());

        double num = Math.random();
        System.out.println("발생한 난수 : " + num);
        System.out.println("범위의 난수 : " + num * 10);
        System.out.println("정수 범위의 난수 : " + (int)(num * 10));
        // 1 ~ 10 까지 10개의 난수 발생
        System.out.println("1 ~ 10까지 난수 : " + ((int)(num * 10)+1));

        char[] randomUpperCase = new char[8];
        // 위의 배열에 무작위의 알파벳 대문자를 입력
        for (int j = 0; j < randomUpperCase.length; j++) {
            randomUpperCase[j] =(char)((Math.random() * 26)+65);
            System.out.println(randomUpperCase[j]);
        }

    }

    public static void main(String[] args) {
        new UseMath();
    }

}

package day0102;

public class Work0102 {
    public static void main(String[] args) {

        int num1 = 1;
        int num2 = 2;

        System.out.println(num1 > num2 ? num1 : num2);

        int num3 = 6;
        int num4 = 7;
        int num5 = 2;

        System.out.println(num3 < num4 && num3 < num5 ? num3 : (num4 < num3 && num4 < num5 ? num4 : num5));
    }
}

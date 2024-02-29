package chapter14;

public class Ex05_indexOf {
    public static void main(String[] args) {
        String str = "AppleBananaOrange";
        // "a" 위치 반환
        int num1 = str.indexOf("a");
        // 첫 "a" 그다음 "a" 위치 반환
        int num2 = str.indexOf("a", num1+1);

        System.out.println(num1);
        System.out.println(num2);
    }
}

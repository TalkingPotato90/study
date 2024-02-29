package chapter14;

public class Ex06_substring {
    public static void main(String[] args) {
        String str1 = "AppleBananaOrange";
        // "Banana" 시작 위치 반환
        int num1 = str1.indexOf("Banana");
        // "Orange" 시작 위치 반환
        int num2 = str1.indexOf("Orange");

        // 구간 반환
        String str2 = str1.substring(num1,num2);
        System.out.println(str2);

        // 특정 위치 이후 반환
        String str3 = str1.substring(num2);
        System.out.println(str3);
    }
}

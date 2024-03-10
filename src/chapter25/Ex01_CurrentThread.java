package chapter25;

public class Ex01_CurrentThread {
    public static void main(String[] args) {
        // 현재 스레드명 구함
        String name = Thread.currentThread().getName();
        System.out.println("현재 스레드 : " + name);
    }
}

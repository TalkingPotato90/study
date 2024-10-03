package chapter13;

public class Ex02_PackageUse {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.showName();

        // Banana banana = new Banana(); // 패키지가 달라서 그냥 사용시 ERROR
        chapter13.com.study.Banana banana = new chapter13.com.study.Banana();
        banana.showName();
    }
}

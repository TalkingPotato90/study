package chapter25;

// 인터페이스를 구현한 클래스 생성
class MyThread3 implements Runnable{
    // 스레드를 실행하면 해당 스레드에서 run() 호출
    public void run(){
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + i;
        }
        String name = Thread.currentThread().getName();
        System.out.println(name + " : " +sum);
    }
}
public class Ex03_RunnableInterface1 {
    public static void main(String[] args) {
        // 스레드 객체 생성
        // 기본 Thread 클래스를 이용하여 생성
        // 생성자 인수로 구현한 클래스 객체 넘겨주기
        // -> Thread를 상속한 클래스와 Runnable 인터페이스를 구현한 클래스이 차이점
        Thread t = new Thread(new MyThread3());
        t.start();

        System.out.println("main : " + Thread.currentThread().getName());
    }
}

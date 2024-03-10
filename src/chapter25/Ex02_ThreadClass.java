package chapter25;

// Thread를 상속한 클래스 생성
class MyThread2 extends Thread {
    //
    public void run() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + i;
        }
        // 현재 스레드명을 가져온다
        // 스레드를 생성할 때 이름을 지정하지 않아서
        // 일련번호가 붙여진 이름이 반환
        String name = Thread.currentThread().getName();
        System.out.println(name + " : " + sum);
    }
}

public class Ex02_ThreadClass {
    public static void main(String[] args) {
        // 스레드 객체 생성
        MyThread2 t = new MyThread2();
        // run()을 호출하지 않고 start()를 호출해야 run()이 실행된다
        // 스레드를 실행시키는 것이 먼저나오지만
        t.start();
        // 이 코드가 먼저 실행되는 이유는 스레드가 실행되는데 시간이 걸리기 때문
        System.out.println("main : " + Thread.currentThread().getName());
    }
}

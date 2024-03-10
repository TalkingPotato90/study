package chapter25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex08_ThreadPool1 {
    public static int money = 0;

    public static void main(String[] args) {
        // 스레드에 시킬 작업
        Runnable task1 = () -> {
            for (int i = 0; i < 10000; i++) {
                money++;
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + " : " + money);
        };

        // 스레드에 시킬 작업
        Runnable task2 = () -> {
            for (int i = 0; i < 10000; i++) {
                money--;
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + " : " + money);
        };

        // 스레드풀 생성
        // 하나의 스레드만 전달받아 처리 가능
        ExecutorService pool = Executors.newSingleThreadExecutor();
        // 스레드 풀에 작업을 전달
        pool.submit(task1);
        pool.submit(task2);

        System.out.println("End " + Thread.currentThread().getName());

        // 스레드 풀과 그 안에 있는 스레드의 소멸
        pool.shutdown();

    }
}

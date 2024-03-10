package chapter25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount{
    // 동기화에 사용할 ReentrantLock 클래스 객체 생성
    ReentrantLock myLock = new ReentrantLock();
    int money = 0;

    public void deposit(){
        // 명시적으로 동기화 시작점 설정
        myLock.lock();
        money++;
        // 명시적으로 동기화 끝점 설정
        myLock.unlock();
    }

    public void withdraw(){
        myLock.lock();
        money--;
        myLock.unlock();
    }

    public int balance(){
        return money;
    }
}

public class Ex11_ReentrantLock{
    // 여러 스레드에서 사용할 객체를 스태틱 영역에 생성
    public static BankAccount account = new BankAccount();

    public static void main(String[] args) throws InterruptedException{
        Runnable task1 = () ->{
            for (int i = 0; i < 10000; i++) {
                account.deposit();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 10000; i++) {
                account.withdraw();
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(task1);
        pool.submit(task2);

        pool.shutdown();
        pool.awaitTermination(100, TimeUnit.SECONDS);

        System.out.println(account.balance());
    }
}

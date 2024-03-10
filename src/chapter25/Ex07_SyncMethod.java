package chapter25;

public class Ex07_SyncMethod {
    public static int money = 0;
    public synchronized static void deposit(){
        money++;
    }

    public synchronized static void withdraw(){
        money--;
    }

    public static void main(String[] args) throws InterruptedException{
        Runnable task1 = () ->{
            for (int i = 0; i < 10000; i++) {
                deposit();
            }
        };

        Runnable task2 = () ->{
            for (int i = 0; i < 10000; i++) {
                withdraw();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(money);
    }
}

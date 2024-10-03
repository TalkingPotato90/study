package chapter25;

public class Ex04_RunnableInterface2 {
    public static void main(String[] args) {
        // Runnable 변수 생성 및 람다식 대입
        Runnable task = () ->{
            try {
                // 스레드의 실행이 3초동안 일시정지 했다가 다시 진행
                Thread.sleep(3000);
            }catch (Exception e){ }

            int sum =0;
            for (int i = 0; i < 10; i++) {
                sum = sum + i;
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + " : " + sum);
        };

        // 생성자의 인수로 람다식을 대입한 변수를 넘겨준다
        Thread t = new Thread(task);
        t.start();

        System.out.println("main : " + Thread.currentThread().getName());
    }
}

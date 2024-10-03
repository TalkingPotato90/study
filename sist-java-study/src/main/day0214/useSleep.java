
package day0214;

// 1. Runnable Interface를 구현
public class useSleep implements Runnable {

	// 2. run method Override (추상method 강제 override)
	@Override
	public void run() {
		// 3. Thread로 처리할 코드 정의 (동시에 실행되어야 할 코드)
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	// end catch
		}	// end for
	}	// run
	
	public static void main(String[] args) {
		// 4. 자식클래스 객체화
		useSleep us = new useSleep();
		// 5. Thread와 has a 관계
		Thread t = new Thread(us);
		// 6. start() 호출
		t.start();
	}	// main

}	// class
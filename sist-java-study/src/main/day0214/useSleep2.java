package day0214;

public class useSleep2 implements Runnable {

	@Override
	public void run() {
		System.out.print("loading");
		try {
			for(int i = 0; i < 15; i++) {
				System.out.print(" . ");
					Thread.sleep((long)(Math.random()*1000));
					// Random r = new Random();
					// Thread.sleep(r.nextInt(10)*100);
			}	// end for
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("finish");
	}	// run

	public static void main(String[] args) {
		useSleep2 us2 = new useSleep2();
		Thread t = new Thread(us2);
		t.start();
	}	// main

}	// class
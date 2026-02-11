package com.multiThreading.synchronisation;

public class ThreadSynchronisation {

	public static void main(String[] args) throws InterruptedException {
		
		SyncMethodClass smc = new SyncMethodClass();
//		SyncMethodClass smc2 = new SyncMethodClass();
		Runnable r1 = () -> {
				System.out.println("child Thread t1 entering r1 object-");
				smc.m1();
		};
		Runnable r2 = () -> {
			
				System.out.println("child Thread t2 entering r2 object -");
				smc.m2();	// with this smc objects lock is occupied by one of the thread so other will execute after first thread got completes
//				smc2.m2();  // with this both objects (smc, smc2)lock are different so both thread execute simultaneously
			
		};
		Thread t1 = new Thread(r1);
		t1.start();

		Thread t2 = new Thread(r2);
		t2.start();
		
		Thread t3 = new Thread(()->smc.m3());
		t3.start();

	}

}

class SyncMethodClass {
	
	public synchronized void m1() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("sync m1 method call by - "+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("i got interrupted");
		}
	}
	
	public synchronized void m2() {
			for (int i = 1; i <= 10; i++) {
				System.out.println("sync m2 method call by - "+Thread.currentThread().getName());
			}
	}
	
	public void m3() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("normal m3 method call by - "+Thread.currentThread().getName());
		}
}
}
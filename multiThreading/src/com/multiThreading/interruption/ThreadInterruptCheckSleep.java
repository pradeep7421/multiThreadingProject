package com.multiThreading.interruption;


public class ThreadInterruptCheckSleep {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread2 t = new MyThread2();
		t.start();
		t.interrupt();
		System.out.println("End of main method");
				
	}

}

class MyThread2 extends Thread {
	@Override
	public void run() {

		for (int i = 1; i < 1000; i++) {
			System.out.println("I am lazy Thread - "+i);
		}
		System.out.println("i want to sleep");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("i got interrupted");
		}
	}
}
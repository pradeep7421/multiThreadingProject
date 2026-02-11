package com.multiThreading.interruption;


public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread t = new MyThread();
		t.start();
		t.interrupt();
		System.out.println("End of main method");
				
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("I am lazy Thread");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("i got interrupted");
		}
	}
}
package com.multiThreading.yieldAndJoin;

public class TwoThreadJoinT1wait {

	public static void main(String[] args) {
		
		MyThread1 t1 = new  MyThread1();
		MyThread22 t2 = new  MyThread22();
		MyThread1.t2= t2;
		t1.start();
		t2.start();

	}

}

class MyThread1 extends Thread{
	public static MyThread22 t2;
	@Override
	public void run() {
	
		for(int i = 1;i<=10;i++) {
			System.out.println(i+" - thread 1 run method current thread name - "+Thread.currentThread().getName());
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class MyThread22 extends Thread{
	@Override
	public void run() {
	
		for(int i = 1;i<=10;i++) {
			System.out.println(i+" - thread 2 run method current thread name - "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}


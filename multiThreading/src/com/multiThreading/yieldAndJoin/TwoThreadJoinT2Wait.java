package com.multiThreading.yieldAndJoin;

public class TwoThreadJoinT2Wait {

	public static void main(String[] args) {
		
		MyThread11 t1 = new  MyThread11();
		MyThread222 t2 = new  MyThread222();
		MyThread222.t1= t1;
		t1.start();
		t2.start();

	}

}

class MyThread11 extends Thread{
	@Override
	public void run() {
	
		for(int i = 1;i<=10;i++) {
			System.out.println(i+" - thread 1 run method current thread name - "+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class MyThread222 extends Thread{
	public static MyThread11 t1;
	@Override
	public void run() {
	
		for(int i = 1;i<=10;i++) {
			System.out.println(i+" - thread 2 run method current thread name - "+Thread.currentThread().getName());
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}


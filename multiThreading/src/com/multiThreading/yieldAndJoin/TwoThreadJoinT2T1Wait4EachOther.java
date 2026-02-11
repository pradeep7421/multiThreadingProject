package com.multiThreading.yieldAndJoin;

public class TwoThreadJoinT2T1Wait4EachOther {

	public static void main(String[] args) {
		
		MyThread111 t1 = new  MyThread111();
		MyThread2222 t2 = new  MyThread2222();
		MyThread2222.t1= t1;
		MyThread111.t2=t2;
		t1.start();
		t2.start();

	}

}

class MyThread111 extends Thread{
	public static MyThread2222 t2;
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

class MyThread2222 extends Thread{
	public static MyThread111 t1;
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


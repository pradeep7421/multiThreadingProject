package com.multiThreading.yieldAndJoin;

public class ChildThreadJoin {

	public static void main(String[] args) {
		
		MyThread3 t1 = new  MyThread3();	
		t1.start();
		try {
//			t1.join();
			t1.join(1000);
//			t1.join(1000,100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1;i<=5;i++) {
			System.out.println(i+"- Main thread run method current thread name - "+Thread.currentThread().getName());
		}
	}

}

class MyThread3 extends Thread{
	@Override
	public void run() {
	
		for(int i = 1;i<=10;i++) {
			System.out.println(i+" - Child thread run method current thread name - "+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


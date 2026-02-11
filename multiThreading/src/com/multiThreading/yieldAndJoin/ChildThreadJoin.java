package com.multiThreading.yieldAndJoin;

public class ChildThreadJoin {

	public static void main(String[] args) {
		
		MyThread3 t2 = new  MyThread3();	
		t2.start();
		try {
//			t2.join();
			t2.join(1000);
//			t2.join(2000,100);
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
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


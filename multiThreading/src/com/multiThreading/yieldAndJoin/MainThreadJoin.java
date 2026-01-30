package com.multiThreading.yieldAndJoin;

public class MainThreadJoin {

	public static void main(String[] args) {
		
		MyThread2 t1 = new  MyThread2();	
		MyThread2.mainThread = Thread.currentThread();
		t1.start();
		for(int i = 1;i<=50;i++) {

			System.out.println(i+"- Main thread run method current thread name - "+Thread.currentThread().getName());
		}
	}

}

class MyThread2 extends Thread{
	public static Thread mainThread;
	@Override
	public void run() {
		for(int i = 1;i<=5;i++) {
			System.out.println(i+" - Child thread run method current thread name - "+Thread.currentThread().getName());
			
			try {
				mainThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


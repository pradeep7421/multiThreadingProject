package com.multiThreading.yieldAndJoin;


public class ThreadYield {

	public static void main(String[] args) {
		
		MyThread t1 = new  MyThread();	
		t1.start();
		for(int i = 1;i<=5;i++) {

			System.out.println(i+"- Main thread run method current thread name - "+Thread.currentThread().getName());
		}
	}

}

class MyThread extends Thread{
	
	@Override
	public void run() {
		for(int i = 1;i<=5;i++) {
			System.out.println(i+" - Child thread run method current thread name - "+Thread.currentThread().getName());
			
			//some platforms won't support 
			Thread.yield();
		}
	}
}

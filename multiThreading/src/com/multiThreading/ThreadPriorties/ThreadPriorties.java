package com.multiThreading.ThreadPriorties;

public class ThreadPriorties {

	public static void main(String[] args) {
		// Priorties can be set from range 1 to 10 and 10 is max priority
		//Default priority only for main thread is 5 and for all other thread default priority will be inherited from parent to child
		System.out.println("main thread default priority -"+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(1);
		System.out.println("main thread after setting priority -"+Thread.currentThread().getPriority());
		
		MyThread t1 = new  MyThread();	
		System.out.println("t1 thread default priority -"+t1.getPriority());
		t1.setPriority(10);
		System.out.println("t1 thread after setting priority -"+t1.getPriority());
		t1.start();


		for(int i = 0;i<10;i++) {
			System.out.println("Main thread run method current thread name - "+Thread.currentThread().getPriority());
		}

	}

}

class MyThread extends Thread{
	
	@Override
	public void run() {
		for(int i = 0;i<10;i++) {
		System.out.println("Child thread run method current thread name - "+Thread.currentThread().getPriority());

		}
	}
}

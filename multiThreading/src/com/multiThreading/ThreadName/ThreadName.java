package com.multiThreading.ThreadName;

public class ThreadName {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("main Thread updated");
		System.out.println(Thread.currentThread().getName());
		
		MyThread t1 = new  MyThread();
		t1.start();
		System.out.println("this line executed by -"+Thread.currentThread().getName());
		System.out.println(t1.getName());
		Thread t2 = new  Thread("Thread- 33");
		System.out.println("t2 Thread name  - "+t2.getName());
		
		MyThread t3 = new  MyThread();
		System.out.println("t3 Thread name - "+t3.getName());
		t3.setName("t3 thread ");
		System.out.println("t3 Thread updated name  - "+t3.getName());
		System.out.println(10/0);
		

	}

}

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Child thread run method current thread name - "+Thread.currentThread().getName());
		System.out.println("this line executed by in run method -"+Thread.currentThread().getName());

	}
}

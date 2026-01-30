package com.multiThreading.ThreadCreation;

public class CreateThreadByRunnableInterface {

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		

		
		Thread t1 = new Thread();
		Thread t2 = new Thread(r);
		
		//case1
		t1.start(); // A new thread is created and it internally calls Thread class run() method which has empty implemetation which does not perform any task
		//case2
		t1.run();  // no new thread is created and main thread calls run() method like normal method call
		//case3
		t2.start();	// A new thread is created and it internally calls run() method which is MyRunnable class implemetation which perform our task
		//case4
		t2.run();   // no new thread is created and main thread calls Thread class run() method which internally calls runnable implemented run method like normal method call
		//case5
		//r.start(); //Compile time error as there is no start method in runnable interface
		r.run(); // No new thread is created ,MyRunnable run method will be called just like normal method call by main thread
	}

}

class MyRunnable implements Runnable{
	
	@Override
	public void run() {
		for(int i =0;i<=10;i++) {
			System.out.println("Child thread - print statement number -"+ i);
		}
	}
}

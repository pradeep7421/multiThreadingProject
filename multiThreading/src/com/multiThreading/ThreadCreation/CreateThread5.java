package com.multiThreading.ThreadCreation;

public class CreateThread5 {

	public static void main(String[] args) {
	
		MyThread5 thread = new MyThread5();
		thread.start();   //MyThread5 start() will be called like normal method call by main thread so no new thread will be created 
		
			System.out.println("main thread  -" );	
	}

}

class MyThread5 extends Thread{
	
//	@Override
//	public void start() {	//will be called like normal method call by main thread
//			System.out.println("start method -----------");
//	}
	
	@Override
	public void start() {	//will be called like normal method call by main thread
		super.start();  //Thread class start() will be called by main thread so a new thread will be created which calls run method of this class
		System.out.println("start method ----------- ");
	}
	@Override
	public void run() {  // this run() wont be called by start method if we override start method
			System.out.println("Run method -----------");
	}
}

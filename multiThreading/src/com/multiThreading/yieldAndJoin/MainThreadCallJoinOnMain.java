package com.multiThreading.yieldAndJoin;

public class MainThreadCallJoinOnMain {

	public static void main(String[] args) throws InterruptedException {
		
	Thread.currentThread().join();
	System.out.println("main thread");
	}

}

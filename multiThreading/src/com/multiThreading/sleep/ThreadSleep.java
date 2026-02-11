package com.multiThreading.sleep;


public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 1;i<=5;i++) {
		System.out.println("slide -"+i);
		Thread.sleep(2000);
		}
	}

}

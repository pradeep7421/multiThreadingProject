package com.multiThreading.ThreadCreation;

public class ThreadCaseStudy {

	public static void main(String[] args) {
		MyRunnable5 r = new  MyRunnable5();
		
		//---------------OR without implementing Runnable 
//		Runnable myRunnable = ()->{
//			for(int i =0;i<=10;i++) {
//				System.out.println("Child thread  - print statement number -"+ i);
//			}
//		};
		
//		Thread thread1 = new Thread();
//		thread1.start(); // it internally calls Thread class run() method which has empty implemetation which does not perform any task
		
		
		//To perform task runnable object needs to be passed in Thread constructor so it can execute run medthod implemeted by us
		Thread thread = new Thread(r);
		thread.start();
		for(int i =0;i<=10;i++) {
			System.out.println("Parent thread  - print statement number -"+ i);
		}
		
	}

}

class MyRunnable5 implements Runnable{
	
	@Override
	public void run() {
		for(int i =0;i<=10;i++) {
			System.out.println("Child thread - print statement number -"+ i);
		}
	}
}

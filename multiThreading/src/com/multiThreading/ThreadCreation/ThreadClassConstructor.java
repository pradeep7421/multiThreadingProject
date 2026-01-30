package com.multiThreading.ThreadCreation;

public class ThreadClassConstructor {

	public static void main(String[] args) {
		MyRunnable6 runnable = new  MyRunnable6();
		String threadName ="Thread";
		Thread t1 = new Thread();
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(threadName+3);
		Thread t4 = new Thread(runnable,threadName+4);
		
		
		ThreadGroup threadGroup = new ThreadGroup("g1");
		
		Thread t5 = new Thread(threadGroup,threadName+5);
		Thread t6 = new Thread(threadGroup,runnable);
		Thread t7 = new Thread(threadGroup,runnable,threadName+7);
		
		long stackTrace = 11;
		Thread t8 = new Thread(threadGroup,runnable,threadName+8,stackTrace);

	}

}

class MyRunnable6 implements Runnable{
	
	@Override
	public void run() {
		for(int i =0;i<=10;i++) {
			System.out.println("Child thread - print statement number -"+ i);
		}
	}
}

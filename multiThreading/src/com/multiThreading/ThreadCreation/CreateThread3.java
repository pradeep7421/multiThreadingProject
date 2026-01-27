package com.multiThreading.ThreadCreation;

public class CreateThread3 {

	public static void main(String[] args) {
//		MyRunnable2 myRunnable2 = new MyRunnable2();
		
		//---------------OR without implementing Runnable 
		Runnable myRunnable = ()->{
			for(int i =0;i<=10;i++) {
				System.out.println("Child thread  - print statement number -"+ i);
			}
		};
		
		Thread thread = new Thread(myRunnable);
		thread.start();
		for(int i =0;i<=10;i++) {
			System.out.println("Parent thread  - print statement number -"+ i);
		}
		
	}

}

class MyRunnable2 implements Runnable{
	
	@Override
	public void run() {
		for(int i =0;i<=10;i++) {
			System.out.println("Child thread - print statement number -"+ i);
		}
	}
}

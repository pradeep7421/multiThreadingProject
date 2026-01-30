package com.multiThreading.ThreadCreation;

public class DurgaApproachToStartThread {

	public static void main(String[] args) {
		MyThread2 t = new  MyThread2();
		Thread t1 = new Thread(t);
		t1.start();
		System.out.println("main Thread .......");

	}

}

class MyThread2 extends Thread{
	
	@Override
	public void run() {
			System.out.println("Child thread - print statement number ");
	}
}

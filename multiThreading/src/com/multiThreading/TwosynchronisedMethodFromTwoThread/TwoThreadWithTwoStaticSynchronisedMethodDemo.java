package com.multiThreading.TwosynchronisedMethodFromTwoThread;

public class TwoThreadWithTwoStaticSynchronisedMethodDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Display d = new Display();
		MyThreadDemo1 t0 = new MyThreadDemo1(d);
		t0.start();
		MyThreadDemo2 t1 = new MyThreadDemo2(d);
		t1.start();		
	}

}
class MyThreadDemo1 extends Thread {
	private Display d;
	
	public MyThreadDemo1(Display d) {
		super();
		this.d = d;
	}
	
	public void run() {
			d.displayNum();
		}
}

class MyThreadDemo2 extends Thread {
	private Display d;
	
	public MyThreadDemo2(Display d) {
		super();
		this.d = d;
	}
	
	public void run() {
	d.displayChar();
	}
}
class Display {
	
	public static synchronized void displayNum() {
		
			for (int i = 1; i <= 10; i++) {
				System.out.print(i);
			try {		
				Thread.sleep(500);
			}catch (InterruptedException e) {}
		}
	}
	public static synchronized void displayChar() {
		
		for (int i = 65; i <= 75; i++) {
			System.out.print((char)i);
			try {		
				Thread.sleep(500);
			}catch (InterruptedException e) {}
		}
	}
	

}
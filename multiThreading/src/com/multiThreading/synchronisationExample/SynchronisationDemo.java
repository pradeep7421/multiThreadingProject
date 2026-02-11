package com.multiThreading.synchronisationExample;

public class SynchronisationDemo {

	public static void main(String[] args) throws InterruptedException {
		
//		Display d = new Display();
//		MyThreadDemo t0 = new MyThreadDemo(d,"Ravi");
//		t0.start();

//		MyThreadDemo t1 = new MyThreadDemo(d,"Rohan");
//		t1.start();
		
//		MyThreadDemo t2 = new MyThreadDemo(d,"Aakash");
//		t2.start();
//		
//		MyThreadDemo t3 = new MyThreadDemo(d,"Aakash");
//		t3.start();
		
		Display d = new Display();
		MyThreadDemo t5 = new MyThreadDemo(d,"Ravi");
		t5.start();
		Display d2 = new Display();
		MyThreadDemo t4 = new MyThreadDemo(d2,"Rahul");
		t4.start();

	}

}
class MyThreadDemo extends Thread {
	private Display d;
	private String name;
	
	public MyThreadDemo(Display d, String name) {
		super();
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		
		if(Thread.currentThread().getName().equals("Thread-2")) {
			d.m2();
		}else if(Thread.currentThread().getName().equals("Thread-3")) {
			d.m3();
		}else {
			d.wish(name);
		}
	}
}
class Display {
	
	public synchronized void wish(String name) {
		
			for (int i = 1; i <= 10; i++) {
				System.out.print("Good Morning -");
//			try {		
//				Thread.sleep(1000);
//			}catch (InterruptedException e) {}
			System.out.println(name);
		}
	}
	
	public synchronized void m2() {
			for (int i = 1; i <= 10; i++) {
				System.out.println("sync m2 method call by - "+Thread.currentThread().getName());
			}
	}
	
	public void m3() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("normal m3 method call by - "+Thread.currentThread().getName());
		}
}
}
package com.multiThreading.synchronisationExample;

public class StaticSynchronisationDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Display2 d = new Display2();
		MyThreadDemo2 t0 = new MyThreadDemo2(d,"Ravi");
		t0.start();
		Display2 d2 = new Display2();
		MyThreadDemo2 t1 = new MyThreadDemo2(d2,"Rohan");
		t1.start();
		
		MyThreadDemo2 t2 = new MyThreadDemo2(d,"Sohan");
		t2.start();
		
		MyThreadDemo2 t3 = new MyThreadDemo2(d,"kavita");
		t3.start();
		
		MyThreadDemo2 t4 = new MyThreadDemo2(d,"Naina");
		t4.start();
		
	}

}
class MyThreadDemo2 extends Thread {
	private Display2 d;
	private String name;
	
	public MyThreadDemo2(Display2 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		
		if(Thread.currentThread().getName().equals("Thread-0")) {
			d.wish(name);
		}else if(Thread.currentThread().getName().equals("Thread-1")) {
			d.m1();
		}else if(Thread.currentThread().getName().equals("Thread-2")) {
			d.m2();
		}else if(Thread.currentThread().getName().equals("Thread-3")) {
			d.m3();
		}else {
			d.m4();
		}
	}
}
class Display2 {
	
	public static synchronized void wish(String name) {
		
			for (int i = 1; i <= 10; i++) {
				System.out.print("Good Morning -");
//			try {		
//				Thread.sleep(1000);
//			}catch (InterruptedException e) {}
			System.out.println(name);
		}
	}
	public static synchronized void m1() {
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("m1 method executed -");
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
	public static void m4() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("normal static m4 method call by - "+Thread.currentThread().getName());
		}
}
}
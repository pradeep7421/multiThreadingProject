package com.multiThreading.synchronisedBlock;

public class SynchronisedBlockDemo {

	public static void main(String[] args) throws InterruptedException {
		//regular output  as threads will be executed one by one
//		Display d = new Display();
//		MyThreadDemo t0 = new MyThreadDemo(d,"Dhoni");  //lock of d
//		t0.start();
//		MyThreadDemo t1 = new MyThreadDemo(d,"Yuvraj");	//lock of d
//		t1.start();
		
		
		//irregular output first thread and second thread both execute simultaneously
		Display d1 = new Display();
		MyThreadDemo t0 = new MyThreadDemo(d1,"Dhoni");  //lock of d1
		t0.start();
		Display d2 = new Display();
		MyThreadDemo t1 = new MyThreadDemo(d2,"Yuvraj");  //lock of d2
		t1.start();
	}

}

class MyThreadDemo extends Thread {
	private Display d;
	private String name;
	
	public MyThreadDemo(Display d,String name) {
		super();
		this.d = d;
		this.name=name;
	}
	
	public void run() {
	d.wish(name);
	}
}
class Display {
	
	public void wish(String name) {
		//10000 lines of code
		int x =100;
		
		
//		synchronized(x) {  //Throws compile time error as primitive not allowed only reference and class are allowed
//		synchronized(this) {  // regular output for same object && irregular output for different object
		synchronized(Display.class) {	  // regular output for class level lock
			for (int i = 1; i <= 10; i++) {
				System.out.print("Good Morning -");
			try {		
				Thread.sleep(500);
			}catch (InterruptedException e) {}
			System.out.println(name);
			}
		}
			
			//10000 lines of code
	}
}
package com.multiThreading.synchronisedBlock;

public class MultipleLocksInSyncBlockDemo {

	public static void main(String[] args) throws InterruptedException {
		DisplayML d = new DisplayML(new Y(),new Z());
//		MyThreadDemoML t0 = new MyThreadDemoML(d, "Dhoni"); // lock of d1
//		t0.start();
//		MyThreadDemoML t1 = new MyThreadDemoML(d, "Yuvraj"); // lock of d2
//		t1.start();
		
		
		Thread t3 = new Thread(()->{
			try {
				d.m2("Thread 3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t3.start();
		Thread t4 = new Thread(()->{
			try {
				d.m2("Thread 4");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t4.start();
	}

}

class MyThreadDemoML extends Thread {
	private DisplayML d;
	private String name;

	public MyThreadDemoML(DisplayML d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	public void run() {
		try {
			d.m1(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class DisplayML {
	
	private Y y;
	private Z z;
	

	public DisplayML(Y y, Z z) {
		super();
		this.y = y;
		this.z = z;
	}


	public synchronized void m1(String name) throws InterruptedException {
		// 10000 lines of code
		
		//Thread has lock of display object	
			synchronized (y) {  
				//Thread has lock of display object and Y object
				synchronized (z) {
					//Thread has lock of display object , Y object and Z object
					for(int i=1;i<11;i++) {
						System.out.println("Good Morning -"+ name);
						Thread.sleep(1000);
					}
					}
				}
			// 10000 lines of code
			}



public void m2(String name) throws InterruptedException {
	// 10000 lines of code
	
		synchronized (y) {  
			//Thread has lock of display object and Y object
			synchronized (z) {
				//Thread has lock of display object , Y object and Z object
				for(int i=1;i<11;i++) {
					System.out.println("Good Morning -"+ name);
					Thread.sleep(1000);
				}
				}
			}
		// 10000 lines of code
		}

}
class Y {

}

class Z {

}
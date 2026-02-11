package com.multiThreading.InterThreadCommunication;

//Assuming main thread gets first priority
public class AlternateThreadPrintStatementByWaitNotify {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadB1 b1 = new ThreadB1();
		b1.start();
		synchronized (b1) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("main Thread trying to call wait method ");
					b1.wait();
				System.out.println("main Thread prints statement -" + i);
					
					//if(i<=10) {
						System.out.println("main Thread trying to call notify method ");
						b1.notify();
					
				//	}

				}
			}
		}
	
}

class ThreadB1 extends Thread {
	public void run() {
		try {
			Thread.sleep(0,1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("child Thread trying to call notify method");
				this.notify();
				System.out.println("child Thread prints statement -" + i);
				try {
					System.out.println("child Thread trying to call wait method");
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			
			}
		}
}



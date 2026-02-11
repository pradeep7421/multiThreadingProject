package com.multiThreading.InterThreadCommunication;

//Assuming child thread completes first execution
public class AlternateThreadPrintStatementByWaitNotifyChildThreadFirst {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadB11 b11 = new ThreadB11();
		b11.start();
		Thread.sleep(0,1);
		synchronized (b11) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("main Thread trying to call wait method ");
					b11.wait();
				System.out.println("main Thread prints statement -" + i);
					
					if(i<=10) {
						System.out.println("main Thread trying to call notify method ");
						b11.notify();
					
					}

				}
			}
		}
	
}

class ThreadB11 extends Thread {
	public void run() {
		synchronized (this) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("child Thread trying to call notify method");
				this.notify();
				System.out.println("child Thread prints statement -" + i);
				try {
					System.out.println("child Thread trying to call wait method");
	//				this.wait(); //gives infinite waiting
					this.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			
			}
		}
}



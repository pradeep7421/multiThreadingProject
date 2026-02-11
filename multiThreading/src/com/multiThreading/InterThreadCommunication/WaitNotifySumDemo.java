package com.multiThreading.InterThreadCommunication;

public class WaitNotifySumDemo {
	PostBox postBox = new PostBox();
	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();
		synchronized (b) {
			System.out.println("main thread trying to call wait method-");
			b.wait();
			System.out.println("total sum of 100 nos is -"+b.getTotal());
		}
	}
}

class ThreadB extends Thread{
	private int total;
	public void run() {
		synchronized (this) {
		System.out.println("Child Thread starts calculation");
			for(int i =1;i<=100;i++) {
				total= total+i;	
			}
			System.out.println("Child Thread trying to give notification-----");
			this.notify();
		}
	}
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
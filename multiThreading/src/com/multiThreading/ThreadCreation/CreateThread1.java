package com.multiThreading.ThreadCreation;

public class CreateThread1 {

	public static void main(String[] args) {
		Mythread mythread = new Mythread();
//		mythread.start();  //this is responsible to execute run method
		mythread.run();  // normal method call by main thread no new thread is created
		
		mythread.run(10); //calling overloaded method like normal method call from main thread 
		for(int i =0;i<=10;i++) {
			System.out.println("Parent thread  - print statement number -"+ i);
		}
		
	}

}

class Mythread extends Thread{
	
	@Override
	public void run() {   //start() always calls run method without arguments method 
		for(int i =0;i<=10;i++) {
			System.out.println("Child thread - print statement number -"+ i);
		}
	}
	
	public void run(int num) { //this methods needs to be called explicitly like normal method call
		for(int i =0;i<=10;i++) {
			System.out.println("Child thread - print statement number -"+ i);
		}
	}
}

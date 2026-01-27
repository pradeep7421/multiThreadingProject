package com.multiThreading.ThreadCreation;

public class CreateThread4 {

	public static void main(String[] args) {
		
		MyThread4 thread = new MyThread4();
		thread.start();
		for(int i =0;i<=10;i++) {
			System.out.println("Parent thread  - print statement number -"+ i);
		}
		
//		thread.start();  //second time not allowed to restart same thread
		
	}

}

class MyThread4 extends Thread{
	
	//HIGHLY RECOMMENDED TO OVERRIDE RUN() IF NOT OVERRIIDEN OUR JOB WILL NOT BE DEFINED SO WE ARE MISUSING THREAD CONCEPT
	//If run methond is not overridden so jvm calls Thread class run method which is empty implementation
}

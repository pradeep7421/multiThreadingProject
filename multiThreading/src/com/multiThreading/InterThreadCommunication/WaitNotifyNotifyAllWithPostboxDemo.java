package com.multiThreading.InterThreadCommunication;

public class WaitNotifyNotifyAllWithPostboxDemo {
	
	public static void main(String[] args) {
//		PostBox postBox = new PostBox();
//		Thread mT1 = new Thread(()->{
//			try {
//				synchronized (postBox) {
//					System.out.println("mt1 Thread calling wait on postbox object");
//					postBox.wait();
//					System.out.println("mt1 Thread received notification from other thread and msg as -"+postBox.getMsg());
//				}
//			} catch (InterruptedException e) {}
//		});
//		mT1.start();
//		
//		Thread mT2 = new Thread(()->{
//			try {
//				synchronized (postBox) {
//					System.out.println("mt2 Thread calling wait on postbox object");
//					postBox.wait();
//					System.out.println("mt2 Thread received notification from other thread and msg as -"+postBox.getMsg());
//				}
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//		mT2.start();
//		
//		Thread mTnotify = new Thread(()->{
//			try {
//				Thread.sleep(0,1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			synchronized (postBox) {
//				postBox.setMsg("important msg yo call for emergency -------");
//				System.out.println("notify call");
//				postBox.notifyAll();
//			}
//		});
//		mTnotify.start();
		PostBox postBox = new PostBox();
		MyWaitThread t1Wait = new MyWaitThread(postBox);
		MyWaitThread t2Wait = new MyWaitThread(postBox);
		MyNotifyThread t3Notify = new MyNotifyThread(postBox, "important msg To call for emergency -------");
		
		t1Wait.start();
		t2Wait.start();
		t3Notify.start();
	
	}
}

class MyWaitThread extends Thread{
	private PostBox postBox;
	public MyWaitThread(PostBox postBox) {
		this.postBox = postBox;
	}
	
	public void run() {
					
		System.out.println(Thread.currentThread().getName()+"-getting msg before notify call -"+postBox.getMsg());
		synchronized (postBox) {
			
			try {
				if(postBox.getMsg() != null) {
					postBox.setMsg(null);
				}
				System.out.println(Thread.currentThread().getName() + " - tries to call wait method - ");
				postBox.wait();
			} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+" - Got Notification");
			System.out.println(Thread.currentThread().getName()+"Getting msg from postBox ------"+postBox.getMsg());
		}
		
	}
	
	
}
class MyNotifyThread extends Thread{
	private PostBox postBox;
	private String msg;
	public MyNotifyThread(PostBox postBox, String msg) {
		this.postBox = postBox;
		this.msg = msg;
	}
	
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (postBox) {
			
			postBox.setMsg(msg);
			System.out.println("Thread tries to give notification - ");
			postBox.notifyAll();
		}
		
	}
	
	
}

class PostBox {
	
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
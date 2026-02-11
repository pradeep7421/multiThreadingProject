package com.multiThreading.InterThreadCommunication;

import java.util.HashMap;
import java.util.Map;

public class WaitNotifyNotifyAllWithPostboxDemo {
    
    public static void main(String[] args) {
        PostBox postBox = new PostBox();
        MyWaitThread t1Wait = new MyWaitThread(postBox);
        MyWaitThread t2Wait = new MyWaitThread(postBox);
        MyNotifyThread t3Notify = new MyNotifyThread(postBox);
        
        t1Wait.start();
        t2Wait.start();
        t3Notify.start();
    }
}

class MyWaitThread extends Thread {
    private PostBox postBox;
    
    public MyWaitThread(PostBox postBox) {
        this.postBox = postBox;
    }
    
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-getting msg before notify call -" + postBox.getMsg(Thread.currentThread().getName()));
        synchronized (postBox) {
            try {
                // Store this thread's name in the PostBox's thread-specific storage
                postBox.setMsg(Thread.currentThread().getName(), Thread.currentThread().getName());
                
                System.out.println(Thread.currentThread().getName() + " - tries to call wait method - ");
                postBox.wait();
            } catch (InterruptedException e) {}
            
            System.out.println(Thread.currentThread().getName() + " - Got Notification");
            System.out.println(Thread.currentThread().getName() + " Got Notification from Notify Thread ------" + 
                              postBox.getMsg(Thread.currentThread().getName()));
        }
    }
}

class MyNotifyThread extends Thread {
    private PostBox postBox;
    
    public MyNotifyThread(PostBox postBox) {
        this.postBox = postBox;
    }
    
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        synchronized (postBox) {
            // Update each waiting thread's message with its own thread name
            for (String threadName : postBox.getThreadNames()) {
                String currentMsg = postBox.getMsg(threadName);
                if (currentMsg != null) {
                    postBox.setMsg(threadName, currentMsg + "- There is emergency call need to exit now---");
                }
            }
            
            System.out.println("Thread tries to give notification - ");
            postBox.notifyAll();
        }
    }
}

class PostBox {
    // Thread-specific message storage
    private Map<String, String> threadMessages = new HashMap<>();
    
    public String getMsg(String threadName) {
        return threadMessages.get(threadName);
    }

    public void setMsg(String threadName, String msg) {
        threadMessages.put(threadName, msg);
    }
    
    public Iterable<String> getThreadNames() {
        return threadMessages.keySet();
    }
}
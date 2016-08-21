package com.test.threads;

public class Synchronizer {

	FairLock lock = new FairLock();
	
	public void doSynchronized() throws InterruptedException{
	    this.lock.lock();
	      
	    Thread.sleep(5000);
	    //critical section, do a lot of work which takes a long time
	    this.lock.unlock();
	  }
	
	public static void main(String[] args) {
		Synchronizer synchronizer = new Synchronizer();
		
		try {
			synchronizer.doSynchronized();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

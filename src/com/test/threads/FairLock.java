package com.test.threads;

import java.util.ArrayList;
import java.util.List;

public class FairLock {

	boolean isLocked = false;
	List<QueueObject> waitingThreadList = new ArrayList<>();
	Thread lockedThread = null;

	public void lock() throws InterruptedException {
		QueueObject queueObject = new QueueObject();
		boolean isLockingThread = true;

		synchronized (this) {
			waitingThreadList.add(queueObject);
		}

		if (isLockingThread) {
			synchronized (this) {
				isLockingThread = isLocked
						|| waitingThreadList.get(0) != queueObject;

				if (!isLockingThread) {
					isLocked = true;
					waitingThreadList.remove(0);
					lockedThread = Thread.currentThread();
					return;
				}
				try {
					queueObject.doWait();
				} catch (InterruptedException e) {
					throw new InterruptedException();
				}
			}
		}

	}

	public void unlock() throws IllegalMonitorStateException{

		if(Thread.currentThread() != this.lockedThread){
			throw new IllegalMonitorStateException("Calling thread is not having Lock. Cannot unlock");
		}
		
		synchronized (this) {
			isLocked = false;
			lockedThread = null;
			if(!waitingThreadList.isEmpty()){
				waitingThreadList.get(0).doNotify();
			}
		}
	}

}

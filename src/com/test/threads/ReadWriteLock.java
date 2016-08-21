package com.test.threads;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {

	private int writers = 0;
	private int writeRequests = 0;
	Thread currentWriteThread = null;
	Map<Thread, Integer> readThreadMap = new HashMap<>();

	public synchronized void readLock() throws InterruptedException {
		Thread thread = Thread.currentThread();
		if (!canGrantAccess(thread)) {
			wait();
		}
		readThreadMap.put(thread, (getReadAccessCount(thread) + 1));
	}

	public synchronized void readUnLock() throws InterruptedException {
		Thread thread = Thread.currentThread();
		Integer threadCountLock = readThreadMap.get(thread);
		if (threadCountLock != null && threadCountLock > 0) {
			threadCountLock--;
			if (threadCountLock == 0) {
				readThreadMap.remove(thread);
				notifyAll();
			}
			readThreadMap.put(thread, threadCountLock);
		} else {
			throw new InterruptedException(
					"Calling thread has never acquired read lock");
		}
	}

	public synchronized void writeLock() throws InterruptedException{
		writeRequests++;
		Thread thread = Thread.currentThread();
		if(!canGrantWriteAccess(thread)){
			wait();
		}
		writeRequests--;
		writers++;
		currentWriteThread = thread;
	}

	public synchronized void writeUnLock() throws InterruptedException{
		Thread thread = Thread.currentThread();
		if(thread == currentWriteThread){
			writers--;
		}else{
			throw new InterruptedException("Calling thread has not acquired lock");
		}
		if(writers == 0){
			currentWriteThread = null;
		}
		notifyAll();
	}

	public boolean canGrantWriteAccess(Thread thread){
		if(readThreadMap.size() > 0){
			return false;
		}if (currentWriteThread == null) {
			return true;
		}if(!(thread == currentWriteThread)){
			return false;
		}
		return true;
	}
	
	public Integer getReadAccessCount(Thread thread) {
		Integer accessCount = readThreadMap.get(thread);
		if (accessCount == null) {
			return 0;
		}
		return accessCount;
	}

	public boolean canGrantAccess(Thread currentThread) {
		if (writers > 0) {
			return false;
		}
		if (readThreadMap.get(currentThread) != null) {
			return true;
		}
		if (writeRequests > 0) {
			return false;
		}
		return true;
	}
}
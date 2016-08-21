package com.test.threads.pool;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue {

	private List<Runnable> queue = new ArrayList<Runnable>();
	private int maxTasks;

	public BlockingQueue(int maxTasks){
		this.maxTasks = maxTasks;
	}

	public synchronized void enQueue(Runnable task) throws InterruptedException{
		
		while(this.queue.size() == maxTasks){
			wait();
		}
		
		if(this.queue.size() == 0){
			notifyAll();
		}
		this.queue.add(task);
	}

	public synchronized Runnable deQueue() throws InterruptedException{
		
		while(this.queue.size() == 0){
			wait();
		}
		
		if(this.queue.size() == maxTasks){
			notifyAll();
		}
		
		return this.queue.remove(0);
	}

}
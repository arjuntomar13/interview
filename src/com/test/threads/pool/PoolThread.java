package com.test.threads.pool;


public class PoolThread extends Thread {

	private volatile boolean isThreadStopped;
	private BlockingQueue taskQueue = null;

	public PoolThread(BlockingQueue taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void run() {

		while (!isThreadStopped) {
			try {
				Runnable runnable = taskQueue.deQueue();
				runnable.run();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception occurred "
						+ e.getMessage());
			}
		}
	}

	public void doStop() {
		isThreadStopped = true;
		this.interrupt();
	}

}

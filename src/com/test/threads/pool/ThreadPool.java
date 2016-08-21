package com.test.threads.pool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

	private BlockingQueue taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();
	private boolean isStopped;

	public ThreadPool(int numberOfThreads, int maxTasks) {
		taskQueue = new BlockingQueue(maxTasks);

		for (int i = 0; i < numberOfThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}

		for (PoolThread poolThread : threads) {
			poolThread.start();
		}
	}

	public void addTask(Runnable task) throws Exception {
		if (isStopped) {
			throw new IllegalStateException(
					"Cannot enqueue more elements. Thread Pool is stopped..!!");
		}
		this.taskQueue.enQueue(task);
	}

	public void stopThreadPool() {
		isStopped = true;
		for (PoolThread poolThread : threads) {
			poolThread.doStop();
		}
	}
}
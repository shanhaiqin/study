package com.study.promise;

import java.util.concurrent.Future;

public class DataSyncTask implements Runnable {
	
	public DataSyncTask() {
	}
	
	@Override
	public void run() {
		
		Future<TaskClientUtil> taskClientUtilPromise = TaskClientUtil.newInstance();
		TaskClientUtil taskClientUtil = null;
		try {
			taskClientUtil = taskClientUtilPromise.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		taskClientUtilPromise.cancel(true);
		doSomething(taskClientUtil);
		System.out.println(taskClientUtilPromise.isCancelled());
		System.out.println(taskClientUtilPromise.isDone());
	}
	
	private void doSomething(TaskClientUtil taskClientUtil) {
		taskClientUtil.doSomething();
	}
	
	public static void main(String[] args) {
		new Thread(new DataSyncTask()).start();
	}
}

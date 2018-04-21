package com.study.promise;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TaskClientUtil {

	private TaskClientUtil() {
		
	}

	// 模式角色：Promise.Promisor.compute
	public static Future<TaskClientUtil> newInstance() {

		Callable<TaskClientUtil> callable = new Callable<TaskClientUtil>() {

			@Override
			public TaskClientUtil call() throws Exception {
				TaskClientUtil self = new TaskClientUtil();
				self.init();
				return self;
			}

		};

		// task相当于模式角色：Promise.Promise
		final FutureTask<TaskClientUtil> task = new FutureTask<TaskClientUtil>(callable);

		/*
		 * 下面这行代码与本案例的实际代码并不一致，这是为了讨论方便。 下面新建的线程相当于模式角色：Promise.TaskExecutor
		 */
		new Thread(task).start();
		return task;
	}

	private void init() throws Exception {
		System.out.println("client init......");
	}

	public void doSomething() {
		System.out.println("do something......");
	}
}

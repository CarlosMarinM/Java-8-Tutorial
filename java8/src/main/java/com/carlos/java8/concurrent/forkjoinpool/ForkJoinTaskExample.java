package com.carlos.java8.concurrent.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTaskExample {

	public static void main(String[] args) {
		ForkJoinTaskExample app = new ForkJoinTaskExample();
		app.ejecutar();
	}

	public void ejecutar() {
		ForkJoinPool commonPool = ForkJoinPool.commonPool();

		// Recursive action. No se espera valor de retorno
		CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("Hola Mundo¡¡¡");
		commonPool.execute(customRecursiveAction);
		customRecursiveAction.join();

		// Recursive task. Se espera valor de retorno
		CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(new int[] { 1, 5, 8, 6, 4, 3, 2, 1, 8, 6, 0,
				1, 2, 5, 4, 8, 7, 5, 4, 3, 2, 1, 4, 8, 6, 5, 7, 9, 3, 2, 0, 2, 1, 5, 4, 6, 8 });
		int result = commonPool.invoke(customRecursiveTask);
		System.out.println(result);

	}

}

package com.demo.lamda.runnable;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("value of i: " + i);
		}
	}

}

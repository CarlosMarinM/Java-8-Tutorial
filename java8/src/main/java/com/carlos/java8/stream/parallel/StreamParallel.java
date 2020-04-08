package com.carlos.java8.stream.parallel;

import java.util.Arrays;

public class StreamParallel {

	public static void main(String[] args) {

		long numero1 = System.currentTimeMillis();

		int[] numeros = new int[50];

		Arrays.stream(numeros).parallel().forEach(StreamParallel::esperar);

		long numero2 = System.currentTimeMillis();
		System.out.println(numero2 - numero1);
		System.out.println(numeros.length);

	}

	public static int esperar(int numero) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numero * 2;
	}

}

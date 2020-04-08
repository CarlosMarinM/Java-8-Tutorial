package com.carlos.java8.lambda.sintaxis;

import com.carlos.java8.lambda.Operacion;

public class LambdaSintaxis {

	public double probarSintaxis() {
//		Operacion op = (double x, double y) -> (x + y) / 2;
//		Operacion op = (double x, double y) -> {
//			return (x + y) / 2;
//		};
//		Operacion op = (double x, double y) -> {
//			System.out.println(x);
//			System.out.println(y);
//			return (x + y) / 2;
//		};
		Operacion op = (x, y) -> (x + y) / 2;
//		Operacion op = () -> 2;
//		Operacion op = () -> {
//			double x = 4;
//			double y = 7;
//			return (x + y) / 2;
//		};

		return op.calcular(4, 7);
	}

	public static void main(String[] args) {
		LambdaSintaxis app = new LambdaSintaxis();
		System.out.println(app.probarSintaxis());
	}
}

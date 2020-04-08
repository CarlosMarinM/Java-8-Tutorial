package com.carlos.java8.lambda.scopes;

import com.carlos.java8.lambda.Operacion;

public class Scopes {

	private static double atributo1;
	private double atributo2;

	public double probarVariableLocal() {

		// Implementacion con Java 7
		final double n3 = 3;
		Operacion op = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				return n1 + n2 + n3;
			}
		};

		// Implementacion con Java 8
		Operacion opLambda = (x, y) -> x + y + n3;

//		return op.calcular(4, 7);
		return opLambda.calcular(4, 7);
	}

	public double probarVariablesGlobalesStatic() {

		// Implementacion con Java 7
		Operacion op = new Operacion() {

			@Override
			public double calcular(double n1, double n2) {
				atributo1 = n1 + n2;
				atributo2 = atributo1;
				return atributo2;
			}
		};

		// Implementacion con Java 8
		Operacion opLambda = (x, y) -> {
			atributo1 = x + y;
			atributo2 = atributo1;
			return atributo2;
		};

//		return op.calcular(4, 7);
		return opLambda.calcular(4, 7);
	}

	public static void main(String[] args) {
		Scopes app = new Scopes();
//		System.out.println(app.probarVariableLocal());
		System.out.println(app.probarVariablesGlobalesStatic());
	}
}

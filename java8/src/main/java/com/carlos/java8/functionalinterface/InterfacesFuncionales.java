package com.carlos.java8.functionalinterface;

public class InterfacesFuncionales {

	public double operar(double x, double y) {
		Operacion op = (n1, n2) -> n1 + n2;
		return op.calcular(x, y);
	}

	public static void main(String[] args) {
		InterfacesFuncionales app = new InterfacesFuncionales();
		System.out.println(app.operar(4, 7));
	}

}

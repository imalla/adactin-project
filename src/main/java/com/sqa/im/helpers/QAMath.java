
package com.sqa.im.helpers;

public class QAMath {

	public static int addNumbers(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public static double square(double num, double pow) {
		double result = Math.pow(num, pow);
		return result;
	}

	public static int subtractNumbers(int num1, int num3) {
		return num1 - num3;
	}

	private int total;

	public int addNumber(int num) {
		// total+=num;
		// return total;
		setTotal(getTotal() + num);
		return getTotal();
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int square(int pow) {
		return pow;
	}

	public int subNumber(int num) {
		return num;
	}
}

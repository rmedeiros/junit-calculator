package es.um.calso.calculator.main;

import es.um.calso.calculator.exeception.NonDivisionByZeroExeption;

public class Operations {

	public Operations() {
	}

	/**
	 * calculates the addition of two numbers
	 * @param a
	 *            first argument of the addition
	 * @param b
	 *            second argument of the addition
	 * @return addition of numbers a and b
	 */
	public int addition(int a, int b) {
		return a + b;
	}

	/**
	 * calculates the substraction of two numbers
	 * @param a
	 *            first argument of the substraction
	 * @param b
	 *            second argument of the substraction
	 * @return substraction of numbers a and b
	 */
	public int substraction(int a, int b) {
		return a - b;
	}

	/**
	 * calculates the division of two numbers
	 * @param a
	 *            numerator argument of the substraction
	 * @param b
	 *            denominator argument of the substraction
	 * @return  result of a divided by b
	 * @throws NonDivisionByZeroExeption if the denominator i.e. b parameter is 0 throws an exception
	 *                
	 */
	public int division(int a, int b) throws NonDivisionByZeroExeption {
		if (b == 0) {
			throw new NonDivisionByZeroExeption("You cannot divide by zero");
		}
		return a / b;
	}

	
	/**
	 * calculates the multiplication of two numbers
	 * @param a
	 *            first argument of the multiplication
	 * @param b
	 *            second argument of the multiplication
	 * @return  multiplication of numbers a and b
	 */
	public int multiplication(int a, int b) {
		return a * b;
	}

	
	/**
	 * given two numbers calculates the biggest one
	 * @param a
	 *            first argument of the number comparation
	 * @param b
	 *            second argument of the comparation
	 * @return returns the biggest number from a and b
	 */
	public int biggest(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
	/**
	 * given two numbers calculates the smallest one
	 * @param a
	 *            first argument of the number comparation
	 * @param b
	 *            second argument of the comparation
	 * @return returns the smallest number from a and b
	 */
	public int smallest(int a, int b) {
		if (a > b) {
			return b;
		} else {
			return a;
		}
	}

}

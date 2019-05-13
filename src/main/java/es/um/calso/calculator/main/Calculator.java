package es.um.calso.calculator.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.um.calso.calculator.exeception.NonDivisionByZeroExeption;

public class Calculator {

	public static void main(String[] args) {
		Operations op = new Operations();
		int selection = 0;
		int a, b, result;
		Scanner sc = new Scanner(System.in);
		while (selection != 7) {
			try {
				System.out.println("\nWelcome to a simple calculator!\n Select the operation you want to perform:");
				System.out.println("1. Addition");
				System.out.println("2. Substraction");
				System.out.println("3. Division");
				System.out.println("4. Multiplication");
				System.out.println("5. Biggest of two numbers");
				System.out.println("6. Smallest of two numbers");
				System.out.println("7. Close the calculator");
				selection = sc.nextInt();
				switch (selection) {
				case 1:
					System.out.println("You want to perform an addition write the first argument:");
					a = sc.nextInt();
					System.out.println("Now enter the second argument:");
					b = sc.nextInt();
					result = op.addition(a, b);
					System.out.println("The result is: " + result);
					break;
				case 2:
					System.out.println("You want to perform a substraction write the first argument:");
					a = sc.nextInt();
					System.out.println("Now enter the second argument:");
					b = sc.nextInt();
					result = op.substraction(a, b);
					System.out.println("The result is: " + result);
					break;
				case 3:
					System.out.println("You want to perform a division write the numerator:");
					a = sc.nextInt();
					System.out.println("Now enter the denominator:");
					b = sc.nextInt();
					try {
						result = op.division(a, b);
						System.out.println("The result is: " + result);
					} catch (NonDivisionByZeroExeption e) {
						System.out.println("OH! You cannot divide by zero try again");
					}
					break;
				case 4:
					System.out.println("You want to perform a multiplication write the first argument:");
					a = sc.nextInt();
					System.out.println("Now enter the second argument:");
					b = sc.nextInt();
					result = op.multiplication(a, b);
					System.out.println("The result is: " + result);
					break;
				case 5:
					System.out.println("You want to perform a biggest comparation write the first argument:");
					a = sc.nextInt();
					System.out.println("Now enter the second argument:");
					b = sc.nextInt();
					result = op.biggest(a, b);
					System.out.println("The biggest one is: " + result);
					break;
				case 6:
					System.out.println("You want to perform a smallest comparation write the first argument:");
					a = sc.nextInt();
					System.out.println("Now enter the second argument:");
					b = sc.nextInt();
					result = op.addition(a, b);
					System.out.println("The smallest one is: " + result);
					break;
				case 7:
					System.out.println("Good bye!!");
					break;
				default:
					System.out.println("Select a correct option between 1 and 7");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Select a correct option between 1 and 7");
			    sc.next(); // this consumes the invalid token
			}
		}
		sc.close();
	}

}
